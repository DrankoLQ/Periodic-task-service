package com.daniellq.periodic_task_service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnStartService = (Button) findViewById(R.id.btnStartService);
        Button btnStopService = (Button) findViewById(R.id.btnStopService);
        btnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scheduleTask();
            }
        });

        btnStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPeriodicTask();
            }
        });
    }

    public void scheduleTask() {
        Intent intent = new Intent(getApplicationContext(), NotificationReceiver.class);
        final PendingIntent pendingIntent = PendingIntent.getBroadcast(this,
                NotificationReceiver.REQUEST_CODE, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        long firstMs = System.currentTimeMillis();
        AlarmManager alarm = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        long interval = 3000L; // Interval is set to 30 seconds
        alarm.setInexactRepeating(AlarmManager.RTC_WAKEUP, firstMs,
                interval, pendingIntent);
        Toast.makeText(this, R.string.task_started, Toast.LENGTH_SHORT).show();
    }

    public void stopPeriodicTask() {
        Intent intent = new Intent(getApplicationContext(), NotificationReceiver.class);
        final PendingIntent pendingIntent = PendingIntent.getBroadcast(this,
                NotificationReceiver.REQUEST_CODE, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarm = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        alarm.cancel(pendingIntent);
        Toast.makeText(this, R.string.task_stooped, Toast.LENGTH_SHORT).show();
    }
}
