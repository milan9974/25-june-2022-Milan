package com.example.e_qiuz

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.Menu
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast

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

        // action bar ni andar title no color change karva mate
        val text: Spannable = SpannableString(supportActionBar!!.title)
        text.setSpan(ForegroundColorSpan(Color.BLACK), 0, text.length, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
        supportActionBar!!.title = text

        // akha actoin bar nu background change karva mate
        val colorDrawable = ColorDrawable(Color.parseColor("#FFFFFF"))
        supportActionBar!!.setBackgroundDrawable(colorDrawable)

        myshared = this.getSharedPreferences("mypref_file", Context.MODE_PRIVATE)
        editor = myshared.edit()

        gv=findViewById(R.id.gridview)
        list=ArrayList<MyModel>()

        list=list+MyModel(R.mipmap.gk,"General Knowledge")
        list=list+MyModel(R.drawable.readque,"Read Q&A")
//        list=list+MyModel(R.mipmap.facebooknew,"FACEBOOK")


        val adpter=MyAdapter(list,this@Welcome_Activity)
        gv.adapter=adpter

        gv.setOnItemClickListener(AdapterView.OnItemClickListener { parent, view, position, id ->
            Toast.makeText(applicationContext,"Select "+list[position].title, Toast.LENGTH_SHORT).show()

            if (position==0)
            {
                val i = Intent(this@Welcome_Activity,Question_Activity::class.java)
                startActivity(i)
            }
            else if (position==1)
            {
                val i = Intent(this@Welcome_Activity,Dashboard_Activity::class.java)
                startActivity(i)
            }
            else if (position==2)
            {
                val i = Intent(this@Welcome_Activity,Dashboard_Activity::class.java)
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

                val intent = Intent(this,Login_Activity :: class.java)
                finish()
                startActivity(intent)
            }

            R.id.op_profile -> {
                startActivity(Intent(this,Profile_Activity::class.java))
            }
        }

        return super.onOptionsItemSelected(item)
    }
}