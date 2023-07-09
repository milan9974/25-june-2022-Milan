package com.example.tablayout

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MyAdapter( var context: Context, fm: FragmentManager,var totalTabBar:Int):FragmentPagerAdapter(fm)
{
    override fun getCount(): Int {
        return totalTabBar
    }

    override fun getItem(position: Int): Fragment {
        when(position){
            0 ->{
                return HomeFragment()
            }
            1->{
                return SettingFragment()
            }

            else -> return HomeFragment()

        }
    }
}