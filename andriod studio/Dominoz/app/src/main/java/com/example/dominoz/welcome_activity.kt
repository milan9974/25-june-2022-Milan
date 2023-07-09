package com.example.dominoz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton

class welcome_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        var btnloginpage=findViewById<AppCompatButton>(R.id.btnloginpage)
        var btnsignuppage=findViewById<AppCompatButton>(R.id.btnsignuppage)

        btnloginpage.setOnClickListener {
            var loginpage = Intent(welcome_activity@this, login_activity::class.java)
            startActivity(loginpage)
        }

        btnsignuppage.setOnClickListener {
            var signuppage= Intent(welcome_activity@this,signup_activity::class.java)
            startActivity(signuppage)
        }

    }
}