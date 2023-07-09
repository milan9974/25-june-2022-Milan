package com.example.degitalsociety

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView

class Sec_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sec)

        var imChairman = findViewById<ImageView>(R.id.im_chairman)
        var imMember = findViewById<ImageView>(R.id.im_member)

        var anim1 = AnimationUtils.loadAnimation(this,R.anim.chairman)
        imChairman.startAnimation(anim1)

        var anim2 = AnimationUtils.loadAnimation(this,R.anim.member)
        imMember.startAnimation(anim2)

        imChairman.setOnClickListener {
            var i = Intent(this,Chairman_Register::class.java)
            startActivity(i)
        }

        imMember.setOnClickListener {
            var i = Intent(this,Member_Register::class.java)
            startActivity(i)
        }
    }
}