package com.example.prectis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class recycleview_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recycleview_main)


        var recyclerview=findViewById<RecyclerView>(R.id.recycleview)
        recyclerview.layoutManager=LinearLayoutManager(this@recycleview_activity)

        var mylist=ArrayList<model>()
        mylist.add(model(R.mipmap.chirnjivi,"Chiru","Hi bro!"))
        mylist.add(model(R.mipmap.pushpa,"PUSHPA","hi"))
        mylist.add(model(R.mipmap.surya,"Surya","helo"))
        mylist.add(model(R.mipmap.salman,"Salman","hellooo"))
        mylist.add(model(R.mipmap.jaklin,"JEKLIN","hi"))
        mylist.add(model(R.mipmap.mahesh,"MAHESH","helo"))
        mylist.add(model(R.mipmap.prabhas,"PRABHAS","hellooo"))
        mylist.add(model(R.mipmap.rashmika,"RASHMIKA","hi"))
        mylist.add(model(R.mipmap.raviteja,"RAVI TEJA","helo"))
        mylist.add(model(R.mipmap.tamnna,"TAMNNA","hellooo"))



        var adapter=myadapter(this@recycleview_activity,mylist)
        recyclerview.adapter=adapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.mymenu,menu)
        return super.onCreateOptionsMenu(menu)
    }
}