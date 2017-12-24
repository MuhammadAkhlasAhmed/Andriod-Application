package com.example.muhammadikhlas.myapplication;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;

import android.support.v4.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFireBaseMessagingService extends FirebaseMessagingService {
    public MyFireBaseMessagingService() {
    }


    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        ikhlasnotification(remoteMessage.getNotification().getBody());
    }


private void ikhlasnotification(String msg){

Intent intent =new Intent(this,FirebaseNotificationResultActivity.class);
    intent.putExtra("Moviename",msg);
    intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
    //Ye pending ager activity bund hogi tw khol dega
    PendingIntent pd=PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT);

    Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

    NotificationCompat.Builder notification=new NotificationCompat.Builder(this);
    notification.setSmallIcon(R.drawable.ic_stat_name);
    notification.setContentTitle("Recommendation System");
    notification.setContentText(msg);
    notification.setAutoCancel(true);
    notification.setSound(defaultSoundUri);
    notification.setContentIntent(pd);


    NotificationManager nm=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
    nm.notify(0,notification.build());







}

}
