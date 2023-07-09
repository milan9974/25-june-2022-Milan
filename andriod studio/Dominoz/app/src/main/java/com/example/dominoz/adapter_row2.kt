package com.example.dominoz

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class adapter_row2(var context: Context, var arraylist2: ArrayList<model_row2>):RecyclerView.Adapter<adapter_row2.myclass2>()
{

    class myclass2(itemview2:View):RecyclerView.ViewHolder(itemview2)
    {
        var row2img=itemview2.findViewById<ImageView>(R.id.row2img)
        var row2textview=itemview2.findViewById<TextView>(R.id.row2textview)
        var row2textview2=itemview2.findViewById<TextView>(R.id.row2textview2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myclass2 {
        var view2=LayoutInflater.from(parent.context).inflate(R.layout.row2_layout,parent,false)
        return myclass2(view2)
    }

    override fun onBindViewHolder(holder: myclass2, position: Int) {
        var mylist2=arraylist2[position]
        holder.row2img.setImageResource(mylist2.img)
        holder.row2textview.setText(mylist2.title)
        holder.row2textview2.setText(mylist2.name)
    }

    override fun getItemCount(): Int {
        return  arraylist2.size
    }


}
