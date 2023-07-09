package com.example.degitalsociety

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MyAdapter( var context: Context, fm:FragmentManager, var totalTab:Int):FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return totalTab
    }

    override fun getItem(position: Int): Fragment {
        when(position){
            0 ->{
                return LoginFragment()
            }
            1 ->{
                return RegisterFragment()
            }
            else -> return LoginFragment()
        }
    }
}