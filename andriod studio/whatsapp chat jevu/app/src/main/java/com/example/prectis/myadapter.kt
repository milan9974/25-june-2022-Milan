package com.example.prectis

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView

class myadapter (var context: Context,var arrayList: ArrayList<model>): RecyclerView.Adapter<myadapter.myclass>()
{
    class myclass(itemview:View):RecyclerView.ViewHolder(itemview)
    {
        var imgview=itemview.findViewById<ImageView>(R.id.imgview)
        var textview=itemview.findViewById<TextView>(R.id.textview)
        var smalltextview=itemview.findViewById<TextView>(R.id.smalltextview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myclass {
        var v=LayoutInflater.from(parent.context).inflate(R.layout.row_layout,parent,false)
        return myclass(v)
    }

    override fun onBindViewHolder(holder: myclass, position: Int) {
        var my= arrayList[position]
        holder.imgview.setImageResource(my.img)
        holder.textview.setText(my.title)
        holder.smalltextview.setText(my.mes)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }
}