package com.example.retrofit_example_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Registration_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        val ed_name_register=findViewById<EditText>(R.id.ed_name_register)
        val ed_email_register=findViewById<EditText>(R.id.ed_email_register)
        val ed_password_register=findViewById<EditText>(R.id.ed_password_register)

        val btn_register=findViewById<Button>(R.id.btn_regiter)
        val tv_login_link = findViewById<TextView>(R.id.tv_login_link)

        tv_login_link.setOnClickListener {

            val i = Intent(this, MainActivity::class.java)
            finish()
            startActivity(i)
        }
        val retrofit= Retrofit.Builder().baseUrl("https://ravishing-piece.000webhostapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(apiinterface::class.java)

        btn_register.setOnClickListener {

            val result= retrofit.insertData(ed_name_register.text.toString(),ed_email_register.text.toString(),ed_password_register.text.toString())

            result.enqueue(object :Callback<studentdataitem?>{
                override fun onResponse(
                    call: Call<studentdataitem?>,
                    response: Response<studentdataitem?>
                ) {
                        Log.d("mydata","success")
                }

                override fun onFailure(call: Call<studentdataitem?>, t: Throwable) {
                    Log.d("mydata","fail----")
                }

            })
        }
    }
}