package com.example.m6q8framanimation

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var ad = AnimationDrawable()

        var fram1 = resources.getDrawable(R.mipmap.a,null)
        var fram2 = resources.getDrawable(R.mipmap.b,null)
        var fram3 = resources.getDrawable(R.mipmap.c,null)
        var fram4 = resources.getDrawable(R.mipmap.d,null)
        var fram5 = resources.getDrawable(R.mipmap.e,null)
        var fram6 = resources.getDrawable(R.mipmap.f,null)
        var fram7 = resources.getDrawable(R.mipmap.g,null)
        var fram8 = resources.getDrawable(R.mipmap.h,null)
        var fram9 = resources.getDrawable(R.mipmap.i,null)
        var fram10 = resources.getDrawable(R.mipmap.j,null)
        var fram11 = resources.getDrawable(R.mipmap.k,null)
        var fram12 = resources.getDrawable(R.mipmap.l,null)

        ad.addFrame(fram1,150)
        ad.addFrame(fram2,100)
        ad.addFrame(fram3,120)
        ad.addFrame(fram4,100)
        ad.addFrame(fram5,120)
        ad.addFrame(fram6,100)
        ad.addFrame(fram7,150)
        ad.addFrame(fram8,100)
        ad.addFrame(fram9,120)
        ad.addFrame(fram10,100)
        ad.addFrame(fram11,120)
        ad.addFrame(fram12,100)

        var im = findViewById<ImageView>(R.id.im)
        im.background = ad
        ad.start()

    }
}