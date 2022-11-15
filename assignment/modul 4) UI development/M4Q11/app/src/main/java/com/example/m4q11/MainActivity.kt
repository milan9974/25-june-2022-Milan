package com.example.m4q11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var ed = findViewById<EditText>(R.id.ed)
        var btn_increase = findViewById<Button>(R.id.btn_increase)
        var btn_decrease = findViewById<Button>(R.id.btn_decrease)

        btn_increase.setOnClickListener {
            ed.setTextSize(ed.textSize.inc() +1)
        }

        btn_decrease.setOnClickListener {
            ed.setTextSize(ed.textSize.dec() -1)
        }
    }
}