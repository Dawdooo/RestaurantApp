package com.example.restaurantapp

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatDelegate
import com.example.restaurantapp.databinding.ActivityFoodTruckBinding

class FoodTruckActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFoodTruckBinding
    override fun onResume() {
        supportActionBar?.hide()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onResume()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoodTruckBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (Build.VERSION.SDK_INT >= 21) {
            val window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = this.resources.getColor(R.color.green)
        }
        binding.sendMsgTxt.setOnClickListener {
            val contactIntent = Intent(applicationContext, ContactActivity::class.java)
            startActivity(contactIntent)
        }
    }
}