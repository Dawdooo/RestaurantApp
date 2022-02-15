package com.example.restaurantapp

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.isVisible
import com.example.restaurantapp.databinding.ActivityDeliveryBinding
import com.example.restaurantapp.databinding.ActivityMainBinding

class DeliveryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDeliveryBinding
    override fun onResume() {
        supportActionBar?.hide()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        if (Build.VERSION.SDK_INT >= 21) {
            val window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = this.resources.getColor(R.color.green)
        }
        super.onResume()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDeliveryBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.checkButton.setOnClickListener {

            when (binding.cityInPut.text.toString().uppercase().trim()) {
                "WROCŁAW" -> {
                    if (binding.adressInPut.text.toString().uppercase().trim() in wroStreet) {
                        binding.inZone.isVisible = true
                        binding.orderBtn.isVisible = true
                    } else {
                        binding.inZone.isVisible = false
                        val toast = Toast.makeText(
                            applicationContext,
                            "you are out of the zone or entered something incorrectly",
                            Toast.LENGTH_SHORT
                        )
                        toast.show()
                    }
                }
                "WARSZAWA" -> {
                    if (binding.adressInPut.text.toString().uppercase().trim() in wwaStreet) {
                        binding.inZone.isVisible = true
                        binding.orderBtn.isVisible = true
                    } else {
                        binding.inZone.isVisible = false
                        val toast = Toast.makeText(
                            applicationContext,
                            "you are out of the zone or entered something incorrectly",
                            Toast.LENGTH_SHORT
                        )
                        toast.show()
                    }
                }
                "KRAKÓW" -> {
                    if (binding.adressInPut.text.toString().uppercase().trim() in krkStreet) {
                        binding.inZone.isVisible = true
                        binding.orderBtn.isVisible = true
                    } else {
                        binding.inZone.isVisible = false
                        val toast = Toast.makeText(
                            applicationContext,
                            "you are out of the zone or entered something incorrectly",
                            Toast.LENGTH_SHORT
                        )
                        toast.show()
                    }
                }
                "GDAŃSK" -> {
                    if (binding.adressInPut.text.toString().uppercase().trim() in gdStreet) {
                        binding.inZone.isVisible = true
                        binding.orderBtn.isVisible = true
                    } else {
                        binding.inZone.isVisible = false
                        val toast = Toast.makeText(
                            applicationContext,
                            "you are out of the zone or entered something incorrectly",
                            Toast.LENGTH_SHORT
                        )
                        toast.show()
                    }
                }
                else -> {
                    binding.inZone.isVisible = false
                    val toast = Toast.makeText(
                        applicationContext,
                        "you are out of the zone or entered something incorrectly",
                        Toast.LENGTH_SHORT
                    )
                    toast.show()
                }

            }


        }
        binding.orderBtn.setOnClickListener {
            val goToMenu = Intent(applicationContext, MenuActivity::class.java)
            startActivity(goToMenu)
        }
    }
}

