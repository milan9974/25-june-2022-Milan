package com.example.myapplication

import android.Manifest
import android.media.MediaPlayer
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.ImageButton
import android.widget.MediaController
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.VideoView
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat

class Music_palyer_Activity : AppCompatActivity() {

    lateinit var run :Runnable
    var handler = Handler()
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music_palyer)

        var btnplay=findViewById<ImageButton>(R.id.btn_paly)
        var seekbar = findViewById<SeekBar>(R.id.seekbar)


        var mediacPlayer : MediaPlayer=MediaPlayer.create(this,R.raw.musicforendofquiz)

        seekbar.progress = 0
        seekbar.max = mediacPlayer.duration
        btnplay.setOnClickListener {

            if (!mediacPlayer.isPlaying)
            {
                mediacPlayer.start()
                btnplay.setImageResource(R.drawable.ic_baseline_pause_24)
            }
            else
            {
                mediacPlayer.pause()
                btnplay.setImageResource(R.drawable.ic_baseline_pause_24)
            }
        }

        seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser)
                {
                    mediacPlayer.seekTo(progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                Log.d("mydata","")
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                Log.d("mydata","")
            }

        })
        run = Runnable {
            seekbar.progress = mediacPlayer.currentPosition
            handler.postDelayed(run,1000)

        }
        mediacPlayer.setOnCompletionListener {
            btnplay.setImageResource(R.drawable.ic_baseline_play_arrow_24)
            seekbar.progress = 0
        }

        var videoView = findViewById<VideoView>(R.id.videoview)
        var mediaController = MediaController(this)

//        ActivityCompat.requestPermissions(this,arrayOf(android.Manifest.permission.INTERNET)1)

        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.INTERNET,Manifest.permission.ACCESS_NETWORK_STATE),1)

        var onlineURL = Uri.parse("https://media.geeksforgeeks.org/wp-content/uploads/20201217192146/Screenrecorder-2020-12-17-19-17-36-828.mp4?_=1")
        var off = Uri.parse("android.resource://$packageName/${R.raw.aa}")
        videoView.setVideoURI(onlineURL)
        videoView.setMediaController(mediaController)
        mediaController.setAnchorView(videoView)
        videoView.requestFocus()
        videoView.start()
    }
}