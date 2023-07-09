package com.example.e_qiuz

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class Dashboard_Activity : AppCompatActivity() {

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        // action bar ni andar title no color change karva mate
        val text: Spannable = SpannableString(supportActionBar!!.title)
        text.setSpan(ForegroundColorSpan(Color.BLACK),0, text.length, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
        supportActionBar!!.title = text

        // action bar ma left side icon set karva
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24)

        // akha action bar nu background change karva mate
        val colorDrawable = ColorDrawable(Color.parseColor("#FFFFFF"))
        supportActionBar!!.setBackgroundDrawable(colorDrawable)

        val rev = findViewById<RecyclerView>(R.id.rev)
        rev.layoutManager = LinearLayoutManager(this@Dashboard_Activity)
        val mylist = ArrayList<Read_Model>()

        mylist.add(Read_Model("1. The ratio of width of our National flag to its length is","Ans. 2:3"))
        mylist.add(Read_Model("2. 'Dandia' is a popular dance of","Ans. Gujarat"))
        mylist.add(Read_Model("3. Which of the following folk dance forms is associated with Gujarat?","Ans. Garba"))
        mylist.add(Read_Model("4. Which of the following folk dance forms is associated with Gujarat?","Ans. Kerala"))
        mylist.add(Read_Model("5. The Rath Yatra at Puri is celebrated in honour of which Hindu deity","Ans. Jaganath"))
        mylist.add(Read_Model("6. The National Anthem was first sung in the year","Ans. 1911"))
        mylist.add(Read_Model("7. The National Song of India was composed by","Ans. Bankim Chandra Chatterji"))
        mylist.add(Read_Model("8. Who composed the famous song 'Sare Jahan Se Achha'?","Ans. Mohammad Iqbal"))
        mylist.add(Read_Model("9. Which city is known as 'Electronic City of India'?","Ans. Bangalore"))
        mylist.add(Read_Model("10. The 'Char Minar' is in","Ans. Hyderabad"))

        val adapter=ReadAdapter(this@Dashboard_Activity,mylist)
        rev.adapter = adapter

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            android.R.id.home->
            {
                startActivity(Intent(this,Welcome_Activity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }
}