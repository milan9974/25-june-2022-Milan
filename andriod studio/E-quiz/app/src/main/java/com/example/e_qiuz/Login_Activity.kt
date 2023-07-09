package com.example.e_qiuz

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class Login_Activity : AppCompatActivity() {
    @SuppressLint("Range")
    lateinit var ed_email_login : EditText
    lateinit var ed_pass_login : EditText

    lateinit var myshared : SharedPreferences
    lateinit var editor : SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar!!.hide()



        ed_email_login=findViewById(R.id.ed_email_login)
        ed_pass_login=findViewById(R.id.ed_password_login)
        var btn_login = findViewById<Button>(R.id.btn_login)

//        var mydatabase = Database(applicationContext)
//        var db= mydatabase.readableDatabase

        myshared  = this.getSharedPreferences("mypref_file", Context.MODE_PRIVATE)
        editor = myshared.edit()

        if (myshared.getBoolean("status",false))
        {
            var i =Intent(this,Welcome_Activity::class.java)
            finish()
            startActivity(i)
        }

        btn_login.setOnClickListener {

            if (ed_email_login.text.toString()!="" && ed_pass_login.text.toString()!=""){
                val email = myshared.getString("email","default")
                val pass = myshared.getString("password","default")
                if (email.equals(ed_email_login.text.toString()) && pass.equals(ed_pass_login.text.toString())){
                    editor.putBoolean("status",true)
                    editor.apply()
                    editor.commit()

                    var i =Intent(this,Welcome_Activity::class.java)
                    finish()
                    startActivity(i)
                }
                else{
                    var ad = AlertDialog.Builder(this)
                    ad.setTitle("Message")
                    ad.setMessage("Email or Password is incorrect!")
                    ad.setPositiveButton("Ok", null)
                    ad.show()
                }
            }
            else{
                Toast.makeText(this, "Enter all filed", Toast.LENGTH_SHORT).show()
            }
        }


//        ed_email_login.addTextChangedListener(object: TextWatcher {
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//
//            }
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//
//            }
//            override fun afterTextChanged(s: Editable?) {
//                if (android.util.Patterns.EMAIL_ADDRESS.matcher(ed_email_login.text.toString()).matches())
//                {
//                    btn_login.isEnabled = true
//                }
//                else
//                {
//                    btn_login.isEnabled = false
//                    ed_email_login.error = "Enter valid email"
//                }
//            }
//        })

        var tv_register_link = findViewById<TextView>(R.id.tv_register_link)

        tv_register_link.setOnClickListener {
            var i = Intent(this@Login_Activity,Register_Activity::class.java)
            finish()
            startActivity(i)
        }
    }
}