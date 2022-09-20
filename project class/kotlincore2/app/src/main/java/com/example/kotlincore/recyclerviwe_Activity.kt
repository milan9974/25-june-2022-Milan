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



        var recyclerviwe=findViewById<RecyclerView>(R.id.myrecycleview)
        recyclerviwe.layoutManager=LinearLayoutManager(this@recyclerviwe_Activity)

        var Mylist=ArrayList<mymodel>()

        Mylist.add(mymodel(R.drawable.wall,"ANDROID"))
        Mylist.add(mymodel(R.drawable.wall,"JAVA"))

        var adapter=myAdapter(this@recyclerviwe_Activity,Mylist)
        recyclerviwe.adapter=adapter
    }
}