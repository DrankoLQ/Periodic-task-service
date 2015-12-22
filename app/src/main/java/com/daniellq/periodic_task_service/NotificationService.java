package com.daniellq.periodic_task_service;

import android.app.IntentService;
import android.app.NotificationManager;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

/**
 * Created by dani on 22/12/15.
 */
public class NotificationService extends IntentService {
    private static final String DEBUG_CONTEXT = "NotificationService";

    public NotificationService() {
        super("NotificationService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        // TODO: write your task here
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_notification)
                .setContentTitle("Periodict Task")
                .setContentText("This is a periodic task notification");
        int mNotificationId = 1;
        NotificationManager mNotifyManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        mNotifyManager.notify(mNotificationId, mBuilder.build());
    }
}
