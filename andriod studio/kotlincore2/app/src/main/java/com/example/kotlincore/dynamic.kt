package com.example.kotlincore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class dynamic : AppCompatActivity() {

    lateinit var eddata:EditText
    lateinit var btnsave:Button
    lateinit var lv:ListView
    var arrayList:ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dynamic)

        eddata=findViewById(R.id.eddataelement)
        btnsave=findViewById(R.id.btnsaveinlist)
        lv=findViewById(R.id.lvdata)

        btnsave.setOnClickListener {

            arrayList.add(eddata.text.toString())
            eddata.text.clear()
            val arrayAdapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList)
            lv.adapter=arrayAdapter
        }
        lv.setOnItemLongClickListener { parent, view, position, id ->
            Toast.makeText(this, "Long item click", Toast.LENGTH_SHORT).show()
            true
        }

    }
}