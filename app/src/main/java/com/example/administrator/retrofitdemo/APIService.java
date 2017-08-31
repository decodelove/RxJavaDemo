package com.example.administrator.retrofitdemo;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by Administrator on 2017/8/29.
 */
public interface APIService {
    //    @POST("book/search")
//    @GET("book/search")
//    Call<Users> loadUsers();
    @GET("book/search")
    Call<Users> loadUsers(@Query("q") String name,
                          @Query("tag") String tag, @Query("start") int start,
                          @Query("count") int count);
}
