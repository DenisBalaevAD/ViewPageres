package com.example.viewpageres

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import androidx.work.WorkRequest
import com.example.viewpageres.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var uploadWorkRequest: WorkRequest

    lateinit var sharedPref:SharedPreferences

    private val APP_PREFERENCES = "worker"
    private val APP_PREFERENCES_NAME = "WorkerID"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*val adapter = MyAdapter(supportFragmentManager)
        val viewPager = binding.viewpager
        viewPager.adapter = adapter // устанавливаем адаптер

        viewPager.currentItem = 1 // выводим второй экран*/

        sharedPref = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
    }

    override fun onStart() {
        super.onStart()

        val mShared = sharedPref.getString(APP_PREFERENCES_NAME,"")
        if(mShared!!.isNotEmpty()) {
            WorkManager.getInstance(applicationContext).cancelAllWorkByTag(mShared);

            /*val serviceIntent = Intent(this, ForegroundService::class.java)
            stopService(serviceIntent)*/

            sharedPref.edit().remove(APP_PREFERENCES_NAME).apply()
            sharedPref.edit().clear().apply()
            Toast.makeText(applicationContext,"Clear",Toast.LENGTH_LONG).show()
        }

        uploadWorkRequest = OneTimeWorkRequest.Builder(UploadWorker::class.java)
            .build()

    }

    override fun onStop() {
        WorkManager
            .getInstance(this)
            .enqueue(uploadWorkRequest);

        /*val serviceIntent = Intent(this, ForegroundService::class.java)
        ContextCompat.startForegroundService(this, serviceIntent)*/

        sharedPref.edit().putString(APP_PREFERENCES_NAME,uploadWorkRequest.id.toString()).apply()
        //sharedPref.edit().putString(APP_PREFERENCES_NAME,"1").apply()
        Toast.makeText(applicationContext,"Stop",Toast.LENGTH_LONG).show()

        super.onStop()
    }

    /*override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
        when (event!!.keyCode) {
            KeyEvent.KEYCODE_BACK -> {
                Toast.makeText(this,"KEYCODE_BACK",Toast.LENGTH_LONG).show()
            }
        }
        return super.onKeyUp(keyCode, event)
    }

    override fun dispatchKeyEvent(event: KeyEvent): Boolean {
        when (event.keyCode) {
            KeyEvent. -> {
                Toast.makeText(this,"KEYCODE_BACK",Toast.LENGTH_LONG).show()
            }
        }
        return super.dispatchKeyEvent(event);
    }*/

    class MyAdapter internal constructor(fm: FragmentManager) : FragmentPagerAdapter(fm) {
        override fun getCount(): Int {
            return 3
        }

        override fun getItem(position: Int): Fragment {
            return when (position) {
                0 -> Fragment_1()
                1 -> Fragment_2()
                2 -> Fragment_2()
                else -> Fragment_1()
            }
        }
    }

    fun buttonWorkManager(view: View) {
        WorkManager
            .getInstance(this)
            .enqueue(uploadWorkRequest!!);
    }
}