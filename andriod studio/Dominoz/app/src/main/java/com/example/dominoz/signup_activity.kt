package com.example.dominoz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton

class signup_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        var btnsignup=findViewById<AppCompatButton>(R.id.btnSignup)

        btnsignup.setOnClickListener {
            var firstview=Intent(signup_activity@this,firstview_activity::class.java)
            startActivity(firstview)
        }
    }
}