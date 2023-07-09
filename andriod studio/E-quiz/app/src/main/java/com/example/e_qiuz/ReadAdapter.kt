package com.example.e_qiuz

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ReadAdapter(var context: Context,var questionlist:ArrayList<Read_Model>):RecyclerView.Adapter<ReadAdapter.myclass>()
{
    class myclass(view:View):RecyclerView.ViewHolder(view){
        var tvReadQuestion = view.findViewById<TextView>(R.id.tv_read_question)
        var tvReadAns = view.findViewById<TextView>(R.id.tv_read_ans)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myclass {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.rowlayout,parent,false)
        return myclass(v)
    }

    override fun onBindViewHolder(holder: myclass, position: Int) {
        val my = questionlist[position]
        holder.tvReadQuestion.setText(my.question)
        holder.tvReadAns.setText(my.ans)
    }

    override fun getItemCount(): Int {
        return questionlist.size
    }
}