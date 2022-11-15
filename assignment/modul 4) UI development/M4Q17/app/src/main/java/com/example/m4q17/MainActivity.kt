package com.example.m4q17

import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuItemCompat


class MainActivity : AppCompatActivity() {
    var listView: ListView? = null
    var list: ArrayList<String>? = null
    var adapter: ArrayAdapter<String>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView = findViewById<View>(R.id.listview) as ListView
        list = ArrayList()
        list!!.add("Apple")
        list!!.add("Banana")
        list!!.add("Pineapple")
        list!!.add("Orange")
        list!!.add("Lychee")
        list!!.add("Gavava")
        list!!.add("Peech")
        list!!.add("Melon")
        list!!.add("Watermelon")
        list!!.add("Papaya")
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, list!!)
        listView!!.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        val searchViewItem = menu.findItem(R.id.app_bar_search)
        val searchView = MenuItemCompat.getActionView(searchViewItem) as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                searchView.clearFocus()
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                adapter!!.filter.filter(newText)
                return false
            }
        })
        return super.onCreateOptionsMenu(menu)
    }
}