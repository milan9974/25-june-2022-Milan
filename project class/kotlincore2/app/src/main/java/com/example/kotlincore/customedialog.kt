package com.example.kotlincore

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CompoundButton
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton

class customedialog : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customedialog)

        var btncustomdialog=findViewById<Button>(R.id.btncustomdialog)

        btncustomdialog.setOnClickListener {
            var d=Dialog(this@customedialog)
            d.setContentView(R.layout.customedialog)

                var eddatadialog= d.findViewById<EditText>(R.id.eddatadialog)
                var btnsubmitdialog= d.findViewById<Button>(R.id.btnsubmitdialog)
                var btncancle= d.findViewById<AppCompatButton>(R.id.btncnacle)

            btncancle.setOnClickListener {
                d.dismiss()
            }

            btnsubmitdialog.setOnClickListener {
                Toast.makeText(this, ""+eddatadialog.text.toString(), Toast.LENGTH_SHORT).show()
                d.dismiss()
            }

                d.show()
        }

    }
}