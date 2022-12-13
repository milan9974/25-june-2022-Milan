package com.example.employee

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class Login_Activity : AppCompatActivity() {

    lateinit var i : Intent


    lateinit var firebaseAuth: FirebaseAuth
    lateinit var firebaseuser: FirebaseUser

    lateinit var ed_email_login : EditText
    lateinit var ed_password_login : EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        firebaseAuth =FirebaseAuth.getInstance()
//        firebaseuser = firebaseAuth.currentUser!!

//        if (firebaseuser!=null)
//        {
//            var i =Intent(this@Login_Activity,Dashboard_Activity::class.java)
//            finish()
//            startActivity(i)
//        }

        ed_email_login=findViewById(R.id.ed_email_login)
        ed_password_login=findViewById(R.id.ed_password_login)
        var btn_login=findViewById<AppCompatButton>(R.id.btn_login_login)
        var tv_register=findViewById<TextView>(R.id.tv_register)

        tv_register.setOnClickListener {
            i = Intent(this@Login_Activity,Register_Activity::class.java)
            finish()
            startActivity(i)
        }

        ed_email_login.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                if (android.util.Patterns.EMAIL_ADDRESS.matcher(ed_email_login.text.toString()).matches())
                {
                    btn_login.isEnabled = true
                }

                else
                {
                    btn_login.isEnabled = false
                    ed_email_login.error = "Invalid email"
                }
            }

        })

        btn_login.setOnClickListener {


            firebaseAuth.signInWithEmailAndPassword(ed_email_login.text.toString(),ed_password_login.text.toString())
                .addOnCompleteListener(this)
                {
                    if (it.isSuccessful)
                    {
                        i = Intent(this@Login_Activity, Dashboard_Activity::class.java)
                        finish()
                        startActivity(i)
                    }
                    else
                    {
                        Toast.makeText(this@Login_Activity, "U R not user", Toast.LENGTH_SHORT).show()
                    }
                }

        }
    }
}