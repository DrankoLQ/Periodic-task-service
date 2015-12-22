package com.daniellq.periodic_task_service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by dani on 22/12/15.
 */
public class NotificationReceiver extends BroadcastReceiver {
    public static final int REQUEST_CODE = 12345;

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent serviceIntent = new Intent(context, NotificationService.class);
        context.startService(serviceIntent);
    }
}
