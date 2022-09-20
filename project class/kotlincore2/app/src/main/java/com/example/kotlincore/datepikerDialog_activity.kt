package com.example.kotlincore

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.icu.util.Calendar
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.annotation.RequiresApi

class datepikerDialog_activity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.N)
    var d=Calendar.getInstance()
    @RequiresApi(Build.VERSION_CODES.N)
    var date=d.get(Calendar.DAY_OF_MONTH)
    @RequiresApi(Build.VERSION_CODES.N)
    var month=d.get(Calendar.MONTH)
    @RequiresApi(Build.VERSION_CODES.N)
    var year=d.get(Calendar.YEAR)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datepicture_dialog)

        var dbtn=findViewById<Button>(R.id.btndatepiker1)
        var btntime=findViewById<Button>(R.id.btntime)

        dbtn.setOnClickListener {

            var d_dialog=DatePickerDialog(this@datepikerDialog_activity,
                DatePickerDialog.OnDateSetListener
                { view, year, month, dayOfMonth ->

                    var m=month+1
                    dbtn.setText("$dayOfMonth-$m-$year")

                },d.get(Calendar.YEAR),d.get(Calendar.MONTH),d.get(Calendar.DAY_OF_MONTH))
                .show()
        }

        btntime.setOnClickListener {
            var time=TimePickerDialog(this@datepikerDialog_activity,
                TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->

                    btntime.setText("$hourOfDay : $minute")
                },d.get(Calendar.HOUR_OF_DAY),d.get(Calendar.MINUTE),true)
                .show()
        }

    }
}