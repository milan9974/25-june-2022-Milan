package com.example.myapplication

import android.annotation.SuppressLint
import android.content.ContentResolver
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import androidx.annotation.RequiresApi

class Animation_Activity : AppCompatActivity()
{
    @SuppressLint("Range")
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)

        var btn_scale = findViewById<Button>(R.id.btn_scaleanimation)
        var btn_rotade = findViewById<Button>(R.id.btn_rotadeanimation)
        var btn_alpha = findViewById<Button>(R.id.btn_alpha)
        var btn_translate = findViewById<Button>(R.id.btn_translate)

        btn_alpha.animate().apply {
            duration = 2000
            rotationBy(360f)
        }.start()

        btn_scale.setOnClickListener {
            var anim= AnimationUtils.loadAnimation(this@Animation_Activity,R.anim.scaleanimation)
            btn_scale.startAnimation(anim)
        }

        btn_rotade.setOnClickListener {
            var anim= AnimationUtils.loadAnimation(this@Animation_Activity,R.anim.rotate_animation)
            btn_rotade.startAnimation(anim)
        }

        btn_alpha.setOnClickListener {
            var anim=AnimationUtils.loadAnimation(this@Animation_Activity,R.anim.alpha_ani)
            btn_alpha.startAnimation(anim)

        }

        var anim=AnimationUtils.loadAnimation(this@Animation_Activity,R.anim.translate_ani)
        btn_translate.startAnimation(anim)

        btn_translate.setOnClickListener {
            var anim=AnimationUtils.loadAnimation(this@Animation_Activity,R.anim.translate_ani)
            btn_translate.startAnimation(anim)

        }

        requestPermissions(arrayOf(android.Manifest.permission.READ_CONTACTS),1)

        var resolver: ContentResolver =contentResolver

        var cursor = resolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null)
        if (cursor!!.count >0)
        {
            while (cursor.moveToNext())
            {
                var name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))
                var number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))

                Log.d("mydata","-----> $name - $number" )
            }
        }
    }
}