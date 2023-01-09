package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.widget.AppCompatButton

class UpdateDelet_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_delet)

        var ed_update_tile=findViewById<EditText>(R.id.ed_update_title)
        var ed_update_note=findViewById<EditText>(R.id.ed_update_note)
        var btn_update=findViewById<AppCompatButton>(R.id.btn_update)
        var btn_delete=findViewById<AppCompatButton>(R.id.btn_delete)



    }
}