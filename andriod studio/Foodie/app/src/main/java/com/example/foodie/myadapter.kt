package com.example.foodie

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.NonDisposableHandle.parent
import org.w3c.dom.Text

class myadapter (var context:Context, var myarraylist:ArrayList<mymodel>):RecyclerView.Adapter<myadapter.myclass>()

{


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myclass {
        var v=LayoutInflater.from(parent.context).inflate(R.layout.rowfood,parent,false)
        return myclass(v)
    }

    override fun onBindViewHolder(holder: myclass, position: Int) {
        var my=myarraylist[position]
        holder.imageview.setImageResource(my.img)
        holder.foodname.setText(my.foodname)
        holder.textlocation.setText(my.location)
    }

    override fun getItemCount(): Int {
        return myarraylist.size
    }

    class myclass(itemView:View):RecyclerView.ViewHolder(itemView)
    {
        var imageview=itemView.findViewById<ImageView>(R.id.imageview)
        var foodname=itemView.findViewById<TextView>(R.id.textfoodname)
        var textlocation=itemView.findViewById<TextView>(R.id.textlocatoin)
    }
}