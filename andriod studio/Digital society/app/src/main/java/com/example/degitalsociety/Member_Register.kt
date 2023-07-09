package com.example.degitalsociety

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class Member_Register : AppCompatActivity() {

    var tabLayout : TabLayout?=null
    var viewPager : ViewPager?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_member_register)

        tabLayout = findViewById(R.id.tab_layout)
        viewPager = findViewById(R.id.view_pager)

        tabLayout!!.addTab(tabLayout!!.newTab().setText("juni che aa"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("kam ni nathi"))

        var adapter1 = MyAdapter(this,supportFragmentManager, tabLayout!!.tabCount)
        viewPager!!.adapter = adapter1

        viewPager!!.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))

        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager!!.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }
}