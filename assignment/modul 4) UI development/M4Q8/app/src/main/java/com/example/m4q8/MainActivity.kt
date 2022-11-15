package com.example.m4q8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.widget.AppCompatButton
import androidx.core.text.set

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var ed = findViewById<EditText>(R.id.ed)
        var btn_show = findViewById<AppCompatButton>(R.id.btn_show)
        var btn_hide = findViewById<AppCompatButton>(R.id.btn_hide)

        btn_show.setOnClickListener {
            ed.visibility=View.VISIBLE
        }

        btn_hide.setOnClickListener {
            ed.visibility=View.GONE
        }

    }

}