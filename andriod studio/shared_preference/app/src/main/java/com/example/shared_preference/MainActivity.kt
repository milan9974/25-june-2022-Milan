package com.example.shared_preference

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var ed_username = findViewById<EditText>(R.id.ed_username)
        var ed_email = findViewById<EditText>(R.id.ed_email)
        var ed_password = findViewById<EditText>(R.id.ed_password)
        var btn_registration = findViewById<Button>(R.id.btn_registration)
        var tv_login = findViewById<TextView>(R.id.tv_login)

        var myshared:SharedPreferences = this.getSharedPreferences("mypref_file", Context.MODE_PRIVATE)
        var editor: SharedPreferences.Editor = myshared.edit()

        btn_registration.setOnClickListener {
            editor.putString("username",ed_username.text.toString())
            editor.putString("email",ed_email.text.toString())
            editor.putString("password",ed_password.text.toString())

            editor.apply()
            editor.commit()

            var i = Intent(this,login_activity::class.java)
            startActivity(i)
            finish()
        }

        tv_login.setOnClickListener {
            var i = Intent(this,login_activity::class.java)
            startActivity(i)
            finish()
        }
    }
}