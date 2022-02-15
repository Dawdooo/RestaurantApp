package com.example.restaurantapp.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurantapp.Photo
import com.example.restaurantapp.databinding.GalleryItemBinding

class KrkAdapter(val krkList: List<Photo>) : RecyclerView.Adapter<KrkAdapter.KrkViewHolder>() {
    inner class KrkViewHolder(val itemBinding: GalleryItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bindItem(photo: Photo) {
            itemBinding.imageView2.setImageResource(photo.img)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KrkViewHolder {
        return KrkViewHolder(
            GalleryItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: KrkViewHolder, position: Int) {
        val photo = krkList[position]
        holder.bindItem(photo)
    }

    override fun getItemCount(): Int {
        return krkList.size
    }
}