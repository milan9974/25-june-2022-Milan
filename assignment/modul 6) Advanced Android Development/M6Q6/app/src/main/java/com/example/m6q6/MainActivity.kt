package com.example.m6q6

import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.RotateAnimation
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var imSmile = findViewById<ImageView>(R.id.img_smile)
        var imEmoji = findViewById<ImageView>(R.id.img_emoji)

        /*val rotate = RotateAnimation(
            0F, 360F,
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f
        )
        rotate.duration = 1000
        rotate.repeatCount = Animation.INFINITE
        imSmile.startAnimation(rotate)*/

        imSmile.setOnClickListener {
            imSmile.animate().apply {
                duration = 500
                rotationBy(360f)
            }.withEndAction {
                imSmile.animate().apply {
                    duration = 500
                    rotationBy(-360f)
                }.withEndAction {
                    imSmile.animate().apply {
                        duration = 500
                        rotationYBy(360f)
                    }.withEndAction {
                        imSmile.animate().apply {
                            duration = 500
                            rotationXBy(360f)
                        }.withEndAction {
                            imSmile.animate().apply {
                                duration = 200
                                scaleXBy(0.9f)
                                scaleYBy(0.9f)
                            }.withEndAction {
                                imSmile.animate().apply {
                                    duration=200
                                    scaleXBy(-0.9f)
                                    scaleYBy(-0.9f)
                                }
                            }
                        }
                    }
                }
            }
        }
        
        imEmoji.setOnClickListener {
            var anim = AnimationUtils.loadAnimation(this,R.anim.blink)
            imEmoji.startAnimation(anim)
        }
    }
}