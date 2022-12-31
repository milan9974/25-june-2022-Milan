package com.example.m6q9logoanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()

        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)

        var left = findViewById<ImageView>(R.id.left)
        var right = findViewById<ImageView>(R.id.right)
        var up = findViewById<ImageView>(R.id.up)
        var down = findViewById<ImageView>(R.id.down)


        var anim = AnimationUtils.loadAnimation(this,R.anim.leftanimation)
        left.startAnimation(anim)
        left.animate().apply {
            duration = 1000
            translationXBy(00f)
        }.withEndAction {
            left.animate().apply {
                duration=1000
                rotationYBy(720f)
                rotationXBy(360f)
            }.start()
        }


        var anim2 = AnimationUtils.loadAnimation(this,R.anim.rightanimation)
        right.startAnimation(anim2)
        right.animate().apply {
            duration = 1000
            translationXBy(00f)
        }.withEndAction {
            right.animate().apply {
                duration=1000
                rotationYBy(720f)
                rotationXBy(360f)
            }.start()
        }


        var anim3 = AnimationUtils.loadAnimation(this,R.anim.upanimation)
        up.startAnimation(anim3)
        up.animate().apply {
            duration = 1000
            translationXBy(00f)
        }.withEndAction {
            up.animate().apply {
                duration=1000
                rotationYBy(720f)
                rotationXBy(360f)
            }.start()
        }


        var anim4 = AnimationUtils.loadAnimation(this,R.anim.downanimation)
        down.startAnimation(anim4)
        down.animate().apply {
            duration = 1000
            translationXBy(00f)
        }.withEndAction {
            down.animate().apply {
                duration=1000
                rotationYBy(720f)
                rotationXBy(360f)
            }.start()
        }
    }
}