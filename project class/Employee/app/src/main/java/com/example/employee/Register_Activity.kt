package com.example.employee

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Register_Activity : AppCompatActivity() {

    lateinit var myauth : FirebaseAuth
    lateinit var databaseReference: DatabaseReference

    lateinit var ed_name_register:EditText
    lateinit var ed_contact_register:EditText
    lateinit var ed_email_register:EditText
    lateinit var ed_password_register:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        myauth= FirebaseAuth.getInstance()

        ed_name_register = findViewById(R.id.ed_name_register)
        ed_contact_register = findViewById(R.id.ed_contact_register)
        ed_email_register = findViewById(R.id.ed_email_register)
        ed_password_register = findViewById(R.id.ed_password_register)


        var btn_register_register = findViewById<AppCompatButton>(R.id.btn_register_register)
        var tv_login = findViewById<TextView>(R.id.tv_login)

        tv_login.setOnClickListener {
            var i = Intent(this@Register_Activity,Login_Activity::class.java)
            finish()
            startActivity(i)
        }

        btn_register_register.setOnClickListener {
           register()
            ed_name_register.text.clear()
            ed_contact_register.text.clear()
            ed_email_register.text.clear()
            ed_password_register.text.clear()
        }

        ed_email_register.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                if (android.util.Patterns.EMAIL_ADDRESS.matcher(ed_email_register.text.toString()).matches()) {
                    btn_register_register.isEnabled = true
                }
                else {
                    btn_register_register.isEnabled = false
                    ed_email_register.error= "Invalid email"
                }
            }

        })
    }

    fun inputisnotEmpty():Boolean
    {
        var b = true
        if (ed_name_register.text.toString().trim().isEmpty())
        {
            ed_name_register.error = "Required"
            b = false
        }
        if (ed_contact_register.text.toString().trim().isEmpty())
        {
            ed_contact_register.error = "Required"
            b = false
        }
        if (ed_password_register.text.toString().trim().isEmpty())
        {
            ed_password_register.error = "Required"
            b = false
        }

        return b
    }

    fun register()
    {
        if (inputisnotEmpty())
        {
            myauth.createUserWithEmailAndPassword(ed_email_register.text.toString(),ed_password_register.text.toString())
                .addOnCompleteListener(this)
                {
                    if (it.isSuccessful)
                    {
                        var user : FirebaseUser? =myauth.currentUser
                        var user_id : String = user!!.uid

                        databaseReference = FirebaseDatabase.getInstance().getReference("My Users").child(user_id)

                        var hashmap : HashMap<String,String> = HashMap()

                        hashmap.put("uid",user_id)
                        hashmap.put("name",ed_name_register.text.toString())
                        hashmap.put("contact",ed_contact_register.text.toString())
                        hashmap.put("email",ed_email_register.text.toString())
                        hashmap.put("profile_pic","")

                        databaseReference.setValue(hashmap).addOnCompleteListener(this)
                        {
                            if (it.isSuccessful)
                            {
                                Toast.makeText(this, "Registration Successfully", Toast.LENGTH_SHORT).show()
                            }
                            else
                            {
                                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                    else
                    {
                        Toast.makeText(this, "Already user please Login", Toast.LENGTH_SHORT).show()
                    }
                }

        }
    }
}