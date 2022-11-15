package com.example.m4q4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton

class splash_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        var start=findViewById<FloatingActionButton>(R.id.start)

        start.setOnClickListener {
            var i= Intent(this,MainActivity::class.java)
            startActivity(i)
        }
    }
}