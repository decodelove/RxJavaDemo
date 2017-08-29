package com.example.administrator.rxjavademo;

/**
 * Created by Administrator on 2017/8/28.
 */
public class FirstEvent {
    private final String Mmsg;

    public FirstEvent(String msg) {
        this.Mmsg = msg;
    }

    public String getMsg(){
        return Mmsg;
    }
}
