
package com.example.kotlincore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity()
{

    lateinit var fab:FloatingActionButton
    lateinit var less:FloatingActionButton
    lateinit var tvcount:TextView
    var count=0

    override fun onCreate(savedInstanceState: Bundle?)
    {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab=findViewById(R.id.feb)
        less=findViewById(R.id.less)
        tvcount=findViewById(R.id.tvcount)

        fab.setOnClickListener{
            count+=1
            tvcount.setText("$count")
        }
        less.setOnClickListener {
            count-=1
            tvcount.setText("$count")
        }

    }

}