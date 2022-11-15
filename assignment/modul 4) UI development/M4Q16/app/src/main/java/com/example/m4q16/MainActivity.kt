package com.example.m4q16

import android.R
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemClickListener
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var textview: TextView
    lateinit var arrayList: ArrayList<String>
    lateinit var dialog: Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textview = findViewById(R.id.textView)

        arrayList = ArrayList()

        arrayList!!.add("DSA Self Paced")
        arrayList!!.add("Complete Interview Prep")
        arrayList!!.add("Amazon SDE Test Series")
        arrayList!!.add("Compiler Design")
        arrayList!!.add("Git & Github")
        arrayList!!.add("Python foundation")
        arrayList!!.add("Operating systems")
        arrayList!!.add("Theory of Computation")
        textview.setOnClickListener(View.OnClickListener {

            dialog = Dialog(this@MainActivity)

             dialog.setContentView(R.layout.dialog_searchable_spinner)

            dialog!!.window!!.setLayout(650, 800)

            dialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

            dialog!!.show()

            val editText = dialog!!.findViewById<EditText>(R.id.edit_text)
            val listView = dialog!!.findViewById<ListView>(R.id.list_view)

            val adapter = ArrayAdapter(
                this@MainActivity, R.layout.simple_list_item_1,
                arrayList!!
            )

            listView.adapter = adapter
            editText.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    adapter.filter.filter(s)
                }

                override fun afterTextChanged(s: Editable) {}
            })
            listView.onItemClickListener =
                OnItemClickListener { parent, view, position, id ->

                    textview.setText(adapter.getItem(position))

                    dialog!!.dismiss()
                }
        })
    }
}