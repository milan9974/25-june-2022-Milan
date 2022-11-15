package com.example.m4q567

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn_google = findViewById<Button>(R.id.btn_google)
        var btn_insta = findViewById<Button>(R.id.btn_insta)

        var connection = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        var check = connection.activeNetworkInfo

        btn_google.setOnClickListener {

            if (check !=  null && check.isConnected == true)
            {
                var openURL = Intent(Intent.ACTION_VIEW)
                openURL.data = Uri.parse("https://www.google.com/")
                startActivity(openURL)
            }

            else
            {
                Toast.makeText(this, "Network not available", Toast.LENGTH_SHORT).show()
            }
        }

        btn_insta.setOnClickListener {

            if (check != null && check.isConnected ==true)
            {
                var openURL = Intent(Intent.ACTION_VIEW)
                openURL.data = Uri.parse("https://www.instagram.com")
                startActivity(openURL)
            }

            else
            {
                Toast.makeText(this, "Network not available", Toast.LENGTH_SHORT).show()
            }
        }
    }
}