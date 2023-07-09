package com.example.myapplicationforprectis

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(var context: Context, var myList: MutableList<mymodel>):RecyclerView.Adapter<MyAdapter.myclass>() {

    class myclass(view:View):RecyclerView.ViewHolder(view){
        val tvEmail = view.findViewById<TextView>(R.id.tv_email)
        val tvPassword = view.findViewById<TextView>(R.id.tv_password)
        val clickonclard = view.findViewById<CardView>(R.id.clickncard)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myclass {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.myrowlayout,parent,false)
        return myclass(v)
    }

    override fun onBindViewHolder(holder: myclass, position: Int) {
        val my = myList[position]
        holder.tvEmail.setText("Email : "+my.email)
        holder.tvPassword.setText("Password : "+my.password)

        holder.clickonclard.setOnClickListener {
            val d = Dialog(context)
            d.setContentView(R.layout.dialog)
            d.show()

            val edEmailDialog = d.findViewById<EditText>(R.id.ed_email_dialog)
            val edPasswordDialog = d.findViewById<EditText>(R.id.ed_password_dialog)
            val btnUpdate = d.findViewById<Button>(R.id.btn_update)
            val btnDelete = d.findViewById<Button>(R.id.btn_delete)

            edEmailDialog.setText(my.email)
            edPasswordDialog.setText(my.password)
            
            btnUpdate.setOnClickListener { 
                val mydb = MyDatabase(context)
                val mmodel = mymodel(my.id,edEmailDialog.text.toString(),edPasswordDialog.text.toString())
                mydb.update(mmodel)

                val i = Intent(context,dashboard::class.java)
                (context as Activity).finish()
                context.startActivity(i)
            }
            
            btnDelete.setOnClickListener {
                val mydb = MyDatabase(context)

                val mmodel = mymodel(my.id,my.email,my.password)
                mydb.delete(mmodel)

                val i = Intent(context,dashboard::class.java)
                (context as Activity).finish()
                context.startActivity(i)
            }
        }
    }

    override fun getItemCount(): Int {
        return myList.size
    }
}