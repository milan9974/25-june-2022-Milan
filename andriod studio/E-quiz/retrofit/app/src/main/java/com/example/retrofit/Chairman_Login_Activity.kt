package com.example.retrofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class Chairman_Login_Activity : AppCompatActivity() {

    lateinit var ed_chairman_email:EditText
    lateinit var ed_chairman_password:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chairman_login)

        ed_chairman_email=findViewById(R.id.ed_chairman_email)
        ed_chairman_password=findViewById(R.id.ed_chairman_password)

        var btn_chairman_login=findViewById<EditText>(R.id.btn_chairman_login)

        btn_chairman_login.setOnClickListener {
            if (inputIsNotEmpty()){
                var i3= Intent(this@Chairman_Login_Activity,All_memberinfo::class.java)
                startActivity(i3)
            }
        }
    }

    fun  inputIsNotEmpty():Boolean {
        var b = true;
        if (ed_chairman_email.text.toString().trim().isEmpty()) {
            ed_chairman_email.error = "Required"
            b = false;
        }
        if (ed_chairman_password.text.toString().trim().isEmpty()) {
            ed_chairman_password.error = "Required"
            b = false;
        }
        return b
    }


}