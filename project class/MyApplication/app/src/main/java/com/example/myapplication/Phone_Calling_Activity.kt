package com.example.myapplication

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.ActivityCompat

class Phone_Calling_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_calling)

        // Keep screen on
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        // phone call karva mate
        var ed_phonenumber = findViewById<EditText>(R.id.ed_phonenumber)
        var btn_call = findViewById<Button>(R.id.btn_call)

        ActivityCompat.requestPermissions(this@Phone_Calling_Activity, arrayOf(Manifest.permission.CALL_PHONE,Manifest.permission.SEND_SMS),2)

        btn_call.setOnClickListener {
            var i = Intent(Intent.ACTION_CALL)
            i.data = Uri.parse("tel:"+ed_phonenumber.text.toString())
            startActivity(i)
        }

        // SMS typ karine moklva mate
        var ed_sms_typ=findViewById<EditText>(R.id.ed_sms_typ)
        var ed_contact_forsendmessage=findViewById<EditText>(R.id.ed_contact_forsendmessage)
        var btn_send_sms = findViewById<Button>(R.id.btn_send_sms)

        btn_send_sms.setOnClickListener {
            var number = ed_contact_forsendmessage.text.toString()
            var message = ed_sms_typ.text.toString()

            var smsmanager : SmsManager = SmsManager.getDefault()

            smsmanager.sendTextMessage(number,null,message,null,null,)
            Toast.makeText(this@Phone_Calling_Activity, "SMS send Successfully", Toast.LENGTH_SHORT).show()
            ed_contact_forsendmessage.text.clear()
            ed_sms_typ.text.clear()
        }
    }
}