
package com.example.offline_database

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var edname=findViewById<EditText>(R.id.edname)
        var edemail=findViewById<EditText>(R.id.edemail)
        var edcontact=findViewById<EditText>(R.id.edcontact)
        var btnadd=findViewById<Button>(R.id.btnadd)

//        var id:Int
        var mydatabase=mydatabase(this)

        btnadd.setOnClickListener {

            var insertId=mydatabase.insertData(mymodel(it.id!!,edname.text.toString(),edemail.text.toString(),edcontact.text.toString()))

            if (insertId>1)
            {
                Toast.makeText(this, "Successfully add data", Toast.LENGTH_SHORT).show()
                Log.d("mydata","id=$insertId")

                var i=Intent(MainActivity@this,second_Activity::class.java)
                startActivity(i)
            }
        }
    }
}