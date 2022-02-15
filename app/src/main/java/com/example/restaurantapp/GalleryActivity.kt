package com.example.restaurantapp

import android.opengl.Visibility
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.example.restaurantapp.databinding.ActivityGalleryBinding
import com.example.restaurantapp.databinding.ActivityMainBinding
import android.view.WindowManager
import androidx.appcompat.app.AppCompatDelegate
import com.example.restaurantapp.Adapters.GDAdapter
import com.example.restaurantapp.Adapters.KrkAdapter
import com.example.restaurantapp.Adapters.WroAdapter
import com.example.restaurantapp.Adapters.WwaAdapter


class GalleryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGalleryBinding
    override fun onResume() {
        supportActionBar?.hide()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onResume()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityGalleryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (Build.VERSION.SDK_INT >= 21) {
            val window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = this.resources.getColor(R.color.green)
        }


        binding.selectBtn.setOnClickListener {
            binding.recyclerViewGallery.isVisible = false
            binding.galleryRG.isVisible = true
            binding.selectBtn.isVisible = false
        }
        binding.wroBtn.setOnClickListener {
            binding.selectBtn.text = "WROCŁAW"
            val adapter = WroAdapter(WroList.wroList)
            binding.recyclerViewGallery.adapter = adapter
            binding.galleryRG.isVisible = false
            binding.selectBtn.isVisible = true
            binding.recyclerViewGallery.isVisible = true


        }
        binding.krkBtn.setOnClickListener {
            binding.selectBtn.text = "KRAKÓW"
            val adapter = KrkAdapter(KrkList.krkList)
            binding.recyclerViewGallery.adapter = adapter
            binding.galleryRG.isVisible = false
            binding.selectBtn.isVisible = true
            binding.recyclerViewGallery.isVisible = true
        }
        binding.wwaBtn.setOnClickListener {
            binding.selectBtn.text = "WARSZAWA"
            val adapter = WwaAdapter(WwaList.wwaList)
            binding.recyclerViewGallery.adapter = adapter
            binding.galleryRG.isVisible = false
            binding.selectBtn.isVisible = true
            binding.recyclerViewGallery.isVisible = true
        }
        binding.gdBtn.setOnClickListener {
            binding.selectBtn.text = "GDAŃSK"
            val adapter = GDAdapter(GdList.gdList)
            binding.recyclerViewGallery.adapter = adapter
            binding.galleryRG.isVisible = false
            binding.selectBtn.isVisible = true
            binding.recyclerViewGallery.isVisible = true
        }

    }

}