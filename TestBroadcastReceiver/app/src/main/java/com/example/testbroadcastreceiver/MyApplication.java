package com.example.testbroadcastreceiver;

import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

public class MyApplication extends Application {
    private static final String TAG = "MyApplication";
    private MyReceiver myReceiver = new MyReceiver();
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
        Intent serviceIntent = new Intent();
        serviceIntent.setClass(getApplicationContext(), MyService.class);
        getApplicationContext().startService(serviceIntent);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.testbroadcastreceiver.MYACTION");
        try {
            registerReceiver(myReceiver, intentFilter);
        } catch (IllegalArgumentException e) {
            Log.e(TAG, "registerReceiver already registered:", e);
        }
    }
}
