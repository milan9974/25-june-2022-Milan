package com.example.bottomnavigation.fragmentExample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.bottomnavigation.R
import com.example.bottomnavigation.myblankfragment

class fragment_example_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_example)

        var btnfragmentcall=findViewById<Button>(R.id.btn_fragment_call)

        btnfragmentcall.setOnClickListener {
            var transcatoin= supportFragmentManager.beginTransaction()
            transcatoin.replace(R.id.newfragment,myblankfragment())
            transcatoin.addToBackStack(null)
            transcatoin.commit()

        }
    }
}