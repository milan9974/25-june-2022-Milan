package com.example.kotlincore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast

class menupractical : AppCompatActivity() {

    lateinit var btn:Button
    lateinit var btncontext:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menupractical)

        btn=findViewById(R.id.btnpopupmenu)
        btncontext=findViewById(R.id.btncontextmenu)

        registerForContextMenu(btncontext)


        btn.setOnClickListener {
            var pm: PopupMenu=PopupMenu(menupractical@this,btn)
            pm.menuInflater.inflate(R.menu.mymenu,pm.menu)
            pm.setOnMenuItemClickListener {

                when(it.itemId)
                {
                    R.id.op_setting-> Toast.makeText(this, "setting", Toast.LENGTH_SHORT).show()
                    R.id.op_logout-> Toast.makeText(this, "logout", Toast.LENGTH_SHORT).show()
                    R.id.op_profile-> Toast.makeText(this, "profile", Toast.LENGTH_SHORT).show()
                }
                true
            }
            pm.show()

        }
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        menuInflater.inflate(R.menu.mymenu,menu)
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.mymenu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        if (item.itemId==R.id.op_setting)
        {
            Toast.makeText(this, "setting activity called", Toast.LENGTH_SHORT).show()
        }

        if (item.itemId==R.id.op_profile)
        {
            Toast.makeText(this, "profile activity called", Toast.LENGTH_SHORT).show()
        }

        if (item.itemId==R.id.op_logout)
        {
            Toast.makeText(this, "logout activity called", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }


}