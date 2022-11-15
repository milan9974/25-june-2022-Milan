package com.example.m4q4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var nevview=findViewById<BottomNavigationView>(R.id.nev_view)


        nevview.setOnItemSelectedListener {

            when(it.itemId)
            {
                R.id.login_menu -> {
                    loadfragment(login_fragment())
                }

                R.id.register_menu -> {
                    loadfragment(registration_fragment())
                }
            }
            return@setOnItemSelectedListener true
        }


    }
    fun loadfragment(fragment : Fragment)
    {
        var transaction=supportFragmentManager.beginTransaction()
        transaction.replace(R.id.bottom_container,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}