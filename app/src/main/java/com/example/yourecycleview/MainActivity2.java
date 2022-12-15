package com.example.yourecycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    TextView textView1 ,textView2,textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        String userget = intent.getStringExtra("userget");
        String tileGet = intent.getStringExtra("tileGet");
        String bodyGet = intent.getStringExtra("bodyGet");
        textView1 = findViewById(R.id.userId);
        textView2 = findViewById(R.id.title);
        textView3 = findViewById(R.id.body);

        textView1.setText(userget);
        textView2.setText(tileGet);
        textView3.setText(bodyGet);


        try {
            FileReader in = new FileReader("filename");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //File cachefile = new File(this.getCacheDir(), filename)









    }
}