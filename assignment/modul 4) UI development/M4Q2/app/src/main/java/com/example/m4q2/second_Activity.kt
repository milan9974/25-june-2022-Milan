package com.example.m4q2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class second_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var tv1=findViewById<TextView>(R.id.tv1)
        var tv2=findViewById<TextView>(R.id.tv2)
        var tvprint1=findViewById<TextView>(R.id.tvprint1)

        var tv11:String
        var tv22:String
        var tvprint11:String
        var temp:String

        tv11=intent.getStringExtra("1st number")!!
        tv22=intent.getStringExtra("2nd number")!!

        tv1.setText("1st Number = $tv11")
        tv2.setText("2nd Number = $tv22")

        tvprint1.setText("$tv11$tv22")

    }
}


