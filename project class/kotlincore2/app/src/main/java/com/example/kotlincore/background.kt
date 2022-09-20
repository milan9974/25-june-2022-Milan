package com.example.kotlincore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class background : AppCompatActivity() {

    lateinit var click:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_background)

        click=findViewById(R.id.click)
    }
}