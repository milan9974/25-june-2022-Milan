package com.example.m4q6

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.net.ConnectivityManager
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn_check=findViewById<Button>(R.id.btn_check)

        btn_check.setOnClickListener {
            var connection = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            var check = connection.activeNetworkInfo

            if (check != null && check.isConnected == true)
            {
                Toast.makeText(this@MainActivity, "Network Available", Toast.LENGTH_LONG).show()
            }

            else
            {
                Toast.makeText(this@MainActivity, "Network Not Available", Toast.LENGTH_LONG).show()
            }
        }
    }
}