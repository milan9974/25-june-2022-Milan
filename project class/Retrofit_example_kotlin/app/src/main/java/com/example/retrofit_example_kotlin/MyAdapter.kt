package com.example.retrofit_example_kotlin

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter (var context:Context, var mystudentList:List<studentdataitem>):RecyclerView.Adapter<MyAdapter.MyClass>()
{
    class MyClass (itemView: View):RecyclerView.ViewHolder(itemView)
    {
        var tv_name=itemView.findViewById<TextView>(R.id.tv_name)
        var tv_email=itemView.findViewById<TextView>(R.id.tv_email)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyClass
    {
        var view= LayoutInflater.from(parent.context).inflate(R.layout.mystudent_all_row,parent,false)
        return MyClass(view)
    }

    override fun onBindViewHolder(holder: MyClass, position: Int)
    {
        var mystudent=mystudentList[position]

        holder.tv_name.text=mystudent.name
        holder.tv_email.text=mystudent.email

        holder.itemView.setOnClickListener {
            var i = Intent(context,inDetailsActivity::class.java)
            var id = mystudent.id
            i.putExtra("keyid",id)
            context.startActivity(i)
        }
    }

    override fun getItemCount(): Int
    {
        return mystudentList.size
    }

}