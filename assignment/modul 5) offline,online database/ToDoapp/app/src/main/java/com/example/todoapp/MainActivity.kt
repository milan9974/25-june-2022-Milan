package com.example.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var fb_plus = findViewById<FloatingActionButton>(R.id.fb_plus)


        fb_plus.setOnClickListener{
            var i = Intent(this@MainActivity, EnterData_Activity::class.java)
            finish()
            startActivity(i)
        }

        var recyclerview : RecyclerView = findViewById(R.id.rv_save_data)

        recyclerview.layoutManager = StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL)

        var mydb=MyDatabase(this)

        var userList: MutableList<mymodel> = ArrayList()

        userList= mydb.getall_data()

        var myAdapter=MyAdapter(this@MainActivity,userList)
        recyclerview.adapter=myAdapter

    }
}