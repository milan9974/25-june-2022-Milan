package com.example.todoapp

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class MyDatabase(var context:Context):SQLiteOpenHelper(context,"mydb",null,VERSON_NO)
{

    companion object
    {
        var ID = "id"
        var TITLE = "title"
        var NOTES = "notes"
        var TABLE_NAME = "todo"
        var VERSON_NO = 1
    }

    override fun onCreate(db: SQLiteDatabase?) {
        var create_query = " CREATE TABLE " + TABLE_NAME + " ( " +ID+ " integer primary key AUTOINCREMENT ,"+ TITLE +" VARCHAR(20),"+ NOTES +" VARCHAR(40) )"
        db!!.execSQL(create_query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }


    fun add_data(MyModel:mymodel):Long
    {
        var mydb=this.writableDatabase
        var contentvalue=ContentValues()

        contentvalue.put(TITLE,MyModel.title)
        contentvalue.put(NOTES,MyModel.notes)

        var id=mydb.insert(TABLE_NAME,null,contentvalue)
        Log.d("mydata","--> insert data")
        return id
    }

    @SuppressLint("Range")
    fun getall_data():MutableList<mymodel>
    {
        var userlist:MutableList<mymodel> = ArrayList()
        var select_query = "SELECT * FROM $TABLE_NAME"

        var cursor : Cursor?
        var mydb = this.readableDatabase

        try {
            cursor = mydb.rawQuery(select_query,null)
        }

        catch (e:SQLiteException)
        {
            mydb.execSQL(select_query)
            return ArrayList()
        }

        var user_id:Int
        var title:String
        var notes:String

        if (cursor.count>0)
        {
            if (cursor.moveToFirst())
            {
                do
                {
                    user_id = cursor.getInt(cursor.getColumnIndex(ID))
                    title = cursor.getString(cursor.getColumnIndex(TITLE))
                    notes = cursor.getString(cursor.getColumnIndex(NOTES))

                    var user_data= mymodel(user_id =user_id,title = title, notes = notes)
                    userlist.add(user_data)
                }while (cursor.moveToNext())
            }
        }

        return userlist

    }

    fun UpdateData(MyModel: mymodel):Int
    {
        var db=this.writableDatabase
        var contentvalues=ContentValues()

        contentvalues.put(TITLE,MyModel.title)
        contentvalues.put(NOTES,MyModel.notes)

        var id=db.update(TABLE_NAME,contentvalues, ID+" = "+MyModel.user_id,null)
        db.close()
        return id
    }

    fun DeletData(MyModel: mymodel):Int
    {
        var db=this.writableDatabase
        var delete_quary=db.delete(TABLE_NAME, ID+" = "+MyModel.user_id,null)
        db.close()
        return delete_quary
    }

}

