package com.example.shared_preference

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.math.log

class dashborad_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashborad)

        var tv_display=findViewById<TextView>(R.id.tv_display)
        var logout=findViewById<Button>(R.id.logout)

        var myshared: SharedPreferences = this.getSharedPreferences("mypref_file", Context.MODE_PRIVATE)
        var editor: SharedPreferences.Editor = myshared.edit()

        tv_display.setText(myshared.getString("username","default"))

        logout.setOnClickListener {
            editor.putBoolean("status",false)
            editor.apply()
            editor.commit()

            var i = Intent(this,login_activity::class.java)
            finish()
            startActivity(i)
        }


    }
}