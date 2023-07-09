package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class All_memberinfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_memberinfo)

        var recyclerView=findViewById<RecyclerView>(R.id.rv_display)

        recyclerView.layoutManager= LinearLayoutManager(all_student@this)

        var retrofit = Retrofit.Builder().baseUrl("https://ravishing-piece.000webhostapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyApiInterface::class.java)

        var result= retrofit.get_all_data()

        result.enqueue(object: Callback<List<MemberDataItem>?>
        {
            override fun onResponse(
                call: Call<List<MemberDataItem>?>,
                response: Response<List<MemberDataItem>?>
            ) {
                var responseBody = response.body() as List<MemberDataItem>

                var mystudentadapter= MemberAdapter(applicationContext,responseBody)
                recyclerView.adapter=mystudentadapter
            }

            override fun onFailure(call: Call<List<MemberDataItem>?>, t: Throwable)
            {
                Log.d("mydata","fail----"+t.message.toString())
            }

        })
    }
}