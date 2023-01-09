package com.example.e_qiuz

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class Register_Activity : AppCompatActivity() {

    private var edNameRegister:EditText?=null
    lateinit var edEmailRegister:EditText
    lateinit var ed_pass_register:EditText
    lateinit var ed_repass_register:EditText
    lateinit var checkBox: CheckBox
    lateinit var myshared:SharedPreferences
    lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        supportActionBar!!.hide()
//        requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

//        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)

        edNameRegister = findViewById(R.id.ed_name_register)
        edEmailRegister = findViewById(R.id.ed_email_register)
        ed_pass_register = findViewById(R.id.ed_password_register)
        ed_repass_register = findViewById(R.id.ed_repassword_register)
        checkBox = findViewById(R.id.checkbox)


        val mydatabase = Database(this)


        val btn_register = findViewById<Button>(R.id.btn_register)

        myshared = this.getSharedPreferences("mypref_file", Context.MODE_PRIVATE)
        editor = myshared.edit()

        if (myshared.getBoolean("status",false))
        {
            val i =Intent(this,Welcome_Activity::class.java)
            finish()
            startActivity(i)
        }


        btn_register.setOnClickListener {

            if (edEmailRegister.text.toString()!="" && ed_pass_register.text.toString()!="" && ed_repass_register.text.toString()!="" && edNameRegister!!.text.toString()!="" ) {
                if (ed_pass_register.text.toString() == ed_repass_register.text.toString()) {
                    if (checkBox.isChecked==true) {
                        val insertID = mydatabase.insert(MyModel(it.id,edNameRegister!!.text.toString(),edEmailRegister.text.toString(),ed_pass_register.text.toString()))
                        Log.d("mydata","----->"+insertID)

                        if (insertID > 1) {

                            editor.putString("name",edNameRegister!!.text.toString())
                            editor.putString("email",edEmailRegister.text.toString())
                            editor.putString("password",ed_pass_register.text.toString())
                            editor.apply()
                            editor.commit()
                            Toast.makeText(this, "Registration Successfully", Toast.LENGTH_SHORT).show()

                            val intent = Intent(this@Register_Activity,Login_Activity::class.java)
//                            intent.putExtra(Constants.USER_NAME,edNameRegister!!.text.toString())
                            finish()
                            startActivity(intent)
                        } else {
                            val d = AlertDialog.Builder(this)
                            d.setTitle("Message")
                            d.setMessage("Record not added")
                            d.setPositiveButton("Ok", null)
                            d.show()
                            edNameRegister!!.text.clear()
                            edEmailRegister.text.clear()
                            ed_pass_register.text.clear()
                            ed_repass_register.text.clear()
                        }
                    } else {
                        Toast.makeText(this, "Please apply terms and condition", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, "Password not match", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this@Register_Activity, "Enter all field", Toast.LENGTH_SHORT).show()
            }
        }

        edEmailRegister.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                if (android.util.Patterns.EMAIL_ADDRESS.matcher(edEmailRegister.text.toString()).matches())
                {
                    btn_register.isEnabled = true
                }
                else
                {
                    btn_register.isEnabled = false
                    edEmailRegister.error = "Enter valid email"
                }
            }
        })

        val tv_login_link = findViewById<TextView>(R.id.tv_login_link)

        tv_login_link.setOnClickListener {
            val i = Intent(this@Register_Activity,Login_Activity::class.java)
            finish()
            startActivity(i)
        }
    }


}