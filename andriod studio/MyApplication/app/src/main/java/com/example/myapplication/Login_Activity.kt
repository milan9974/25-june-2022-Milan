package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class Login_Activity : AppCompatActivity() {

    lateinit var firebaseAuth : FirebaseAuth
    lateinit var firebaseuser : FirebaseUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_activity)

        var ed_email_login=findViewById<EditText>(R.id.ed_email_login)
        var ed_password_login=findViewById<EditText>(R.id.ed_password_login)
        var btn_login=findViewById<Button>(R.id.btn_login)
        var newuser = findViewById<TextView>(R.id.newuser)

        firebaseAuth = FirebaseAuth.getInstance()
//        firebaseuser = firebaseAuth.currentUser!!
//
//        if (firebaseuser!=null)
//        {
//            var i =Intent(this@Login_Activity,Dashboard_Activity::class.java)
//            finish()
//            startActivity(i)
//        }

        newuser.setOnClickListener {
            var i = Intent(this@Login_Activity, MainActivity::class.java)
            finish()
            startActivity(i)
        }

        btn_login.setOnClickListener {

            firebaseAuth.signInWithEmailAndPassword(ed_email_login.text.toString(), ed_password_login.text.toString())
                .addOnCompleteListener(this)
                {
                    if (it.isSuccessful)
                    {
                        var i=Intent(this@Login_Activity,Dashboard_Activity::class.java)
                        finish()
                        startActivity(i)
                    }
                }
        }
    }
}