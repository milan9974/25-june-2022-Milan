package com.example.m4q3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import java.math.BigDecimal
import java.math.RoundingMode

class MainActivity : AppCompatActivity() {

    lateinit var ed1:EditText
    lateinit var ed2:EditText
    lateinit var tvans:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ed1=findViewById(R.id.ed1)
        ed2=findViewById(R.id.ed2)
        var rbadd=findViewById<RadioButton>(R.id.rbadd)
        var rbsub=findViewById<RadioButton>(R.id.rbsub)
        var rbmul=findViewById<RadioButton>(R.id.rbmul)
        var rbdiv=findViewById<RadioButton>(R.id.rbdiv)
        var btnreset=findViewById<Button>(R.id.btnreset)
        tvans=findViewById(R.id.tvans)


        btnreset.setOnClickListener {
            ed1.text.clear()
            ed2.text.clear()
        }

        rbadd.setOnClickListener {
           add()
        }

        rbsub.setOnClickListener {
            sub()
        }

        rbmul.setOnClickListener {
            mul()
        }

        rbdiv.setOnClickListener {
            div()
        }
    }

    fun  inputIsNotEmpty():Boolean {
        var b = true;
        if (ed1.text.toString().trim().isEmpty()) {
            ed1.error = "Required"
            b = false;
        }
        if (ed2.text.toString().trim().isEmpty()) {
            ed2.error = "Required"
            b = false;
        }
        return b;
    }

    fun add()
    {
        if(inputIsNotEmpty()){
            var inputdata1=ed1.text.toString().trim().toBigDecimal()
            var inputdata2=ed2.text.toString().trim().toBigDecimal()
            tvans.text=inputdata1.add(inputdata2).toString()
        }
    }

    fun sub()
    {
        if(inputIsNotEmpty()){
            var inputdata1=ed1.text.toString().trim().toBigDecimal()
            var inputdata2=ed2.text.toString().trim().toBigDecimal()
            tvans.text=inputdata1.subtract(inputdata2).toString()
        }
    }

    fun mul()
    {
        if(inputIsNotEmpty()){
            var inputdata1=ed1.text.toString().trim().toBigDecimal()
            var inputdata2=ed2.text.toString().trim().toBigDecimal()
            tvans.text=inputdata1.multiply(inputdata2).toString()
        }
    }

    fun div()
    {
        if(inputIsNotEmpty()){
            var inputdata1=ed1.text.toString().trim().toDouble()
            var inputdata2=ed2.text.toString().trim().toDouble()


            if (inputdata1==0.00)
            {
                ed1.error="not valid"
            }
            if(inputdata2==0.00)
            {
                ed2.error="not valid"
            }
//            if(inputdata2.compareTo(BigDecimal.ZERO)==0){
//                ed2.error="invalid input"
//            }
            var ans=inputdata1/inputdata2
            tvans.text=ans.toString()

            Log.d("ans","--"+ans.toString())
//            tvans.text=inputdata1.divide(inputdata2).toString()

        }

    }

}
