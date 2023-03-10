package com.example.textswitcher

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextSwitcher
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val languages = arrayOf("India","Russia","Canada","UAE","Switzerland","U.S.A")
    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textSwitcher = findViewById<TextSwitcher>(R.id.textSwitcher)
        textSwitcher.setFactory {
            val textView = TextView(this@MainActivity)
            textView.gravity = Gravity.TOP or Gravity.CENTER_HORIZONTAL
            textView.textSize = 32f
            textView.setTextColor(Color.BLACK)
            textView
        }

        textSwitcher.setText(languages[index])

        val textIn = AnimationUtils.loadAnimation(
            this,android.R.anim.slide_in_left)
        textSwitcher.inAnimation = textIn

        val textOut = AnimationUtils.loadAnimation(
            this,android.R.anim.slide_out_right)
        textSwitcher.inAnimation = textOut

        val previousButton = findViewById<Button>(R.id.previousButton)
        previousButton.setOnClickListener {
            index = if (index -1 >= 0) index -1 else 5
            textSwitcher .setText(languages[index])
        }

        val nextButton = findViewById<Button>(R.id.nextButton)
        nextButton.setOnClickListener {
            index = if (index +1 < languages.size) index +1 else 0
            textSwitcher.setText(languages[index])
        }
    }
}