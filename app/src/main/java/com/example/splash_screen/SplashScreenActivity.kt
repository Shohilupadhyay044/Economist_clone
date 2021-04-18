package com.example.splash_screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.economist_clone.MainActivity
import com.example.economist_clone.R

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        supportActionBar?.hide()
      Handler().postDelayed({
          val intent=Intent(this,MainActivity::class.java)
          startActivity(intent)
          finish()
      },1500)
    }

}