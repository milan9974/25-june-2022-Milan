package com.example.m3q4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {

    lateinit var edtext:EditText
    lateinit var btnsumit:AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtext=findViewById(R.id.edtext)
        btnsumit=findViewById(R.id.btnsubmit)

        var edtext2:String

        btnsumit.setOnClickListener {
            edtext2=edtext.text.toString()

            var i2=Intent(MainActivity@this,secondactivity::class.java)
            i2.putExtra("name",edtext2)
            startActivity(i2)

        }
    }
}