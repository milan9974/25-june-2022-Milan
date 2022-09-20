package com.example.m3q5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class login_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var tvsignup=findViewById<TextView>(R.id.tv_signup)

        tvsignup.setOnClickListener {
            var i2=Intent(login_activity@this,register_activity::class.java)
            startActivity(i2)
        }
    }
}