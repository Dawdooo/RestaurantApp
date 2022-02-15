package com.example.restaurantapp

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Order(
    val name: String? = null,
    val phoneNb: String? = null,
    val adress: String? = null,
    val City: String? = null,
    val apartament: String? = null,
    val note: String? = null,
    val price: String? = null,
    val orderList: String? = null
)


