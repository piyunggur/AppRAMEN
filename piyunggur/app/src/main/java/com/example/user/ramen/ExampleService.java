package com.example.user.ramen;


import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.IBinder;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.constraint.Group;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.example.user.ramen.Activity.MainActivity;

import static android.app.NotificationManager.IMPORTANCE_HIGH;
import static com.example.user.ramen.App.CHANNEL_ID;


public class ExampleService extends Service{


    //creating a mediaplayer object
    private MediaPlayer player;

    @Override
    public void onCreate(){
        super.onCreate();
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


//    @Override
//    public int onStartCommand(Intent intent, int flages, int startId){
//
//
//        String input = intent.getStringExtra("inputExtra");
//
//
//        Intent notificationIntent = new Intent(this,TestForegroundServiceActivity.class);
//        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
//                notificationIntent, 0);
//
//        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
//                .setContentTitle("Example Service")
//                .setContentText(input)
//                .setSmallIcon(R.drawable.logo)
//                .setContentIntent(pendingIntent)
//                .build();
//
//        startForeground(1,notification);
//
//
//        return START_NOT_STICKY;
//
//    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public int onStartCommand(Intent intent, int flags, final int startId) {
        Log.d("test", "onStartCommand");

        String input = intent.getStringExtra("inputExtra");

        Intent notificationIntent = new Intent(this,TestForegroundServiceActivity.class);



        NotificationChannel notificationChannel = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            notificationChannel = new NotificationChannel(CHANNEL_ID,
                    "Channel 1", IMPORTANCE_HIGH);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.setShowBadge(true);
            notificationChannel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
            NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            manager.createNotificationChannel(notificationChannel);
        }

        Bitmap icon = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);


        Notification notification = new NotificationCompat.Builder(this,CHANNEL_ID)
                .setContentTitle("Example Service")
                .setContentText(input)
                .setSmallIcon(R.drawable.logo)
                .setLargeIcon(icon)
                .build();

//        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
//                .setContentTitle("Example Service")
//                .setContentText(input)
//                .setSmallIcon(R.drawable.logo)
//                .setContentIntent(pendingIntent)
//                .build();

        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        notification.contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);

        startForeground(1, notification);

        player = MediaPlayer.create(this,
                Settings.System.DEFAULT_RINGTONE_URI);
        //setting loop play to true
        //this will make the ringtone continously playing
        player.setLooping(true);

        //staring the player
        player.start();


        return START_STICKY;
    }



    @Override
    public void onDestroy(){
        super.onDestroy();

        player.stop();
    }


}
