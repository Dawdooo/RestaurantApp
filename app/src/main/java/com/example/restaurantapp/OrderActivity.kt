package com.example.restaurantapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.system.Os.socket
import android.widget.Toast
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.InetAddress
import java.net.ServerSocket
import java.net.Socket
import androidx.appcompat.app.AppCompatDelegate
import com.example.restaurantapp.databinding.ActivityOrderBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import java.io.IOException
import java.lang.Thread.activeCount
import java.lang.Thread.sleep
import java.util.*


class OrderActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOrderBinding
    private lateinit var database: DatabaseReference

    override fun onResume() {
        supportActionBar?.hide()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onResume()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.subtotalValue.text = intent.getStringExtra("cartValue") + "$"
        var value = intent.getStringExtra("cartValue")
        val orderList = intent.getStringExtra("orderList")
        var totalValue = value?.toInt()?.plus(2)
        val toastOutOF = Toast.makeText(
            applicationContext,
            "you are out of the zone or entered something incorrectly",
            Toast.LENGTH_SHORT
        )
        val dbError = Toast.makeText(
            applicationContext,
            "order failed",
            Toast.LENGTH_SHORT
        )
        val goToSuccessOrderActivity = Intent(applicationContext, SuccessOrderActivity::class.java)
        binding.totalValue.text = totalValue.toString() + "$"



        binding.finallyOrderBtn.setOnClickListener {
            val city = binding.cityOrder.text.toString()
            val adress = binding.adressOrder.text.toString()
            val numberOfStreet = binding.numberOrder.text.toString()
            val name = binding.nameOrder.text.toString()
            val phoneNumber = binding.phoneNumberOrder.text.toString()
            val apartament = binding.apartamentOrder.text.toString()
            val note = binding.noteOrder.text.toString()

            when (city.uppercase().trim()) {
                "WROCŁAW" -> {
                    if (adress.uppercase().trim() in wroStreet
                        && numberOfStreet.isNotEmpty()
                        && numberOfStreet.length < 4
                        && name.isNotEmpty()
                        && phoneNumber.length == 9
                    ) {
                        database = FirebaseDatabase.getInstance().getReference("Orders Wrocław")
                        val adressToDb = adress + " " + numberOfStreet
                        val Order = Order(
                            name,
                            phoneNumber,
                            adressToDb,
                            city,
                            apartament,
                            note,
                            value,
                            orderList
                        )
                        database.child("Order from $name").setValue(Order).addOnSuccessListener {
                            startActivity(goToSuccessOrderActivity)
                        }.addOnFailureListener {

                            dbError.show()
                        }

                    } else {
                        toastOutOF.show()
                    }
                }
                "WARSZAWA" -> {

                    if (adress.uppercase().trim() in wwaStreet
                        && numberOfStreet.isNotEmpty()
                        && numberOfStreet.length < 4
                        && name.isNotEmpty()
                        && phoneNumber.length == 9
                    ) {
                        database = FirebaseDatabase.getInstance().getReference("Orders Warszawa")
                        val adressToDb = adress + " " + numberOfStreet
                        val Order = Order(
                            name,
                            phoneNumber,
                            adressToDb,
                            city,
                            apartament,
                            note,
                            value,
                            orderList
                        )
                        database.child("Order from $name").setValue(Order).addOnSuccessListener {
                            startActivity(goToSuccessOrderActivity)
                        }.addOnFailureListener {

                            dbError.show()
                        }

                    } else {
                        toastOutOF.show()
                    }
                }
                "KRAKÓW" -> {
                    if (adress.uppercase().trim() in krkStreet
                        && numberOfStreet.isNotEmpty()
                        && numberOfStreet.length < 4
                        && name.isNotEmpty()
                        && phoneNumber.length == 9
                    ) {
                        database = FirebaseDatabase.getInstance().getReference("Orders Kraków")
                        val adressToDb = adress + " " + numberOfStreet
                        val Order = Order(
                            name,
                            phoneNumber,
                            adressToDb,
                            city,
                            apartament,
                            note,
                            value,
                            orderList
                        )
                        database.child("Order from $name").setValue(Order).addOnSuccessListener {
                            startActivity(goToSuccessOrderActivity)
                        }.addOnFailureListener {

                            dbError.show()
                        }

                    } else {
                        toastOutOF.show()
                    }
                }
                "GDAŃSK" -> {
                    if (adress.uppercase().trim() in gdStreet
                        && numberOfStreet.isNotEmpty()
                        && numberOfStreet.length < 4
                        && name.isNotEmpty()
                        && phoneNumber.length == 9
                    ) {
                        database = FirebaseDatabase.getInstance().getReference("Orders Warszawa")
                        val adressToDb = adress + " " + numberOfStreet
                        val Order = Order(
                            name,
                            phoneNumber,
                            adressToDb,
                            city,
                            apartament,
                            note,
                            value,
                            orderList
                        )
                        database.child("Order from $name").setValue(Order).addOnSuccessListener {
                            startActivity(goToSuccessOrderActivity)
                        }.addOnFailureListener {

                            dbError.show()
                        }

                    } else {
                        toastOutOF.show()
                    }
                }
                else -> {
                    val toast = Toast.makeText(
                        applicationContext,
                        "you are out of the zone or entered something incorrectly",
                        Toast.LENGTH_SHORT
                    )
                    toast.show()
                }

            }
        }
    }
}
