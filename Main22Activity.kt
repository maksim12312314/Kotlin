package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main22.*

class Main22Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main22)

        val ourname = intent.getStringExtra("name")
        val health = intent.getStringExtra("health")
        val exp = intent.getStringExtra("exp")
        val strength = intent.getStringExtra("strength")

        name.text = ourname
    }
}
