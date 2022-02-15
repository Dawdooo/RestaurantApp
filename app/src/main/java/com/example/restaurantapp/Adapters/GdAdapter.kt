package com.example.restaurantapp.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurantapp.Photo
import com.example.restaurantapp.databinding.GalleryItemBinding

class GDAdapter(val gdList: List<Photo>) : RecyclerView.Adapter<GDAdapter.GDViewHolder>() {
    inner class GDViewHolder(val itemBinding: GalleryItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bindItem(photo: Photo) {
            itemBinding.imageView2.setImageResource(photo.img)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GDViewHolder {
        return GDViewHolder(
            GalleryItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: GDViewHolder, position: Int) {
        val photo = gdList[position]
        holder.bindItem(photo)
    }

    override fun getItemCount(): Int {
        return gdList.size
    }
}
