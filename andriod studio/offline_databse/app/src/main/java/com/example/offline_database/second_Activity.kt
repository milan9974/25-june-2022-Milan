package com.example.offline_database

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class second_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var tvnewuser=findViewById<TextView>(R.id.tvnewuser)
        var gestuser=findViewById<TextView>(R.id.tvgest)

        tvnewuser.setOnClickListener {

            var i = Intent(this,MainActivity::class.java)
            finish()
            startActivity(i)
        }

        gestuser.setOnClickListener {

            var i = Intent(this,dashboard::class.java)
            finish()
            startActivity(i)
        }
    }
}