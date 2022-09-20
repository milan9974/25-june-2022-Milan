package com.example.kotlincore

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class myAdapter (var context: Context,var myarraylist:ArrayList<mymodel>):RecyclerView.Adapter<myAdapter.myclass> ()
{


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myclass {
        var v=LayoutInflater.from(parent.context).inflate(R.layout.myrow_layout,parent,false)
        return myclass(v)
    }

    override fun onBindViewHolder(holder: myclass, position: Int) {
        var my= myarraylist[position]
        holder.imviwe.setImageResource(my.img)
        holder.tv.setText(my.title)
    }

    override fun getItemCount(): Int {
        return  myarraylist.size
    }

    class myclass(itemView:View): RecyclerView.ViewHolder(itemView)
    {
        var imviwe=itemView.findViewById<ImageView>(R.id.imviwerowlayout)
        var tv=itemView.findViewById<TextView>(R.id.tvnamerow)
    }
}