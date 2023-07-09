package com.example.myapplicationforprectis

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Login : AppCompatActivity() {

    lateinit var myshared:SharedPreferences
    lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val edEmail = findViewById<EditText>(R.id.ed_email_login)
        val edPassword = findViewById<EditText>(R.id.ed_password_login)
        val tvRegister = findViewById<TextView>(R.id.tv_register)
        val btnLogin = findViewById<Button>(R.id.btn_login)

        val email = intent.getStringExtra("email")
        val password = intent.getStringExtra("password")

        edEmail.setText(email)
        edPassword.setText(password)

        myshared = this.getSharedPreferences("myshared",Context.MODE_PRIVATE)
        editor = myshared.edit()

        tvRegister.setOnClickListener {
            startActivity(Intent(this,register::class.java))
            finish()
        }
        btnLogin.setOnClickListener {
            if (edEmail.text.toString()!="" && edPassword.text.toString()!=""){
                val email1 = myshared.getString("email","default")
                val pass = myshared.getString("password","default")
                if (email1.equals(edEmail.text.toString()) && pass.equals(edPassword.text.toString())){

                    editor.putBoolean("status",true)
                    editor.apply()
                    editor.commit()

                    startActivity(Intent(this,dashboard::class.java))
                    finish()

                }else{
                    Toast.makeText(this, "Incorrect pass or email", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}