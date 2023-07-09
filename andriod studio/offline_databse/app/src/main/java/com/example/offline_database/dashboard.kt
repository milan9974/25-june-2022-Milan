package com.example.offline_database

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        var recyclerview:RecyclerView=findViewById(R.id.rev_getdata)

        recyclerview.layoutManager=LinearLayoutManager(this@dashboard)

        var mydb=mydatabase(this)

        var userList: MutableList<mymodel> = ArrayList()

        userList= mydb.getall_data()

        var myAdapter=MyAdapter(this@dashboard,userList)
        recyclerview.adapter=myAdapter
    }
}