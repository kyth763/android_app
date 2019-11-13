package com.example.testbroadcastreceiver;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ForegroundService extends Service {
    private static final String TAG = "ForegroundService";

    private MyReceiver myReceiver = new MyReceiver();

    public static void start(@NonNull Context context) {
        Intent intent = new Intent(context, ForegroundService.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();

        NotificationHelper notificationHelper = new NotificationHelper(this);
        Notification.Builder builder = notificationHelper.getNotification();
        startForeground(2, builder.build());

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.testbroadcastreceiver.MYACTION_RELAY");
        try {
            registerReceiver(myReceiver, intentFilter);
        } catch (IllegalArgumentException e) {
            Log.e(TAG, "registerReceiver already registered:", e);
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
