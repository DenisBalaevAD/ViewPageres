package com.example.viewpageres

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.util.concurrent.TimeUnit


class UploadWorker(appContext: Context, workerParams: WorkerParameters):
    Worker(appContext, workerParams) {

    val TAG = "workmng"

    override fun doWork(): Result {

            Log.d(TAG, "doWork: start")
            //Toast.makeText(applicationContext,"${i}",Toast.LENGTH_LONG).show()
            try {
                TimeUnit.SECONDS.sleep(3)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }

        Log.d(TAG, "doWork: start")
        //Toast.makeText(applicationContext,"${i}",Toast.LENGTH_LONG).show()
        try {
            TimeUnit.SECONDS.sleep(3)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        Log.d(TAG, "doWork: start")
        //Toast.makeText(applicationContext,"${i}",Toast.LENGTH_LONG).show()
        try {
            TimeUnit.SECONDS.sleep(3)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        Log.d(TAG, "doWork: start")
        //Toast.makeText(applicationContext,"${i}",Toast.LENGTH_LONG).show()
        try {
            TimeUnit.SECONDS.sleep(3)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        Log.d(TAG, "doWork: start")
        //Toast.makeText(applicationContext,"${i}",Toast.LENGTH_LONG).show()
        try {
            TimeUnit.SECONDS.sleep(3)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        Log.d(TAG, "doWork: start")
        //Toast.makeText(applicationContext,"${i}",Toast.LENGTH_LONG).show()
        try {
            TimeUnit.SECONDS.sleep(3)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        Log.d(TAG, "doWork: start")
        //Toast.makeText(applicationContext,"${i}",Toast.LENGTH_LONG).show()
        try {
            TimeUnit.SECONDS.sleep(3)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        Log.d(TAG, "doWork: start")
        //Toast.makeText(applicationContext,"${i}",Toast.LENGTH_LONG).show()
        try {
            TimeUnit.SECONDS.sleep(3)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        Log.d(TAG, "doWork: start")
        //Toast.makeText(applicationContext,"${i}",Toast.LENGTH_LONG).show()
        try {
            TimeUnit.SECONDS.sleep(3)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        Log.d(TAG, "doWork: start")
        //Toast.makeText(applicationContext,"${i}",Toast.LENGTH_LONG).show()
        try {
            TimeUnit.SECONDS.sleep(3)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        Log.d(TAG, "doWork: end")

        return Result.success()
    }
}