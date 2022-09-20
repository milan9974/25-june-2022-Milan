package com.example.m3q2

import android.graphics.Color.blue
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var mainbg=findViewById<LinearLayout>(R.id.mainbg)
        var btnyello=findViewById<AppCompatButton>(R.id.btn_yello)
        var btnblue=findViewById<AppCompatButton>(R.id.btn_blue)

        var change=true

        btnyello.setOnClickListener {

            if(change)
            {
                mainbg.setBackgroundColor(resources.getColor(R.color.yello))
                change=false
            }
            else
            {
                mainbg.setBackgroundColor(resources.getColor(R.color.white))
                change=true
            }

        }

        btnblue.setOnClickListener {

            if(change)
            {
                mainbg.setBackgroundColor(resources.getColor(R.color.blue))
                change=false
            }
            else
            {
                mainbg.setBackgroundColor(resources.getColor(R.color.white))
                change=true
            }

        }
    }
}