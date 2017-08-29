package com.example.administrator.retrofitdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.rxjavademo.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;

import java.io.IOException;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by Administrator on 2017/8/28.
 */
public class RetrofitDemo extends Activity {

    private Button rt_button;
    private APIService apiService;
    private TextView retrofit_tv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        rt_button = (Button) findViewById(R.id.rt_button);
        retrofit_tv = (TextView) findViewById(R.id.retrofit_tv);
        rt_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Gson gson = new GsonBuilder()
                        .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                        .create();

                OkHttpClient client = new OkHttpClient();
                client.interceptors().add(new Interceptor() {
                    @Override
                    public com.squareup.okhttp.Response intercept(Chain chain) throws IOException {
                        com.squareup.okhttp.Response response = chain.proceed(chain.request());

                        // Do anything with response here
                        Log.e("mrgao", ",response：" + response);
                        return response;
                    }
                });

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://www.oschina.net/action/apiv2/")
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .client(client)
                        .build();

                apiService = retrofit.create(APIService.class);
                Call<Users> usersCall = apiService.loadUsers();
                /* //同步线程
                Response<Users> execute = usersCall.execute();
                Log.e("mrgao","data:"+execute.code());*/
                //异步线程
               usersCall.enqueue(new Callback<Users>() {
                    @Override
                    public void onResponse(Response<Users> response) {
                        Log.e("mrgao", "respose Code:" + response.code()+",response.body():"+response.body()+",response.message():"+response.message());
                        retrofit_tv.setText("respose Code:" + response.code()+",response.body():"+response.body()+",response.message():"+response.message());
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        Log.e("mrgao", "Throwable:" + t);
                        retrofit_tv.setText("Throwable:"+t);
                    }
                });

            }
        });
    }
}
