package com.example.restaurantapp.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurantapp.Photo
import com.example.restaurantapp.databinding.GalleryItemBinding

class WroAdapter(val wroList: List<Photo>) : RecyclerView.Adapter<WroAdapter.WroViewHolder>() {
    inner class WroViewHolder(val itemBinding: GalleryItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bindItem(photo: Photo) {
            itemBinding.imageView2.setImageResource(photo.img)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WroViewHolder {
        return WroViewHolder(
            GalleryItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: WroViewHolder, position: Int) {
        val photo = wroList[position]
        holder.bindItem(photo)
    }

    override fun getItemCount(): Int {
        return wroList.size
    }
}