package com.example.res

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var number = 0

    fun showToast (message: String) {
        val toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
        toast.show()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showToast("OnCreate")
        buttonRandom.setOnClickListener {
            number = (0 .. 100).shuffled().last()

            TextView.text = getString(R.string.its_number, number.toString())
            val SecondActivity = Intent (this, Main2Activity::class.java)
            SecondActivity.putExtra("number", number)
            startActivity(SecondActivity)
        }
        buttonPlus.setOnClickListener {
            TextView.text = getString(R.string.its_number, (number++).toString())
        }
        buttonMinus.setOnClickListener {
            TextView.text = getString(R.string.its_number, (number--).toString())
        }
    }

    override fun onPause() {
        super.onPause()
        showToast("OnPause")
    }

    override fun onStart() {
        super.onStart()
        showToast("OnStart")
    }

    override fun onResume() {
        super.onResume()
        showToast("OnResume")
    }
}
