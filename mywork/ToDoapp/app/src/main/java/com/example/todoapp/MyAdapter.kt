package com.example.todoapp

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(var context: Context, var userlist:MutableList<mymodel>): RecyclerView.Adapter<MyAdapter.MyClass>()
{
    class MyClass(view: View):RecyclerView.ViewHolder(view)
    {
        var tvTitle = view.findViewById<TextView>(R.id.tv_title)
        var tvNotes = view.findViewById<TextView>(R.id.tv_notes)
        var clickoncard = view.findViewById<CardView>(R.id.clickoncard)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyClass {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.myrow_layout,parent,false)
        return MyClass(view)
    }

    override fun onBindViewHolder(holder: MyClass, position: Int) {


        val mydata=userlist[position]
        holder.tvTitle.text=mydata.title
        holder.tvNotes.text=mydata.notes

        holder.clickoncard.setOnClickListener {
            val i = Intent(context,UpdateDelet_Activity::class.java)
            context.startActivity(i)
            (context as Activity).finish()
        }

        holder.clickoncard.setOnClickListener {
            val dialog = Dialog(context)
            dialog.setContentView(R.layout.activity_update_delet)
            dialog.setCancelable(false)
            dialog.show()

            val ed_update_tile=dialog.findViewById<EditText>(R.id.ed_update_title)
            val ed_update_note=dialog.findViewById<EditText>(R.id.ed_update_note)
            val btn_update=dialog.findViewById<AppCompatButton>(R.id.btn_update)
            val btn_delete=dialog.findViewById<AppCompatButton>(R.id.btn_delete)
            val cancel=dialog.findViewById<ImageView>(R.id.cancel)

            cancel.setOnClickListener {
                val i = Intent(context,context::class.java)
                context.startActivity(i)
                (context as Activity).finish()

            }

            ed_update_tile.setText(mydata.title)
            ed_update_note.setText(mydata.notes)

            btn_update.setOnClickListener {
                val mydb=MyDatabase(context)

                val MyModel=mymodel(mydata.user_id,ed_update_tile.text.toString(),ed_update_note.text.toString())
                mydb.UpdateData(MyModel)

                val i = Intent(context,MainActivity::class.java)
                context.startActivity(i)
                (context as Activity).finish()

            }




            btn_delete.setOnClickListener {
                val mydb=MyDatabase(context)
                val MyModel=mymodel(mydata.user_id, mydata.title, mydata.notes)
                mydb.DeletData(MyModel)

                val i = Intent(context,MainActivity::class.java)
                context.startActivity(i)
                (context as Activity).finish()
            }
        }
    }

    override fun getItemCount(): Int {
        return userlist.size
    }
}