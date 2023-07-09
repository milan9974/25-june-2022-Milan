package com.example.dominoz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton

class login_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        var btnlogin=findViewById<AppCompatButton>(R.id.btnlogin)

        btnlogin.setOnClickListener { 
            var firstview= Intent(login_activity@this,firstview_activity::class.java)
            startActivity(firstview)
        }
    }
}