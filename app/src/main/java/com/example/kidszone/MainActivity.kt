package com.example.kidszone

import android.content.Intent
import android.media.AudioManager
import android.media.MediaActionSound
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.ImageButton
import android.widget.ImageView
import java.io.IOException


class MainActivity : AppCompatActivity() {
    private lateinit var playSound: ImageButton
    private lateinit var stopSound: ImageButton
    private  var  mediaPlayer : MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main)
     playSound = findViewById(R.id.playSound)
        stopSound = findViewById(R.id.stopSound)

        playSound.setOnClickListener{
            playAudio()
        }
        stopSound.setOnClickListener {
            stopAudio()
        }
// Tombol Start
       val play = findViewById(R.id.play) as ImageView
        play.setOnClickListener{
            val intent = Intent(this, MenuUtama::class.java)
            // start your next activity
            startActivity(intent)
            stopAudio()
        }
    }


//Tombol Stop Audio
    private fun stopAudio() {
       if (mediaPlayer!!.isPlaying){
           mediaPlayer!!.stop()
           mediaPlayer!!.reset()
           mediaPlayer!!.release()
       }
    }
//Tombol Start Audio
    private fun playAudio() {
        val audioURL = "https://cdn.bensound.com/bensound-ukulele.mp3"
        mediaPlayer = MediaPlayer()
        mediaPlayer!!.setAudioStreamType(AudioManager.STREAM_MUSIC)
    try {
        mediaPlayer!!.setDataSource(audioURL)
        mediaPlayer!!.prepare()
        mediaPlayer!!.start()
    } catch (e: IOException){
            e.printStackTrace()
    }
    }
}