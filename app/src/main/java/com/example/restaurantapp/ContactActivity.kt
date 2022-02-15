package com.example.restaurantapp

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.app.ActivityCompat
import com.example.restaurantapp.databinding.ActivityContactBinding
import com.example.restaurantapp.databinding.ActivityMainBinding

class ContactActivity : AppCompatActivity() {
    private lateinit var binding: ActivityContactBinding
    val number = "999999999"
    val REQUEST_PHONE_CALL = 1

    override fun onResume() {
        supportActionBar?.hide()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onResume()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityContactBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (Build.VERSION.SDK_INT >= 21) {
            val window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = this.resources.getColor(R.color.green)
        }

        binding.contactMap.setOnClickListener {
            val intent: Intent = Intent(applicationContext, restaurantsActivity::class.java)
            startActivity(intent)
        }
        binding.contactSendMsg.setOnClickListener {
            val intent: Intent = Intent(applicationContext, SendMessage::class.java)
            startActivity(intent)
        }

        binding.contactCall.setOnClickListener {

            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.CALL_PHONE),
                    REQUEST_PHONE_CALL
                )
            } else {
                startCall()

            }
        }
    }

    private fun startCall() {
        val intent = Intent(Intent.ACTION_CALL)
        intent.setData(Uri.parse("tel:" + number))
        startActivity(intent)
    }

    @SuppressLint("MissingSuperCall")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == REQUEST_PHONE_CALL) startCall()
    }

}