package com.example.m4q2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    lateinit var ed1:EditText
    lateinit var ed2:EditText
    lateinit var btnsubmit:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ed1=findViewById(R.id.ed1)
        ed2=findViewById(R.id.ed2)
        btnsubmit=findViewById(R.id.btnsubmit)

        var ed11:String
        var ed22:String

        btnsubmit.setOnClickListener {
            ed11=ed1.text.toString()
            ed22=ed2.text.toString()

            var i2=Intent(MainActivity@this,second_Activity::class.java)
            i2.putExtra("1st number",ed11)
            i2.putExtra("2nd number",ed22)
            startActivity(i2)
        }
    }
}


