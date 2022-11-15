package com.example.m4q10


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.m4q10.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_main)

        var tv=findViewById<TextView>(R.id.tv_showpdf)

        tv.setOnClickListener ( View.OnClickListener{viewpdf()}  )
    }

    private fun viewpdf() {
        val value = "https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(value))

        startActivity(intent)
    }
}