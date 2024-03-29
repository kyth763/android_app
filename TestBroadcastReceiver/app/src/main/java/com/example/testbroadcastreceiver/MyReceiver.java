package com.example.testbroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {
    private static final String TAG = "RelayReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive action=" + intent.getAction());
        Intent i = new Intent();
        i.setPackage("com.example.testbroadcastreceiverclient");
        i.setAction("com.example.testbroadcastreceiver.MYACTION");
        context.sendBroadcast(i);
    }
}
