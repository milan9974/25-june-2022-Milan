package com.example.myapplicationforprectis

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper

class MyDatabase(var context: Context):SQLiteOpenHelper(context,"mydb",null,VERSON_NO) {

    companion object{
        var ID = "id"
        val EMAIL = "email"
        val PASSWORD = "password"
        val VERSON_NO = 1
        val TABLE_NAME = "table_name"
    }


    override fun onCreate(db: SQLiteDatabase?) {
        val creat_query = "CREATE TABLE $TABLE_NAME ( $ID INTEGER PRIMARY KEY AUTOINCREMENT, $EMAIL VARCHAR(50), $PASSWORD VARCHAR(50))"
        db!!.execSQL(creat_query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun addData(MYModel:mymodel):Long {
        val db = this.writableDatabase
        val cv = ContentValues()

        cv.put("email",MYModel.email)
        cv.put("password",MYModel.password)

        val id =db.insert(TABLE_NAME,null,cv)
        return id
    }

    @SuppressLint("Range")
    fun get_all_data():MutableList<mymodel>{
        val query = "select * from table_name"
        val myList1 : MutableList<mymodel> =ArrayList()

        val cursor : Cursor?
        val mydb = this.readableDatabase

        try {
            cursor = mydb.rawQuery(query,null)
        }catch (e:SQLiteException){
            mydb.execSQL(query)
            return  ArrayList()
        }

        var sid : Int
        var semail : String
        var spass : String

        if (cursor.count>0){
            if (cursor.moveToFirst()){
                do {
                    sid = cursor.getInt(cursor.getColumnIndex(ID))
                    semail = cursor.getString(cursor.getColumnIndex(EMAIL))
                    spass = cursor.getString(cursor.getColumnIndex(PASSWORD))

                    val sdata = mymodel(id = sid, email = semail, password = spass)
                    myList1.add(sdata)

                }while (cursor.moveToNext())
            }
        }
        return myList1
    }

    fun update(MYModel: mymodel):Int{
        val mydb =writableDatabase
        val cv = ContentValues()
        cv.put(EMAIL,MYModel.email)
        cv.put(PASSWORD,MYModel.password)

        val id = mydb.update(TABLE_NAME,cv,ID+"="+MYModel.id,null)
        mydb.close()
        return id
    }

    fun delete(MYModel: mymodel):Int{
        val mydb =writableDatabase
        val id  = mydb.delete(TABLE_NAME,ID+"="+MYModel.id,null)
        mydb.close()
        return id
    }

}