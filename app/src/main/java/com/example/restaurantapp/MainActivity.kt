package com.example.restaurantapp

import android.app.Activity
import android.content.Intent
import android.content.Intent.ACTION_VIEW
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.example.restaurantapp.databinding.ActivityMainBinding
import com.example.restaurantapp.databinding.ActivityMenuBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onResume() {
        supportActionBar?.hide()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onResume()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.menuCV.setOnClickListener {
            val intent: Intent = Intent(applicationContext, MenuActivity::class.java)
            startActivity(intent)
        }

        binding.deliveryCV.setOnClickListener {
            val intent: Intent = Intent(applicationContext, DeliveryActivity::class.java)
            startActivity(intent)
        }

        binding.deliveryCV.setOnClickListener {
            val intent: Intent = Intent(applicationContext, DeliveryActivity::class.java)
            startActivity(intent)
        }
        binding.foodtruckCV.setOnClickListener {
            val intent: Intent = Intent(applicationContext, FoodTruckActivity::class.java)
            startActivity(intent)
        }

        binding.galleryCV.setOnClickListener {
            val intent: Intent = Intent(applicationContext, GalleryActivity::class.java)
            startActivity(intent)
        }
        binding.premisesCV.setOnClickListener {
            val intent: Intent = Intent(applicationContext, restaurantsActivity::class.java)
            startActivity(intent)
        }
        binding.contactCV.setOnClickListener {
            val intent: Intent = Intent(applicationContext, ContactActivity::class.java)
            startActivity(intent)
        }

    }
}