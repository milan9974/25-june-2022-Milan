package com.example.offline_database

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
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(var context:Context,var userlist:MutableList<mymodel>):RecyclerView.Adapter<MyAdapter.MyClass>()
{
    class MyClass(view:View):RecyclerView.ViewHolder(view)
    {
        var name =view.findViewById<TextView>(R.id.tv_name)
        var email =view.findViewById<TextView>(R.id.tv_email)
        var contact =view.findViewById<TextView>(R.id.tv_contact)

        var btn_edit=view.findViewById<Button>(R.id.btn_edit)
        var btn_delete=view.findViewById<Button>(R.id.btn_delete)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyClass {
        var view= LayoutInflater.from(parent.context).inflate(R.layout.myrow_layout,parent,false)
        return MyClass(view)
    }

    override fun onBindViewHolder(holder: MyClass, position: Int) {
        var mydata=userlist[position]
        holder.name.text=mydata.user_name
        holder.email.text=mydata.user_email
        holder.contact.text=mydata.user_contact

        holder.btn_edit.setOnClickListener {
            var dialog= Dialog(context)
            dialog.setContentView(R.layout.my_layout)
            dialog.show()

            var ednameupdate=dialog.findViewById<EditText>(R.id.ed_name_update)
            var edemailupdate=dialog.findViewById<EditText>(R.id.ed_email_update)
            var edcontactupdate=dialog.findViewById<EditText>(R.id.ed_contact_update)
//
//            ednameupdate.setText(mydata.user_name)
//            edemailupdate.setText(mydata.user_email)
//            edcontactupdate.setText(mydata.user_contact)

            var btnupdatedetails=dialog.findViewById<Button>(R.id.btn_update_details)

            ednameupdate.setText(mydata.user_name)
            edemailupdate.setText(mydata.user_email)
            edcontactupdate.setText(mydata.user_contact)

            btnupdatedetails.setOnClickListener {
                var mydb=mydatabase(context)

                var mymodel=mymodel(mydata.user_id,ednameupdate.text.toString(),edemailupdate.text.toString(),edcontactupdate.text.toString())
                mydb.updateData(mymodel)

                var i = Intent(context,second_Activity::class.java)
                context.startActivity(i)
                (context as Activity).finish()
            }

        }

        holder.btn_delete.setOnClickListener {
            var mydb = mydatabase(context)

            var mymodel= mymodel(mydata.user_id,mydata.user_name,mydata.user_email,mydata.user_contact)
            mydb.deletedata(mymodel)

            var i=Intent(context,dashboard::class.java)
            context.startActivity(i)
            (context as Activity).finish()

        }

    }

    override fun getItemCount(): Int {
      return  userlist.size
    }
}