package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.*

class texttospeech : AppCompatActivity(),TextToSpeech.OnInitListener {

    var tts: TextToSpeech ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_texttospeech)

        var ed_tts= findViewById<EditText>(R.id.ed_tts)
        var btn_tts = findViewById<Button>(R.id.btn_tts)

        tts=TextToSpeech(this@texttospeech,this)

        btn_tts.setOnClickListener {
            var text_ed = ed_tts.text.toString()
            tts!!.speak(text_ed,TextToSpeech.QUEUE_ADD,null,"")
            tts!!.setSpeechRate(0.8f)
        }
    }

    override fun onInit(status: Int) {
        if (status==TextToSpeech.SUCCESS)
        {
            var result = tts!!.setLanguage(Locale.ENGLISH)
            if (result==TextToSpeech.LANG_NOT_SUPPORTED || result==TextToSpeech.LANG_MISSING_DATA)
            {
                Toast.makeText(this, "LANGUAGE not supported", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        if (tts!=null)
        {
            tts!!.stop()
            tts!!.shutdown()
        }
    }
}