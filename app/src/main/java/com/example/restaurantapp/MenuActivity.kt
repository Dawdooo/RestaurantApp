package com.example.restaurantapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.restaurantapp.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity(), MyAdapter.ClickListener {
    var cart = mutableListOf<String>()
    var cartValue = mutableListOf<Int>(0)
    var binding: ActivityMenuBinding? = null

    override fun onResume() {
        supportActionBar?.hide()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onResume()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding?.root)


        val adapter = MyAdapter(BurgerList.burgerList, this)
        binding?.recyclerView?.adapter = adapter


        binding?.basketLayout?.setOnClickListener {
            if (cartValue.sum() > 0) {
                val goToBasket = Intent(applicationContext, OrderActivity::class.java)
                var value = cartValue.sum()
                val orderList = cart.toString()
                goToBasket.putExtra("orderList", orderList.toString())
                goToBasket.putExtra("cartValue", value.toString())
                startActivity(goToBasket)
            } else {
                val toastNull =
                    Toast.makeText(applicationContext, "Your cart is empty", Toast.LENGTH_SHORT)
                toastNull.show()
            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    override fun addToCartListener(burger: Burger) {
        cart.add(burger.name)
        cartValue.add(burger.price)
        binding?.basketPriceTxt?.text = "(${cartValue?.sum().toString()}$)"


    }

    override fun deleateFromCart(burger: Burger) {
        cart.remove(burger.name)
        cartValue.remove(burger.price)
        binding?.basketPriceTxt?.text = "(${cartValue?.sum().toString()}$)"
    }

}
