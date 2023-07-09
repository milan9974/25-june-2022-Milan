package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView

class MyUserAdapter( var context:Context, var userList:ArrayList<UserModel>):RecyclerView.Adapter<MyUserAdapter.MyClass>()
{
    class  MyClass (itemview: View):RecyclerView.ViewHolder(itemview)
    {
        var tv_username = itemview.findViewById<TextView>(R.id.tv_username)
        var tv_contact = itemview.findViewById<TextView>(R.id.tv_contact)
        var imgview = itemview.findViewById<CircleImageView>(R.id.profile_image)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyClass
    {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.myrow_layout,parent,false)
        return MyClass(view)
    }

    override fun onBindViewHolder(holder: MyClass, position: Int) {
        var user = userList[position]

        holder.tv_username.text=  user.username
        holder.tv_contact.text= user.contact

        Glide
            .with(context)
            .load(user.profile_pic)
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.imgview)

    }

    override fun getItemCount(): Int {
        return userList.size
    }
}