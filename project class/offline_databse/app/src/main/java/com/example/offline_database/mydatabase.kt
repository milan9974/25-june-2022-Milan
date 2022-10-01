package com.example.offline_database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper


class mydatabase(var context: Context):SQLiteOpenHelper(context,"mydb",null, VERSON_NO)
{
    companion object
    {
        var ID = "id"
        var NAME = "name"
        var EMAIL = "email"
        var CONTACT = "contact"
        var VERSON_NO = 1
        var TABLE_NAME = "student"

    }

    override fun onCreate(db: SQLiteDatabase?)
    {
        var create_query = "CREATE TABLE "+ TABLE_NAME + " ( " +
                 ""+ID+" integer primary key AUTO_INCREMENT , "+ NAME +"VARCHAR(20),"+ EMAIL +"VARCHAR(40), "+CONTACT+" VARCHAR(20))"
        db!!.execSQL(create_query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int)
    {
        TODO("Not yet implemented")
    }

    fun insertData(MyModel: mymodel):Long
    {
        var mydb=this.writableDatabase
        var contentValues=ContentValues()

        contentValues.put(NAME,MyModel.user_name)
        contentValues.put(EMAIL,MyModel.user_email)
        contentValues.put(CONTACT,MyModel.user_contact)

        var id=mydb.insert(TABLE_NAME,null,contentValues)
        return id
    }

    fun getall_data()
    {
        var userlist: MutableList<mymodel> = ArrayList()
        var sel_que = "SELECT * FROM $TABLE_NAME"

        var cursor : Cursor?
        var mydb=this.readableDatabase

        try{
            cursor=mydb.rawQuery(sel_que,null)

        }

        catch (e:SQLiteException)
        {
            mydb.execSQL(sel_que)
//            return ArrayList()
        }
    }
}

