package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.appcompat.widget.AppCompatButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Member_Register_Activity : AppCompatActivity() {

    lateinit var ed_firstname:EditText
    lateinit var ed_lastname:EditText
    lateinit var ed_email:EditText
    lateinit var ed_mobilenumber:EditText
    lateinit var ed_familymember:EditText
    lateinit var ed_occupation:EditText
    lateinit var ed_housenumber:EditText
    lateinit var ed_password:EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_member_register)

        ed_firstname=findViewById(R.id.ed_firstname)
        ed_lastname=findViewById(R.id.ed_lastname)
        ed_email=findViewById(R.id.ed_email)
        ed_mobilenumber=findViewById(R.id.ed_mobilenumber)
        ed_familymember=findViewById(R.id.ed_familymember)
        ed_occupation=findViewById(R.id.ed_occupation)
        ed_housenumber=findViewById(R.id.ed_housenumber)
        ed_password=findViewById(R.id.ed_password)

        var btn_register = findViewById<AppCompatButton>(R.id.btn_register)

        btn_register.setOnClickListener {

            register()

        }

    }

    fun  inputIsNotEmpty():Boolean {
        var b = true;
        if (ed_firstname.text.toString().trim().isEmpty()) {
            ed_firstname.error = "Required"
            b = false;
        }
        if (ed_lastname.text.toString().trim().isEmpty()) {
            ed_lastname.error = "Required"
            b = false;
        }
        if (ed_email.text.toString().trim().isEmpty()) {
            ed_email.error = "Required"
            b = false;
        }
        if (ed_mobilenumber.text.toString().trim().isEmpty()) {
            ed_mobilenumber.error = "Required"
            b = false;
        }
        if (ed_familymember.text.toString().trim().isEmpty()) {
            ed_familymember.error = "Required"
            b = false;
        }
        if (ed_occupation.text.toString().trim().isEmpty()) {
            ed_occupation.error = "Required"
            b = false;
        }
        if (ed_housenumber.text.toString().trim().isEmpty()) {
            ed_housenumber.error = "Required"
            b = false;
        }
        if (ed_password.text.toString().trim().isEmpty()) {
            ed_password.error = "Required"
            b = false;
        }
        return b;
    }
    fun register(){
        if (inputIsNotEmpty()){
            var retrofit= Retrofit.Builder().baseUrl("https://ravishing-piece.000webhostapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApiInterface::class.java)

            var result= retrofit.MemberInsertData(ed_firstname.text.toString(),ed_lastname.text.toString(),
                ed_email.text.toString(),ed_mobilenumber.text.toString(),ed_familymember.text.toString(),
                ed_occupation.text.toString(),ed_housenumber.text.toString(),ed_password.text.toString())

            result.enqueue(object : Callback<MyApiInterface?> {
                override fun onResponse(
                    call: Call<MyApiInterface?>,
                    response: Response<MyApiInterface?>
                ) {
                    Log.d("mydata","success")
                }

                override fun onFailure(call: Call<MyApiInterface?>, t: Throwable) {
                    Log.d("mydata","fail----")
                }

            })
        }
    }
}