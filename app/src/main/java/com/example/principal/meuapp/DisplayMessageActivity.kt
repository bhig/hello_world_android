package com.example.principal.meuapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

class DisplayMessageActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)

        // Get the Intent that started this activity and extract the string
        val intent = intent
        val error = intent.getStringExtra(ERROR)

        val textView = findViewById<TextView>(R.id.textView)
        if (error.isEmpty()) {
            val result = intent.getIntExtra(RESULT, 0)
            val challenge = intent.getIntExtra(CHALLENGE, 0)
            val challengeCalculate = intent.getStringExtra(CHALLENGE_CALCULATE)

            var finalResult = "$challengeCalculate = $challenge\n"
            finalResult += "\nMeu palpite = $result"

            if (result == challenge) {
                for (x in 1..10) {
                    finalResult += "\nVocê acertou!"
                }
            } else {
                finalResult += "\nVocê errou!"
            }

            textView.text = finalResult

        } else {
            textView.text = error
        }
    }
}