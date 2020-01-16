package com.example.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class mainActivityViewmodel : ViewModel() {
    var myText:String = "hoho"
}


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val model = ViewModelProviders.of(this).get(mainActivityViewmodel::class.java)
        mainText.text = model.myText

        mainButton.setOnClickListener {
            model.myText = "Die"
            mainText.text = model.myText
        }
    }
}
