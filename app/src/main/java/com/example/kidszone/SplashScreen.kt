package com.example.kidszone

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import java.time.Instant

class splashScreen : AppCompatActivity() {
//    Deklarasi Variabel Waktu splash Screen Masuk
    private  val SPLASH_TIME_OUT:Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        Handler().postDelayed({
            startActivity(Intent( this,MainActivity::class.java))
        finish()
        },SPLASH_TIME_OUT)
    }
}