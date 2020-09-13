package com.kotlin.training

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val plusButton = findViewById<Button>(R.id.plusButton)
        val minusButton = findViewById<Button>(R.id.minusButton)
        val textView = findViewById<TextView>(R.id.textView)

        var counter = 0

        plusButton.setOnClickListener {
            counter++
            textView.text = counter.toString()
        }

        minusButton.setOnClickListener {
            counter--
            textView.text = counter.toString()
        }

    }
}