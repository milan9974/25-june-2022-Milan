package com.example.dominoz

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class adapter_row1(var context: Context, var arraylist1:ArrayList<model_row1>):RecyclerView.Adapter<adapter_row1.myclass1>()
{

    class myclass1(itemview:View):RecyclerView.ViewHolder(itemview)
    {
        var row1img=itemview.findViewById<ImageView>(R.id.row1img)
        var row1textview=itemview.findViewById<TextView>(R.id.row1textview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myclass1 {
        var view=LayoutInflater.from(parent.context).inflate(R.layout.row1_layout,parent,false)
        return myclass1(view)
    }

    override fun onBindViewHolder(holder: myclass1, position: Int) {
        var mylist1=arraylist1[position]
        holder.row1img.setImageResource(mylist1.img)
        holder.row1textview.setText(mylist1.title)
    }

    override fun getItemCount(): Int {
        return  arraylist1.size
    }


}
