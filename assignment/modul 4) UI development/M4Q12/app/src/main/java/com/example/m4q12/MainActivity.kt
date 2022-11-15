package com.example.m4q12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var ed=findViewById<EditText>(R.id.ed)
        var check = findViewById<CheckBox>(R.id.check)

       check.setOnCheckedChangeListener { buttonView, isChecked ->

           if (isChecked)
           {
               ed.visibility=View.VISIBLE
           }
           else
           {
               ed.visibility=View.GONE
           }
       }
    }
}