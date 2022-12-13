package com.example.e_qiuz

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View.OnCreateContextMenuListener
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.GridView
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gtappdevelopers.kotlingfgproject.MyAdapter

class Welcome_Activity : AppCompatActivity() {

    lateinit var gv:GridView
    lateinit var list: List<MyModel>

    lateinit var myshared : SharedPreferences
    lateinit var editor : SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        supportActionBar!!.title="EQuiz"

        // action bar ma left side icon set karva
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24)

        myshared = this.getSharedPreferences("mypref_file", Context.MODE_PRIVATE)
        editor = myshared.edit()

        gv=findViewById(R.id.gridview)
        list=ArrayList<MyModel>()

        list=list+MyModel(R.mipmap.instagram,"INSTAGRAM")
        list=list+MyModel(R.mipmap.google,"GOOGLE")
        list=list+MyModel(R.mipmap.facebooknew,"FACEBOOK")
        list=list+MyModel(R.mipmap.instagram,"INSTAGRAM")
        list=list+MyModel(R.mipmap.google,"GOOGLE")
        list=list+MyModel(R.mipmap.facebooknew,"FACEBOOK")
        list=list+MyModel(R.mipmap.instagram,"INSTAGRAM")
        list=list+MyModel(R.mipmap.google,"GOOGLE")
        list=list+MyModel(R.mipmap.facebooknew,"FACEBOOK")


        var adpter=MyAdapter(list,this@Welcome_Activity)
        gv.adapter=adpter

        gv.setOnItemClickListener(AdapterView.OnItemClickListener { parent, view, position, id ->
            Toast.makeText(applicationContext,"Select "+list[position].title, Toast.LENGTH_SHORT).show()

            if (position==0)
            {
                var i = Intent(this@Welcome_Activity,Dashboard_Activity::class.java)

                startActivity(i)
            }
            else if (position==1)
            {
                var i = Intent(this@Welcome_Activity,Dashboard_Activity::class.java)
                startActivity(i)
            }
            else if (position==2)
            {
                var i = Intent(this@Welcome_Activity,Dashboard_Activity::class.java)
                startActivity(i)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.mymenu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.op_aboutus ->{
                Toast.makeText(this, "About us", Toast.LENGTH_SHORT).show()
            }

            R.id.op_contactus ->{
                Toast.makeText(this, "Contact us", Toast.LENGTH_SHORT).show()
            }

            R.id.op_logout ->{
                editor.putBoolean("status",false)
                editor.apply()
                editor.commit()

                var intent = Intent(this,Login_Activity :: class.java)
                finish()
                startActivity(intent)
            }
        }

        return super.onOptionsItemSelected(item)
    }
}