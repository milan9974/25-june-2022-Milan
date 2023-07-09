package com.example.myapplication

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.ActivityCompat

class Send_SMS_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_sms)

        var ed_sms_typ=findViewById<EditText>(R.id.ed_sms_typ)
        var ed_contact_forsendmessage=findViewById<EditText>(R.id.ed_contact_forsendmessage)
        var btn_send_sms = findViewById<Button>(R.id.btn_send_sms)

        ActivityCompat.requestPermissions(this@Send_SMS_Activity, arrayOf(Manifest.permission.SEND_SMS),1)

        btn_send_sms.setOnClickListener {
            var number = ed_contact_forsendmessage.text.toString()
            var message = ed_sms_typ.text.toString()

            var smsManager : SmsManager=SmsManager.getDefault()
            smsManager.sendTextMessage(number,null,message,null,null)
            Toast.makeText(this, "Send msg Done", Toast.LENGTH_SHORT).show()
            ed_sms_typ.text.clear()
            ed_contact_forsendmessage.text.clear()
        }
    }
}