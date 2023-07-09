package com.example.shared_preference

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class login_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var ed_email_l= findViewById<EditText>(R.id.ed_eamil_l)
        var ed_password_l = findViewById<EditText>(R.id.ed_password_l)
        var btn_login = findViewById<Button>(R.id.btn_login)

        var myshared: SharedPreferences = this.getSharedPreferences("mypref_file", Context.MODE_PRIVATE)
        var editor: SharedPreferences.Editor = myshared.edit()

        if (myshared.getBoolean("status",false))
        {
            var i =Intent(this,dashborad_activity::class.java)
            finish()
            startActivity(i)
        }

        btn_login.setOnClickListener {
            var email = myshared.getString("email","default")
            var pass = myshared.getString("password","default")

            if (email.equals(ed_email_l.text.toString()) && pass.equals(ed_password_l.text.toString()))
            {
                editor.putBoolean("status",true)
                editor.apply()
                editor.commit()

                var i =Intent(this,dashborad_activity::class.java)
                finish()
                startActivity(i)

            }

        }
    }
}