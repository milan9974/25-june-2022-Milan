package com.prepare.makedirectory

import android.R.layout
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.m4q9.R

class MainActivity : AppCompatActivity() {
    lateinit var click: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        click = findViewById(R.id.pdf)
        click.setOnClickListener {
            viewpdf()
        }
    }

    private fun viewpdf() {

        var openURL = Intent(Intent.ACTION_VIEW)
        openURL.data = Uri.parse("https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf")
        startActivity(openURL)

    }
}