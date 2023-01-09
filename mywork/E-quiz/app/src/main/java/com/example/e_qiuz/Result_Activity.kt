package com.example.e_qiuz

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class Result_Activity : AppCompatActivity() {

    lateinit var myshared: SharedPreferences
    lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        supportActionBar!!.hide()

        myshared = this.getSharedPreferences("mypref_file", MODE_PRIVATE)
        editor = myshared.edit()

        val name = myshared.getString("name","")

        val tvName =findViewById<TextView>(R.id.tv_name)
        val tvScore =findViewById<TextView>(R.id.tv_score)
        val btnFinish=findViewById<Button>(R.id.btn_finish)

        tvName.text = "$name"
//        Log.d("mydata",""+intent.getStringExtra(Constants.USER_NAME))
        Log.d("mydata",""+name)

        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS,0)

        tvScore.text = "Your Score is $correctAnswers out of $totalQuestions"

        btnFinish.setOnClickListener {
            startActivity(Intent(this,Welcome_Activity::class.java))
        }

        val mediaPlayer : MediaPlayer = MediaPlayer.create(this,R.raw.musicforendofquiz)
        mediaPlayer.start()
        if (mediaPlayer.isPlaying)
        {
            btnFinish.setOnClickListener {
                mediaPlayer.pause()
                startActivity(Intent(this,Welcome_Activity::class.java))
            }
        }
    }
}