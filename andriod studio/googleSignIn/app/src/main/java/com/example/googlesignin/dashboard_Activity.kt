package com.example.googlesignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class dashboard_Activity : AppCompatActivity() {

    lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        var tvEmail= findViewById<TextView>(R.id.tv_email)
        var tvName= findViewById<TextView>(R.id.tv_name)
        var tvLogout = findViewById<TextView>(R.id.tv_logout)

        tvEmail.text =intent.getStringExtra("email")
        tvName.text = intent.getStringExtra("username")

        tvLogout.setOnClickListener {
            auth.signOut()
            var i = Intent(this,MainActivity::class.java)
            finish()
            startActivity(i)
        }
    }
}