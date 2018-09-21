package com.example.user.ramen;


import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

import static com.example.user.ramen.App.CHANNEL_ID;


public class ExampleService extends Service{


    @Override
    public void onCreate(){
        super.onCreate();
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public int onStartCommand(Intent intent, int flages, int startId){


        String input = intent.getStringExtra("inputExtra");


        Intent notificationIntent = new Intent(this,TestForegroundServiceActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
                notificationIntent, 0);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("Example Service")
                .setContentText(input)
                .setSmallIcon(R.drawable.logo)
                .setContentIntent(pendingIntent)
                .build();

        startForeground(1,notification);


        return START_NOT_STICKY;

    }


    @Override
    public void onDestroy(){
        super.onDestroy();
    }


}
