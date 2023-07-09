package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    lateinit var myauth: FirebaseAuth
    lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myauth= FirebaseAuth.getInstance()


        var ed_username=findViewById<EditText>(R.id.ed_username)

        var ed_contact=findViewById<EditText>(R.id.ed_contact)
        var ed_email=findViewById<EditText>(R.id.ed_email)
        var ed_password=findViewById<EditText>(R.id.ed_password)
        var btn_register=findViewById<Button>(R.id.btn_register)
        var clickhere=findViewById<TextView>(R.id.clickhere)

        clickhere.setOnClickListener {
            var i= Intent(this@MainActivity,Login_Activity::class.java)
            finish()
            startActivity(i)
        }

        btn_register.setOnClickListener {

            myauth.createUserWithEmailAndPassword(ed_email.text.toString(),ed_password.text.toString())
                .addOnCompleteListener(this)
                {
                    if (it.isSuccessful)
                    {
                        var user: FirebaseUser? = myauth.currentUser
                        var user_id:String=user!!.uid

                        databaseReference= FirebaseDatabase.getInstance().getReference("users").child(user_id)

                        var hashmap: HashMap<String,String> = HashMap()

                        hashmap.put("uid",user_id)
                        hashmap.put("username",ed_username.text.toString())
                        hashmap.put("contact",ed_contact.text.toString())
                        hashmap.put("profile_pic","")

                        databaseReference.setValue(hashmap).addOnCompleteListener(this)
                        {
                            if (it.isSuccessful)
                            {
                                Toast.makeText(this@MainActivity, "Successfully register", Toast.LENGTH_SHORT).show()
                            }
                            else
                            {
                                Toast.makeText(this@MainActivity, "Fail", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }

                    else
                    {
                        Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
                    }
                }

        }
    }
}