package com.example.m3q3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn=findViewById<AppCompatButton>(R.id.btn)

        btn.setOnClickListener {
            var next=Intent(MainActivity@this,next_activity::class.java)
            startActivity(next)
        }
    }
}