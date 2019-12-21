package com.example.myapplication


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    var namesList = listOf("Maxx", "dan", "ser", "vl", "lse")

    var currentHero = Player()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        currentHero = savedInstanceState?.let {
            it.getSerializable("our_data") as Player
        }?:Player(namesList.shuffled().last())

        helloWorld.text = currentHero.name

        Hellobutton.setOnClickListener{
            val intent = Intent(this, Main22Activity::class.java ).apply {
                putExtra("name", currentHero.name)
                putExtra("health", currentHero.health)
                putExtra("lvl", currentHero.exp)
                putExtra("strength", currentHero.strength)
            }
            startActivity(intent)
        }

    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable("our_data", currentHero )

    }

}

data class Player (var name:String = "Default", var health:Int = (500..8000).shuffled().last(),  var exp:Int = (0..60).shuffled().last(),  var strength:Int = (1..60).shuffled().last()):Serializable {


}
