package com.example.restaurantapp

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import androidx.appcompat.app.AppCompatDelegate
import com.example.restaurantapp.databinding.ActivitySuccessOrderBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class SuccessOrderActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySuccessOrderBinding
    private lateinit var database: DatabaseReference
    override fun onResume() {
        supportActionBar?.hide()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onResume()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuccessOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val rateError = Toast.makeText(
            applicationContext,
            "something went wrong",
            Toast.LENGTH_SHORT
        )

        val intent = Intent(applicationContext, MainActivity::class.java)



        binding.endButton.setOnClickListener {
            if (binding.ratingBar.rating.toString() != "0.0") {
                database = FirebaseDatabase.getInstance().getReference("Appliction rates")
                var rateText: String = binding.ratingBar.rating.toString()
                database.child("Rate").setValue(rateText).addOnSuccessListener {
                    startActivity(intent)
                }.addOnFailureListener {
                    rateError.show()
                }
            } else {
                startActivity(intent)
            }
        }
    }
}