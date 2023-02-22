package com.example.viewpageres

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.IBinder;
import android.provider.SyncStateContract
import android.util.Log;
import androidx.core.content.PackageManagerCompat
import java.util.concurrent.TimeUnit


class ForegroundService : Service() {
    override fun onCreate() {
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {

        for (i in 0..100){
            Log.d("workmng", "doWork: start")
            //Toast.makeText(applicationContext,"${i}",Toast.LENGTH_LONG).show()
            try {
                TimeUnit.SECONDS.sleep(3)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }

        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(LOG_TAG, "In onDestroy")
    }

    override fun onBind(intent: Intent?): IBinder? {
        // Used only in case of bound services.
        return null
    }

    companion object {
        private const val LOG_TAG = "ForegroundService"
    }
}