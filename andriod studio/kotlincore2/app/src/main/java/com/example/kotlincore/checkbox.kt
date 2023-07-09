package com.example.kotlincore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.CheckBox
import android.widget.CompoundButton

class checkbox : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkbox)

        var chk_play=findViewById<CheckBox>(R.id.chk_play)
        var chk_read=findViewById<CheckBox>(R.id.chk_read)
        var chk_dance=findViewById<CheckBox>(R.id.chk_dance)

        chk_play.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->

            if(isChecked)
            {
                Log.d("mydata","play")
            }
            else
            {
                Log.d("mydata","unchecked play")
            }
        })

        chk_read.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->

            if(isChecked)
            {
                Log.d("mydata","read")
            }
            else
            {
                Log.d("mydata","unchecked read")
            }
        })

        chk_dance.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->

            if(isChecked)
            {
                Log.d("mydata","dance")
            }
            else
            {
                Log.d("mydata","unchecked dance")
            }
        })
    }
}