package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.newlayout)

        var edemail = findViewById<EditText>(R.id.edemail)
        var edpassword = findViewById<EditText>(R.id.edpassword)
        var btnlogin = findViewById<Button>(R.id.btn_login)
        var btnreset = findViewById<Button>(R.id.btn_reset)
        var tvdisplay = findViewById<TextView>(R.id.tv_display)

        btnlogin.setOnClickListener{
            Log.d("mydata","email="+edemail.text.toString())
            Log.d("mydata","password="+edpassword.text.toString())

            tvdisplay.setText(edemail.text.toString())


            var intent = Intent(MainActivity@this,secondactivity::class.java)
            startActivity(intent)
        }

        btnreset.setOnClickListener{
            edemail.text.clear()
            edpassword.text.clear()

        }

    }
}