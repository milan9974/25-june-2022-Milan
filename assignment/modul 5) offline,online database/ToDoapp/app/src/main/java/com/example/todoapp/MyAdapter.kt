package com.example.todoapp

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(var context: Context, var userlist:MutableList<mymodel>): RecyclerView.Adapter<MyAdapter.MyClass>()
{
    class MyClass(view: View):RecyclerView.ViewHolder(view)
    {
        var tv_title = view.findViewById<TextView>(R.id.tv_title)
        var tv_notes = view.findViewById<TextView>(R.id.tv_notes)
        var clickoncard = view.findViewById<CardView>(R.id.clickoncard)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyClass {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.myrow_layout,parent,false)
        return MyClass(view)
    }

    override fun onBindViewHolder(holder: MyClass, position: Int) {


        var mydata=userlist[position]
        holder.tv_title.text=mydata.title
        holder.tv_notes.text=mydata.notes

        holder.clickoncard.setOnClickListener {
            var i = Intent(context,UpdateDelet_Activity::class.java)
            context.startActivity(i)
            (context as Activity).finish()
        }

        holder.clickoncard.setOnClickListener {
            var dialog = Dialog(context)
            dialog.setContentView(R.layout.activity_update_delet)
            dialog.show()

            var ed_update_tile=dialog.findViewById<EditText>(R.id.ed_update_title)
            var ed_update_note=dialog.findViewById<EditText>(R.id.ed_update_note)
            var btn_update=dialog.findViewById<AppCompatButton>(R.id.btn_update)
            var btn_delete=dialog.findViewById<AppCompatButton>(R.id.btn_delete)

            ed_update_tile.setText(mydata.title)
            ed_update_note.setText(mydata.notes)

            btn_update.setOnClickListener {
                var mydb=MyDatabase(context)

                var MyModel=mymodel(mydata.user_id,ed_update_tile.text.toString(),ed_update_note.text.toString())
                mydb.UpdateData(MyModel)

                var i = Intent(context,MainActivity::class.java)
                context.startActivity(i)
                (context as Activity).finish()

            }

            btn_delete.setOnClickListener {
                var mydb=MyDatabase(context)
                var MyModel=mymodel(mydata.user_id, mydata.title, mydata.notes)
                mydb.DeletData(MyModel)

                var i = Intent(context,MainActivity::class.java)
                context.startActivity(i)
                (context as Activity).finish()
            }
        }
    }

    override fun getItemCount(): Int {
        return userlist.size
    }
}