package com.example.retrofit_example_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ed_email_login=findViewById<EditText>(R.id.ed_email_login)
        val ed_password_login=findViewById<EditText>(R.id.ed_password_login)
        val btn_login=findViewById<Button>(R.id.btn_login)
        val tv_register_link=findViewById<TextView>(R.id.tv_register_link)

        tv_register_link.setOnClickListener {
            val i=Intent(this,Registration_activity::class.java)
            finish()
            startActivity(i)
        }

        val retrofit = Retrofit.Builder().baseUrl("https://ravishing-piece.000webhostapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(apiinterface::class.java)

        btn_login.setOnClickListener {

            val result = retrofit.login(ed_email_login.text.toString(),ed_password_login.text.toString())

            result.enqueue(object:Callback<List<studentdataitem>?> {
                override fun onResponse(
                    call: Call<List<studentdataitem>?>,
                    response: Response<List<studentdataitem>?>
                ) {
                        val responseBody = response.body()
                        for(data in responseBody!!)
                        {
                            Toast.makeText(this@MainActivity, "Login successfully", Toast.LENGTH_SHORT).show()
                            Log.d("mydata","Name---"+data.name)
                            startActivity(Intent(this@MainActivity,all_student::class.java))
                            finish()
                        }
                }

                override fun onFailure(call: Call<List<studentdataitem>?>, t: Throwable)
                {
                    Log.d("mydata","fail----"+t.message.toString())
                }

            })
        }
    }
}