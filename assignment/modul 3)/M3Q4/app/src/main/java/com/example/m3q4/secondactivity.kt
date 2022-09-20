package com.example.m3q4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class secondactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var textview=findViewById<TextView>(R.id.textview)

        var tvprint:String

        tvprint= intent.getStringExtra("name")!!

        textview.setText("Name : $tvprint")
    }
}