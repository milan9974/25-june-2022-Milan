package com.example.bottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class bottomnavigation_activity : AppCompatActivity() {

    lateinit var bottomnavigation:BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottomnavigation)

        bottomnavigation=findViewById(R.id.bottonnavigationn_view)
        loadfragment(homeFragment())


        bottomnavigation.setOnItemSelectedListener {

            when(it.itemId)
            {
                R.id.b_home->{
                    loadfragment(homeFragment())
                }
                R.id.b_profile->{
                    loadfragment(profileFragment())
                }
                R.id.b_setting->{
                    loadfragment(settingFragment())
                }
            }
            return@setOnItemSelectedListener true
        }
        }

        fun loadfragment(fragment: Fragment)
        {
            val transaction= supportFragmentManager.beginTransaction()
            transaction.replace(R.id.bottom_container,fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
}