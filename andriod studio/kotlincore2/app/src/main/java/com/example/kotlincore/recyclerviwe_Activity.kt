package com.example.kotlincore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class recyclerviwe_Activity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerviwe)



        val recyclerviwe=findViewById<RecyclerView>(R.id.myrecycleview)
        recyclerviwe.layoutManager=LinearLayoutManager(this@recyclerviwe_Activity,LinearLayoutManager.VERTICAL,true)


        val Mylist=ArrayList<mymodel>()

        Mylist.add(mymodel(R.drawable.wall,"ANDROID"))
        Mylist.add(mymodel(R.drawable.wall,"JAVA"))

        val adapter=myAdapter(this@recyclerviwe_Activity,Mylist)
        recyclerviwe.adapter=adapter
    }
}