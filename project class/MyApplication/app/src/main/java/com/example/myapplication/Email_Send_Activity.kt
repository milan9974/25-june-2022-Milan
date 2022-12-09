package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Email_Send_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email_send)

        var ed_subjectfor_email=findViewById<EditText>(R.id.ed_subjectfor_email)
        var ed_email_for_send=findViewById<EditText>(R.id.ed_email_for_send)
        var ed_contentfor_email=findViewById<EditText>(R.id.ed_contentfor_email)
        var btn_send_email = findViewById<Button>(R.id.btn_send_email)

        btn_send_email.setOnClickListener {
            var intent = Intent(Intent.ACTION_SEND_MULTIPLE)
            intent.data = Uri.parse("mailto:")
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(ed_email_for_send.text.toString()))
            intent.putExtra(Intent.EXTRA_SUBJECT,ed_subjectfor_email.text.toString())
            intent.putExtra(Intent.EXTRA_TEXT,ed_contentfor_email.text.toString())

            startActivity(Intent.createChooser(intent,"Select Account"))
        }
    }
}