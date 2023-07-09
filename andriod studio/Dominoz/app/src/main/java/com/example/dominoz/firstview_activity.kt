package com.example.dominoz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class firstview_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firstview)

        var recyclerview=findViewById<RecyclerView>(R.id.recycleview)
        recyclerview.layoutManager=GridLayoutManager(this@firstview_activity,2)

        var mylist1=ArrayList<model_row1>()
        mylist1.add(model_row1(R.drawable.thali,"Thali"))
        mylist1.add(model_row1(R.drawable.pizza,"Pizza"))
        mylist1.add(model_row1(R.drawable.paratha,"Paratha"))
        mylist1.add(model_row1(R.drawable.khichdi,"Khichdi"))
        mylist1.add(model_row1(R.drawable.samosa,"Samosa"))
        mylist1.add(model_row1(R.drawable.vadapav,"Vada pav"))
        mylist1.add(model_row1(R.drawable.burgur,"Burger"))
        mylist1.add(model_row1(R.drawable.biryani,"Biryani"))
        mylist1.add(model_row1(R.drawable.chaat,"Chaat"))
        mylist1.add(model_row1(R.drawable.colddrink,"Cold drink"))
        mylist1.add(model_row1(R.drawable.icecream,"Ice cream"))
        mylist1.add(model_row1(R.drawable.khichdi,"Khichdi"))
        mylist1.add(model_row1(R.drawable.barfi,"Barfi"))
        mylist1.add(model_row1(R.drawable.cake,"Cake"))
        mylist1.add(model_row1(R.drawable.gulabjamun,"Gulab jamun"))
        mylist1.add(model_row1(R.drawable.chocolate,"Chocolate"))
        mylist1.add(model_row1(R.drawable.thali,"Thali"))
        mylist1.add(model_row1(R.drawable.pizza,"Pizza"))
        mylist1.add(model_row1(R.drawable.paratha,"Paratha"))
        mylist1.add(model_row1(R.drawable.khichdi,"Khichdi"))
        mylist1.add(model_row1(R.drawable.samosa,"Samosa"))
        mylist1.add(model_row1(R.drawable.vadapav,"Vada pav"))
        mylist1.add(model_row1(R.drawable.burgur,"Burger"))
        mylist1.add(model_row1(R.drawable.biryani,"Biryani"))
        mylist1.add(model_row1(R.drawable.chaat,"Chaat"))
        mylist1.add(model_row1(R.drawable.colddrink,"Cold drink"))
        mylist1.add(model_row1(R.drawable.icecream,"Ice cream"))
        mylist1.add(model_row1(R.drawable.khichdi,"Khichdi"))
        mylist1.add(model_row1(R.drawable.barfi,"Barfi"))
        mylist1.add(model_row1(R.drawable.cake,"Cake"))
        mylist1.add(model_row1(R.drawable.gulabjamun,"Gulab jamun"))
        mylist1.add(model_row1(R.drawable.chocolate,"Chocolate"))

        var adapter1=adapter_row1(this@firstview_activity,mylist1)
        recyclerview.adapter=adapter1


        var recyclerview2=findViewById<RecyclerView>(R.id.recycleview2)
        recyclerview2.layoutManager=LinearLayoutManager(this@firstview_activity,LinearLayoutManager.HORIZONTAL,false)


        var mylist2=ArrayList<model_row2>()
        mylist2.add(model_row2(R.drawable.khichdi,"Get 60% off","On first 5 order"))
        mylist2.add(model_row2(R.drawable.pizza,"Get 50% off on Pizza", "min order 7$ or above"))
        mylist2.add(model_row2(R.drawable.burgur,"Buy one get one Free","valid once per user"))


        var adapter2=adapter_row2(this@firstview_activity,mylist2)
        recyclerview2.adapter=adapter2
    }
}