package com.example.m3q5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class register_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ragister)

        var tvsignin=findViewById<TextView>(R.id.tv_signin)

        tvsignin.setOnClickListener {
            var i=Intent(register_activity@this,login_activity::class.java)
            startActivity(i)
        }
    }
}