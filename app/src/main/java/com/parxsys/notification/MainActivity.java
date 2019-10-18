package com.parxsys.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //created branch in github

        Toast.makeText(MainActivity.this, "Welcome!", Toast.LENGTH_SHORT).show();

        NotificationCompat.Builder builder =new NotificationCompat.Builder(this,"123")
                .setContentTitle("MY NOTIFICATION")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentText("Notification body comes here!")
                .setDefaults(NotificationCompat.DEFAULT_SOUND|NotificationCompat.DEFAULT_VIBRATE);


        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel=new NotificationChannel("123","123", NotificationManager.IMPORTANCE_HIGH);
            NotificationManager manager=getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }


        NotificationManagerCompat notificationManagerCompat=NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(123,builder.build());
    }
}
