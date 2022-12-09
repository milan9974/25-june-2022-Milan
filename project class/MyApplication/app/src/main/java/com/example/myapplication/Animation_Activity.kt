package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button

class Animation_Activity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)

        var btn_scale = findViewById<Button>(R.id.btn_scaleanimation)
        var btn_rotade = findViewById<Button>(R.id.btn_rotadeanimation)

        btn_scale.setOnClickListener {
            var anim= AnimationUtils.loadAnimation(this@Animation_Activity,R.anim.scaleanimation)
            btn_scale.startAnimation(anim)
        }

        btn_rotade.setOnClickListener {
            var anim= AnimationUtils.loadAnimation(this@Animation_Activity,R.anim.rotate_animation)
            btn_rotade.startAnimation(anim)
        }
    }
}