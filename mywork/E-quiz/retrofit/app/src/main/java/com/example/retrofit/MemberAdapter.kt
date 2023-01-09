package com.example.retrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MemberAdapter  (var context: Context, var memberINFO:List<MemberDataItem>): RecyclerView.Adapter<MemberAdapter.MyClass>()
{
    class MyClass (itemView: View): RecyclerView.ViewHolder(itemView)
    {
        var tv_firstname=itemView.findViewById<TextView>(R.id.tv_firstname)
        var tv_lastname=itemView.findViewById<TextView>(R.id.tv_lastname)
        var tv_email=itemView.findViewById<TextView>(R.id.tv_email)
        var tv_mobilenumber=itemView.findViewById<TextView>(R.id.tv_mobilenumber)
        var tv_familymember=itemView.findViewById<TextView>(R.id.tv_familymember)
        var tv_occupation=itemView.findViewById<TextView>(R.id.tv_occupation)
        var tv_housenumber=itemView.findViewById<TextView>(R.id.tv_housenumber)
        var tv_password=itemView.findViewById<TextView>(R.id.tv_password)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyClass
    {
        var view= LayoutInflater.from(parent.context).inflate(R.layout.memberinfo_all_row,parent,false)
        return MyClass(view)
    }

    override fun onBindViewHolder(holder: MyClass, position: Int)
    {
        var memberinfo=memberINFO[position]

        holder.tv_firstname.text=memberinfo.firstname
        holder.tv_lastname.text=memberinfo.lastname
        holder.tv_email.text=memberinfo.email
        holder.tv_mobilenumber.text=memberinfo.mobilenumber
        holder.tv_familymember.text=memberinfo.familymember
        holder.tv_occupation.text=memberinfo.occupation
        holder.tv_housenumber.text=memberinfo.housenumber
        holder.tv_password.text=memberinfo.password
    }

    override fun getItemCount(): Int
    {
        return memberINFO.size
    }

}