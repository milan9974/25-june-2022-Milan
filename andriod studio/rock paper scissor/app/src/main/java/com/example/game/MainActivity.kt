package com.example.game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var rock=findViewById<Button>(R.id.rock)
        var paper=findViewById<Button>(R.id.paper)
        var scissor=findViewById<Button>(R.id.scissor)
        var you=findViewById<TextView>(R.id.you_selected)
        var com=findViewById<TextView>(R.id.com_selected)
        var ans=findViewById<TextView>(R.id.answer)

        rock.setOnClickListener {
            val com_move=(1..3).random()
            you.setText("You Selected Rock")

            if (com_move==1)
            {
                ans.text="Draw"
                com.setText("Computer seleted rock")
            }

            else if (com_move==2)
            {
                ans.text = "Computer WON"
                com.setText("Computer seleted paper")
            }
            else
            {
                ans.text="You WON"
                com.setText("Computer seleted scissor")
            }
        }

        paper.setOnClickListener {
            val com_move=(1..3).random()
            you.setText("You Selected paper")

            if (com_move==1)
            {
                ans.text="Computer WON"
                com.setText("Computer seleted scissor")
            }

            else if (com_move==2)
            {
                ans.text="Draw"
                com.setText("Computer seleted paper")
            }
            else
            {
                ans.text="You WON"
                com.setText("Computer seleted Rock")
            }
        }

        scissor.setOnClickListener {
            val com_move=(1..3).random()
            you.setText("You Selected scissor")

            if (com_move==1)
            {
                ans.text="Draw"
                com.setText("Computer seleted scissor")
            }

            else if (com_move==2)
            {
                ans.text="Computer WON"
                com.setText("Computer seleted Rock")
            }
            else
            {
                ans.text="You WON"
                com.setText("Computer seleted paper")

            }
        }
    }


}