package com.example.kotlincore

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog

class alertdailog_activity : AppCompatActivity() {

    lateinit var btn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alertdailog)

        btn=findViewById(R.id.btnalert)

        btn.setOnClickListener {

            AlertDialog.Builder(this)
                .setTitle("Alert")
                .setMessage("Are you want to close")
                .setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, which ->
                  finish()
                })

                .setNegativeButton("No", DialogInterface.OnClickListener { dialog, which ->
                    dialog.dismiss()
                })

                .setNeutralButton("Cancel", DialogInterface.OnClickListener { dialog, which ->
                    dialog.cancel()
                })
                .show()
        }
    }
}