package com.example.yourecycleview;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IJsonApi {
    @GET("/posts")


    Call<List <Post>> getPost();
}
