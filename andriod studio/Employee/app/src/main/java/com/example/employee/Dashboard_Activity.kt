package com.example.employee

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.annotation.RequiresApi
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth

class Dashboard_Activity : AppCompatActivity() {

    lateinit var i :Intent

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        supportActionBar!!.setTitle("Dashboard")

        var fab_add_btn =findViewById<FloatingActionButton>(R.id.fab_add_btn)

        fab_add_btn.setOnClickListener {

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.mymenu,menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId)
        {
            R.id.op_profile ->
            {
                var i = Intent(this@Dashboard_Activity,Profile_Activity::class.java)
                startActivity(i)
            }

            R.id.op_setting ->
            {
                var i = Intent(this, Setting_Activity::class.java)
                startActivity(i)
            }

            R.id.op_logout ->
            {
                var i = Intent(this, Login_Activity::class.java)
                startActivity(i)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}