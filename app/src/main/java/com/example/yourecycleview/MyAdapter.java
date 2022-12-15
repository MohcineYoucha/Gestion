package com.example.yourecycleview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context context;
    private List<Post> postList;
    private  Irecycler irecycler ;

    public MyAdapter(Context context ,List<Post> postArrayLista) {
        this.context = context;
        this.postList = postArrayLista;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);

        View view= inflater.inflate(R.layout.order_items,parent,false);

        return new MyViewHolder(view,irecycler);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Post currentpost =  postList.get(position);
        String userget = String.valueOf(currentpost.getUserId());
        String tileGet = currentpost.getTitle();
        String bodyGet = currentpost.getBody();

        holder.body.setText(bodyGet);
        holder.title.setText(tileGet);
        holder.userid.setText(userget);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,MainActivity2.class);
                intent.putExtra("bodyGet",postList.get(position).getBody());
                intent.putExtra("tileGet",postList.get(position).getTitle());
                intent.putExtra("userget",postList.get(position).getUserId());



                // FILES

                try {
                    FileWriter out = new FileWriter("nomFichier");
                    out.write(postList.get(position).getUserId() + "||" + postList.get(position).getTitle()+ "||"+postList.get(position).getUserId()+"\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                context.startActivity(intent);

//
//                String filename = "stocker";
//                String fileContents = "userId , Title";
//
//                try {
//                    File.createTempFile(filename, null, context.getCacheDir());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//
//                FileOutputStream Crfile = null;
//                try {
//                    Crfile = context.openFileOutput(filename, Context.MODE_PRIVATE);
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                }
//                Crfile.write(fileContents.toByteArray());


            }
        });





    }



    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView userid ,title, body;
        CardView cardView;
        public MyViewHolder(@NonNull View itemView ,Irecycler irecycler) {
            super(itemView);
            userid = itemView.findViewById(R.id.userId);
            title = itemView.findViewById(R.id.title);
            body = itemView.findViewById(R.id.body);
            cardView = itemView.findViewById(R.id.card);
//


        }
    }
}
