package com.example.e_qiuz

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Database(context: Context):SQLiteOpenHelper(context,"mydb",null,VERSON_NO)
{
    companion object
    {
        var VERSON_NO = 1
        var ID = "id"
        var NAME = "name"
        var EMAIL = "email"
        var PASS = "pass"
        var TABLE_NAME = "quiz"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        var creat_table= "CREATE TABLE $TABLE_NAME ( $ID INTEGER PRIMARY KEY autoincrement, $NAME VARCHAR(20),$EMAIL VARCHAR(20),$PASS VARCHAR(20))"
        db!!.execSQL(creat_table)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME)
        onCreate(db)
    }

//    fun checkemail(email: String): Boolean {
//        val db: SQLiteDatabase = this.readableDatabase
//        val Query =
//            "Select * from " + TABLE_NAME.toString() + " where " + EMAIL.toString() + " = " + "'" + email + "'"
//        val cursor: Cursor = db.rawQuery(Query, null)
//        return if (cursor.getCount() <= 0) {
//            cursor.close()
//            false
//        } else {
//            cursor.close()
//            true
//        }
//    }

    fun insert(modelClass: MyModel) : Long {
        val db = this.writableDatabase
        val contentValues = ContentValues()

        contentValues.put(NAME,modelClass.name)
        contentValues.put(EMAIL,modelClass.email)
        contentValues.put(PASS,modelClass.password)

        val insertdata = db.insert(TABLE_NAME,null,contentValues)
        db.close()
        return insertdata
    }


}