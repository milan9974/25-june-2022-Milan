package com.example.foodie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class order_now : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_now)

        var btnordernow=findViewById<Button>(R.id.btnordernow)

        btnordernow.setOnClickListener {
            var intent = Intent(order_now@this,foodie::class.java)
            startActivity(intent)
        }
    }
}