package com.example.testbroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BootReceiver extends BroadcastReceiver {
    private static final String TAG = "BootReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive:" + intent.getAction());
        //Intent serviceIntent = new Intent();
        //serviceIntent.setClass(context, MyService.class);
        //context.startService(serviceIntent);
    }
}
