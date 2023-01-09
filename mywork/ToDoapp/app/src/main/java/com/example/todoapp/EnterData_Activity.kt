package com.example.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton

class EnterData_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter_data)

        var ed_enter_title = findViewById<EditText>(R.id.ed_enter_title)
        var ed_enter_notes = findViewById<EditText>(R.id.ed_enter_note)
        var btn_enter_add = findViewById<AppCompatButton>(R.id.btn_enter_add)
        var backarrow = findViewById<ImageView>(R.id.backarrow)

        backarrow.setOnClickListener {
            var i = Intent(this@EnterData_Activity, MainActivity::class.java)
            finish()
            startActivity(i)
        }
        var mydatabase=MyDatabase(this@EnterData_Activity)

        btn_enter_add.setOnClickListener {

            var insertId=mydatabase.add_data(mymodel(it.id,ed_enter_title.text.toString(),ed_enter_notes.text.toString()))

            if (insertId>1) {
                Toast.makeText(this, "Successfully add data", Toast.LENGTH_SHORT).show()
                Log.d("mydata", "id=$insertId")
                var i = Intent(this@EnterData_Activity, MainActivity::class.java)
                finish()
                startActivity(i)
            }
        }
    }
}