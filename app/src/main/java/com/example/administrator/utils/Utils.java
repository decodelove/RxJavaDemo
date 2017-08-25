package com.example.administrator.utils;

import android.os.Looper;

/**
 * Created by Administrator on 2017/8/25.
 */

public final class Utils {

    private Utils(){}

    public static void checkNotMain() {
        if(isMain()) {
            throw new IllegalStateException("Method call should not happen from the main thread.");
        }
    }

    static void checkMain() {
        if(!isMain()) {
            throw new IllegalStateException("Method call should happen from the main thread.");
        }
    }

    static boolean isMain() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
