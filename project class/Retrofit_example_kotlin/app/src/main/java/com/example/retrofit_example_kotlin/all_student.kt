package com.example.retrofit_example_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class all_student : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_student)

        var recyclerView=findViewById<RecyclerView>(R.id.rv_display)

        recyclerView.layoutManager= LinearLayoutManager(all_student@this)

        var retrofit = Retrofit.Builder().baseUrl("https://ravishing-piece.000webhostapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(apiinterface::class.java)

        var result= retrofit.get_all_data()

        result.enqueue(object: Callback<List<studentdataitem>?>
        {
            override fun onResponse(
                call: Call<List<studentdataitem>?>,
                response: Response<List<studentdataitem>?>
            ) {
                var responseBody = response.body() as List<studentdataitem>

                var mystudentadapter= MyAdapter(this@all_student,responseBody)
                recyclerView.adapter=mystudentadapter
            }

            override fun onFailure(call: Call<List<studentdataitem>?>, t: Throwable)
            {
                Log.d("mydata","fail----"+t.message.toString())
            }

        })
    }
}