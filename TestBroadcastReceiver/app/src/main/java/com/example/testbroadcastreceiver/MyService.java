package com.example.testbroadcastreceiver;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyService extends Service {
    private static final String TAG = "MyService";

    private MyReceiver myReceiver = new MyReceiver();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate");
        super.onCreate();
        //IntentFilter intentFilter = new IntentFilter();
        //intentFilter.addAction("com.example.testbroadcastreceiver.MYACTION");
        //try {
        //    registerReceiver(myReceiver, intentFilter);
        //} catch (IllegalArgumentException e) {
        //    Log.e(TAG, "registerReceiver already registered:", e);
        //}
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy");
        //unregisterReceiver(myReceiver);
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand");
        return START_STICKY;
    }
}
