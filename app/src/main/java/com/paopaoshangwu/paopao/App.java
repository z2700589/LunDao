package com.paopaoshangwu.paopao;

import android.app.Application;

import java.util.Map;

/**
 * Created by pao on 17-4-7.
 */

public class App extends Application {

    public static Map<String, Long> map;
    private static App mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;


        //SMSSDK.getInstance().initSdk(mContext);
        // SMSSDK.getInstance().setIntervalTime(60000);
    }

    public static App getContext() {
        return mContext;
    }

}
