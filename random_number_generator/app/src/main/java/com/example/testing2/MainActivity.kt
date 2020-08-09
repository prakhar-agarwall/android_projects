package com.example.testing2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val displaytextView2 = findViewById<TextView>(R.id.displaytextView2)
        val seekBar = findViewById<SeekBar>(R.id.seekBar)
        val rollsButton = findViewById<Button>(R.id.rollsButton)

        rollsButton.setOnClickListener {
            val rand = Random().nextInt(seekBar.progress)
            displaytextView2.text = rand.toString()
        }
    }
}
