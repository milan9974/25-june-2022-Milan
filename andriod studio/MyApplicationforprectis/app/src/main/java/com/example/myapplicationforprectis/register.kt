package com.example.myapplicationforprectis

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class register : AppCompatActivity() {

    lateinit var edEmail :EditText
    lateinit var edPassword : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rgister)

        edEmail = findViewById<EditText>(R.id.ed_email)
        edPassword = findViewById<EditText>(R.id.ed_password)
        val tvLogin = findViewById<TextView>(R.id.tv_login)
        val btnRegister = findViewById<Button>(R.id.btn_register)

        tvLogin.setOnClickListener {
            startActivity(Intent(this,Login::class.java))
            finish()
        }
        val myShared : SharedPreferences = this.getSharedPreferences("myshared",Context.MODE_PRIVATE)
        val editor : Editor = myShared.edit()

        val database=MyDatabase(this@register)

        if (myShared.getBoolean("status",false)){
            startActivity(Intent(this,dashboard::class.java))
            finish()
        }

        btnRegister.setOnClickListener {
            if (edEmail.text.toString()!="" && edPassword.text.toString()!=""){
                if(android.util.Patterns.EMAIL_ADDRESS.matcher(edEmail.text.toString()).matches()){
                    val insertId = database.addData(mymodel(it.id!!,edEmail.text.toString(),edPassword.text.toString()))
                    if (insertId>0){
                        editor.putString("email",edEmail.text.toString())
                        editor.putString("password",edPassword.text.toString())
                        editor.apply()
                        editor.commit()

                        Toast.makeText(this, "Successfully Register", Toast.LENGTH_SHORT).show()

                        val i = Intent(this,Login::class.java)
                        i.putExtra("email",edEmail.text.toString())
                        i.putExtra("password",edPassword.text.toString())
                        startActivity(i)
                        finish()

                        finish()
                    }else{
                        Toast.makeText(this, "Something Wrong", Toast.LENGTH_SHORT).show()
                    }
                } else{
                    edEmail.error = "Enter valid email"
                }
            }else{
                Toast.makeText(this, "Required all fields", Toast.LENGTH_SHORT).show()
            }
        }

//        edEmail.addTextChangedListener(object :TextWatcher{
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//
//            }
//
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//
//            }
//
//            override fun afterTextChanged(s: Editable?) {
//                if (android.util.Patterns.EMAIL_ADDRESS.matcher(edEmail.text.toString()).matches()){
//                    btnRegister.isEnabled = true
//                }
//                else{
//                    edEmail.error = "Enter valid email"
//                    btnRegister.isEnabled = false
//                }
//            }
//
//        })
    }

}