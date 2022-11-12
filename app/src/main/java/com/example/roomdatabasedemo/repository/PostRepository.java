package com.example.roomdatabasedemo.repository;

import android.app.Activity;
import android.widget.Toast;

import com.example.roomdatabasedemo.model.Post;
import com.example.roomdatabasedemo.network.ApiClient;
import com.example.roomdatabasedemo.network.ApiInterface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostRepository {
    ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

   public void getPostedData(Activity activity){
       Map<String, String> parameters = new HashMap<>();

       parameters.put("userId","1");
       parameters.put("_sort","id");
       parameters.put("_order","desc");
       Call<List<Post>> call = apiInterface.getPost(parameters);

       call.enqueue(new Callback<List<Post>>() {
           @Override
           public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
               if(response.isSuccessful()){
                   Toast.makeText(activity, "Posted Data : "+response.body().size(), Toast.LENGTH_SHORT).show();
               }
           }

           @Override
           public void onFailure(Call<List<Post>> call, Throwable t) {

           }
       });

   }
}
