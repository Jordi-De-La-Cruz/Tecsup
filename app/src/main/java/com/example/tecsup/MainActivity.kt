package com.example.tecsup

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.example.tecsup.login.LoginActivity

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?){

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, LoginActivity::class.java))
        },6000)

    }

}