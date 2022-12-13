package com.example.e_qiuz

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Binder
import android.os.Bundle
import android.text.Html
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity


class Dashboard_Activity : AppCompatActivity() {

    lateinit var myshared : SharedPreferences
    lateinit var editor : SharedPreferences.Editor

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

               // action bar ni andar title no color change karva mate
        val text: Spannable = SpannableString(supportActionBar!!.title)
        text.setSpan(ForegroundColorSpan(Color.BLACK), 0, text.length, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
        supportActionBar!!.title = text

//        supportActionBar!!.setTitle((Html.fromHtml("<font color=\"#FF4444\">" + getString(R.string.milan) + "</font>")));

               // action bar ma left side icon set karva
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24)

               // akha actoin bar nu background change karva mate
        val colorDrawable = ColorDrawable(Color.parseColor("#FFFFFF"))
        supportActionBar!!.setBackgroundDrawable(colorDrawable)


        myshared = this.getSharedPreferences("mypref_file", Context.MODE_PRIVATE)
        editor = myshared.edit()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            android.R.id.home->
            {
                var i = Intent(this@Dashboard_Activity,Welcome_Activity::class.java)
                finish()
                startActivity(i)
            }
        }
        return super.onOptionsItemSelected(item)
    }




}