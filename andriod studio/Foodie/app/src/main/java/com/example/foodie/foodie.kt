package com.example.foodie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class foodie : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.foodie_main)

        var recycleview=findViewById<RecyclerView>(R.id.recycleview)
        recycleview.layoutManager=LinearLayoutManager(this@foodie)

        var mylist=ArrayList<mymodel>()
        mylist.add(mymodel(R.mipmap.cornpizza,"Corn PIZZA","Shivranjani"))
        mylist.add(mymodel(R.mipmap.fourchessespizza,"4 Chesses PIZZA","Nehrunagr"))
        mylist.add(mymodel(R.mipmap.tandooripaneerpizza,"Tandoori Paneer PIZZA","Law garden"))
        mylist.add(mymodel(R.mipmap.tomatopizza,"Tometa PIZZA","Maninagar"))

        var adapter=myadapter(this@foodie,mylist)
        recycleview.adapter=adapter
    }
}