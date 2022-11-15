package com.example.retrofit_example_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Data
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class inDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_in_details)

        var tv_username_display=findViewById<TextView>(R.id.tv_username_display)
        var get_password=findViewById<EditText>(R.id.get_password)

        var id = intent.getStringExtra("keyid")
        Log.d("mydata","my id:"+id)

        var retrofit = Retrofit.Builder().baseUrl("https://ravishing-piece.000webhostapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(apiinterface::class.java)

        var result = retrofit.specific_student(id!!)

        result.enqueue(object: Callback<List<studentdataitem>?>
        {
            override fun onResponse(
                call: Call<List<studentdataitem>?>,
                response: Response<List<studentdataitem>?>
            ) {
                var responseBody = response.body()
                for(data in responseBody!!)
                {
                    Log.d("mydata","Name - "+data.name)
                    tv_username_display.text=data.name
                    get_password.setText(data.password)
                };
            }

            override fun onFailure(call: Call<List<studentdataitem>?>, t: Throwable)
            {
                Log.d("mydata","fail----"+t.message.toString())
            }

        })

    }
}