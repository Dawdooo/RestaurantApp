package com.example.restaurantapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurantapp.databinding.ItemBinding


class MyAdapter(val burgerList: List<Burger>, val clickListener: ClickListener) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    inner class MyViewHolder(val itemBinding: ItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {


        fun bindItem(burger: Burger) {
            itemBinding.Name.text = burger.name
            itemBinding.component1.text = burger.component1
            itemBinding.priceItem.text = burger.price.toString() + "$"
            var total = burger.total
            itemBinding.addButon.setOnClickListener {
                total = 1
                itemBinding.addButon.isVisible = false
                itemBinding.buttonPlus.isVisible = true
                itemBinding.buttonMinus.isVisible = true
                clickListener.addToCartListener(burger)
            }
            itemBinding.buttonPlus.setOnClickListener {
                total++
                clickListener.addToCartListener(burger)
            }
            itemBinding.buttonMinus.setOnClickListener {
                total--
                clickListener.deleateFromCart(burger)
                if (total == 0) {
                    itemBinding.addButon.isVisible = true
                    itemBinding.buttonPlus.isVisible = false
                    itemBinding.buttonMinus.isVisible = false
                }
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val burger = burgerList[position]
        holder.bindItem(burger)
    }

    override fun getItemCount(): Int {
        return burgerList.size
    }

    interface ClickListener {
        fun addToCartListener(burger: Burger)
        fun deleateFromCart(burger: Burger)
    }


}
