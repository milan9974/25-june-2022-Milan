package com.example.employee

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Setting_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)


        var back_fromsetting = findViewById<ImageView>(R.id.back_fromsetting)

        back_fromsetting.setOnClickListener {
            var i = Intent(this, Dashboard_Activity::class.java)
            finish()
            startActivity(i)
        }



    }
}