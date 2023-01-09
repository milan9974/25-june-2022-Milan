package com.example.e_qiuz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView

class Splash_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar!!.hide()

        var im=findViewById<ImageView>(R.id.imageView2)

        var anim = AnimationUtils.loadAnimation(this,R.anim.my_anima)
        im.startAnimation(anim)
    }
}