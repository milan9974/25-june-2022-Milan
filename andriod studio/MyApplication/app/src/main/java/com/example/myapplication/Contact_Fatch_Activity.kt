package com.example.myapplication

import android.annotation.SuppressLint
import android.content.ContentResolver
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import androidx.annotation.RequiresApi

class Contact_Fatch_Activity : AppCompatActivity() {
    @SuppressLint("Range")
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_fatch)

        requestPermissions(arrayOf(android.Manifest.permission.READ_CONTACTS),1)

        var resolver: ContentResolver =contentResolver

        var cursor = resolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null)
        if (cursor!!.count >0)
        {
            while (cursor.moveToNext())
            {
                var name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))
                var number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))

                Log.d("mydata","-----> $name - $number" )
            }
        }
    }
}