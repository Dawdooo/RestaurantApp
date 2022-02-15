package com.example.restaurantapp

import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.example.restaurantapp.databinding.ActivityContactBinding
import com.example.restaurantapp.databinding.ActivitySendMessageBinding


class SendMessage : AppCompatActivity() {
    private lateinit var binding: ActivitySendMessageBinding
    override fun onResume() {
        supportActionBar?.hide()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onResume()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySendMessageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (Build.VERSION.SDK_INT >= 21) {
            val window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = this.resources.getColor(R.color.green)
        }

        binding.sendMsgBtn.setOnClickListener {
            val name = binding.sendName.text.toString()
            val email = "contact@burger.com"
            val msg = binding.sendMsg.text.toString()

            if (name.isNotEmpty() && msg.isNotEmpty()) {

                val adresses = email.split(",".toRegex()).toTypedArray()


                val intent = Intent(Intent.ACTION_SEND).apply {

                    data = Uri.parse("mailto:")
                    type = "text/plain"
                    putExtra(Intent.EXTRA_EMAIL, adresses)
                    putExtra(Intent.EXTRA_SUBJECT, name)
                    putExtra(Intent.EXTRA_TEXT, msg)
                }
                try {
                    startActivity(intent)
                } catch (e: Exception) {
                    Toast.makeText(
                        this@SendMessage,
                        "Required app is not installed",
                        Toast.LENGTH_LONG
                    ).show()
                }
            } else {
                val toast = Toast.makeText(
                    applicationContext,
                    "you must enter a name and a message",
                    Toast.LENGTH_SHORT
                )
                toast.show()
            }

        }

    }
}

