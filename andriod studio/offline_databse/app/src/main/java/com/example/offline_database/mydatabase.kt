package com.example.offline_database

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log


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
        var create_query = " CREATE TABLE " + TABLE_NAME + " ( " +ID+" integer primary key AUTOINCREMENT , "+ NAME +" VARCHAR(20),"+ EMAIL +" VARCHAR(40), "+CONTACT+" VARCHAR(20) )"
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
        Log.d("mydata","--> insert data")
        return id
    }

    @SuppressLint("Range")
    fun getall_data():MutableList<mymodel>
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
            return ArrayList()
        }

        var user_id:Int
        var user_name:String
        var email:String
        var contact:String

        if (cursor.count>0)
        {
            if (cursor.moveToFirst())
            {
                do
                {
                    user_id = cursor.getInt(cursor.getColumnIndex(ID))
                    user_name = cursor.getString(cursor.getColumnIndex(NAME))
                    email = cursor.getString(cursor.getColumnIndex(EMAIL))
                    contact = cursor.getString(cursor.getColumnIndex(CONTACT))

                    var user_data= mymodel(user_id=user_id,user_name=user_name, user_email = email, user_contact = contact)
                    userlist.add(user_data)
                }while (cursor.moveToNext())
            }
        }
        return userlist
    }

    fun updateData(mymodel: mymodel):Int
    {
        var db=this.writableDatabase
        var contentValues=ContentValues()

        contentValues.put(NAME,mymodel.user_name)
        contentValues.put(EMAIL,mymodel.user_email)
        contentValues.put(CONTACT,mymodel.user_contact)

        var id=db.update(TABLE_NAME,contentValues,ID+" = "+mymodel.user_id,null)
        db.close()
        return id

    }

    fun deletedata(mymodel: mymodel):Int
    {
        var db=this.writableDatabase
        var delete_quary=db.delete(TABLE_NAME, ID+" = "+mymodel.user_id,null)
        db.close()
        return delete_quary
    }
}


