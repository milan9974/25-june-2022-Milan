package com.example.retrofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton

class Second_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var btn_member_register=findViewById<AppCompatButton>(R.id.btn_member_login)
        var btn_chairman_login=findViewById<AppCompatButton>(R.id.btn_chairman_login)


        btn_member_register.setOnClickListener {
            var i=Intent(this@Second_Activity,Member_Register_Activity::class.java)
            startActivity(i)
        }

        btn_chairman_login.setOnClickListener {
            var i2=Intent(this@Second_Activity,Chairman_Login_Activity::class.java)
            startActivity(i2)
        }
    }
}