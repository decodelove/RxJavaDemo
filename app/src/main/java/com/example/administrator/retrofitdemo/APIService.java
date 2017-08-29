package com.example.administrator.retrofitdemo;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by Administrator on 2017/8/29.
 */
public interface APIService {
    @POST("banner?catalog=1")
    Call<Users> loadUsers();
}
