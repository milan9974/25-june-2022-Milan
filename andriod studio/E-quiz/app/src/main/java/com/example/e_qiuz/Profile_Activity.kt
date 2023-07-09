package com.example.e_qiuz

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.MenuItem
import android.widget.TextView

class Profile_Activity : AppCompatActivity() {
    @SuppressLint("RestrictedApi")

    lateinit var myshared: SharedPreferences
    lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        supportActionBar!!.title ="Profile"

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24)

        val text : Spannable = SpannableString(supportActionBar!!.title)
        text.setSpan(ForegroundColorSpan(Color.BLACK),0,text.length,Spannable.SPAN_INCLUSIVE_INCLUSIVE)

        supportActionBar!!.title = text

        val colorDrawable = ColorDrawable(Color.parseColor("#FFFFFF"))
        supportActionBar!!.setBackgroundDrawable(colorDrawable)

        myshared = this.getSharedPreferences("mypref_file", MODE_PRIVATE)
        editor = myshared.edit()

        val name = myshared.getString("name","")
        val email = myshared.getString("email","")


        val edNameProfile = findViewById<TextView>(R.id.ed_name_profile)
        val edEmailProfile = findViewById<TextView>(R.id.ed_email_profile)

        edNameProfile.setText(name)
        edEmailProfile.setText(email)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home ->{
                startActivity(Intent(this,Welcome_Activity::class.java))
                finish()
            }
        }

        return super.onOptionsItemSelected(item)
    }

}