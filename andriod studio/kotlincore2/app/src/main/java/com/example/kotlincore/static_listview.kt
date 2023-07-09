package com.example.kotlincore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast

class static_listview : AppCompatActivity()
{

         override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_static_listview)

        val lv = findViewById<ListView>(R.id.lvdata)

        lv.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(static_listview@this, ""+lv.getItemAtPosition(position), Toast.LENGTH_SHORT).show()
        }
    }
}