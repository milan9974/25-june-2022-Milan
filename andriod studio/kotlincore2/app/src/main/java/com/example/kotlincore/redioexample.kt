package com.example.kotlincore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Toast

class redioexample : AppCompatActivity() {

    lateinit var gender: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_redioexample)

        var radioGroup=findViewById<RadioGroup>(R.id.rg)
        var btnsubmit=findViewById<Button>(R.id.btnsubmit)
        radioGroup.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener{ radioGroup, i ->
            if (i==R.id.rb_male)
            {
                gender="male"
            }
            if(i==R.id.rb_female)
            {
                gender="female"
            }

        })

        btnsubmit.setOnClickListener{

            Toast.makeText(this, "gender ="+gender, Toast.LENGTH_SHORT).show()
        }
    }
}