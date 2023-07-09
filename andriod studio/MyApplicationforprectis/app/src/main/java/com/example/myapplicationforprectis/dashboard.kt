package com.example.myapplicationforprectis

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class dashboard : AppCompatActivity() {

    lateinit var myshared: SharedPreferences
    lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val rev =findViewById<RecyclerView>(R.id.rev)
        rev.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,true)

        myshared = this.getSharedPreferences("myshared", Context.MODE_PRIVATE)
        editor = myshared.edit()

        val database = MyDatabase(this)

        var myList1: MutableList<mymodel> = ArrayList()
        myList1 =database.get_all_data()

        val myAdapter = MyAdapter(this@dashboard,myList1)
        rev.adapter= myAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.mymenu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){

            R.id.op_logout ->{
                editor.putBoolean("status",false)
                editor.apply()
                editor.commit()
                startActivity(Intent(this,Login::class.java))
                finish()
            }
        }

        return super.onOptionsItemSelected(item)
    }
}