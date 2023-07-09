package com.example.kotlincore

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog

class alert_activity_close : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert_close)
    }

        override fun onBackPressed() {
            AlertDialog.Builder(this@alert_activity_close)
                .setTitle("Whatsapp")
                .setMessage("Do you want to close?")
                .setPositiveButton("yes", DialogInterface.OnClickListener { dialog, which ->
                    finish()
                })
                .setNegativeButton("No", DialogInterface.OnClickListener { dialog, which ->
                    dialog.dismiss()
                })
                .setCancelable(false)
                .show()
        }
    }
