package com.sdaacademy.zientara.rafal.awesomeservices.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.sdaacademy.zientara.rafal.awesomeservices.BuildConfig;
import com.sdaacademy.zientara.rafal.awesomeservices.MainActivity;

public class AwesomeService extends Service {

    public static final String TAG = AwesomeService.class.getSimpleName();

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand");


        if (intent != null) {
            if(intent.hasExtra(MainActivity.KLUCZ)) {
                String s = intent.getStringExtra(MainActivity.KLUCZ);
                Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
            }
        }

        return Service.START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind");
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");

        Intent intent = new Intent();
        intent.setAction(MainActivity.MainActivityReceiver.ACTION_SERVICE_DEAD);
        sendBroadcast(intent);
/*
        //// TODO: 16.02.2017 co to jest BuildConfig?
        if(BuildConfig.DEBUG) {
            Toast.makeText(this, "Dodatkowy Toast widoczny tylko w trybie debug\nx_X", Toast.LENGTH_SHORT).show();
        }*/
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate");
        Toast.makeText(this, ":D", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG, "onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Log.i(TAG, "onRebind");
    }

    @Override
    public void onTaskRemoved(Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
        Log.i(TAG, "onTaskRemoved");
    }
}
