package com.example.m4q1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var ed:EditText
    lateinit var tv:TextView
    lateinit var save:Button
    var charCountMap: HashMap<Char, Int>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ed=findViewById(R.id.ed)
        tv=findViewById(R.id.tv)
        save=findViewById(R.id.save)

        save.
        setOnClickListener {
            if (ed.text.toString().isNotBlank())
            {
                var c = StringBuffer(ed.text.toString())
                tv.setText(c.reverse())

                Toast.makeText(MainActivity@this, "DONE", Toast.LENGTH_SHORT).show()
            }
            else
            {
                ed.setError("Enter something")
            }
        }
    }
}