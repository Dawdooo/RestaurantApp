package com.example.restaurantapp.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurantapp.Photo
import com.example.restaurantapp.databinding.GalleryItemBinding

class WwaAdapter(val wwaList: List<Photo>) : RecyclerView.Adapter<WwaAdapter.WwaViewHolder>() {
    inner class WwaViewHolder(val itemBinding: GalleryItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bindItem(photo: Photo) {
            itemBinding.imageView2.setImageResource(photo.img)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WwaViewHolder {
        return WwaViewHolder(
            GalleryItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: WwaViewHolder, position: Int) {
        val photo = wwaList[position]
        holder.bindItem(photo)
    }

    override fun getItemCount(): Int {
        return wwaList.size
    }
}