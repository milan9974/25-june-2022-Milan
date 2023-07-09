package com.example.degitalsociety

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.widget.ImageView

class Splash_Screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)

        var ss = findViewById<ImageView>(R.id.splashscreen)

        ss.animate().apply {
            duration = 500
            scaleXBy(-.3f)
            scaleYBy(-.3f)
        }.withEndAction {
            ss.animate().apply {
                duration = 500
                scaleXBy(.3f)
                scaleYBy(.3f)
            }
        }

        Handler().postDelayed({
            var i = Intent(this,Sec_activity::class.java)
            finish()
            startActivity(i)
        },2500)
    }
}