package com.example.roomdatabasedemo.network;

import com.example.roomdatabasedemo.model.Post;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface ApiInterface {

    @GET("posts")
    Call<List<Post>> getPost(@QueryMap Map<String, String> parameters);

//    @GET
//    Call<List<Comment>> getComment(@Url String url);

}
