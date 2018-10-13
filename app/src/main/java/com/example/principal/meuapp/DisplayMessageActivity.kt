package com.example.principal.meuapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

class DisplayMessageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)

        // Get the Intent that started this activity and extract the string
        val intent = intent
        val error = intent.getStringExtra(ERROR)

        val textView = findViewById<TextView>(R.id.textView)
        if (error.isEmpty()) {
            val result = intent.getIntExtra(RESULT, 0)
            textView.text = result.toString()

        } else {
            textView.text = error
        }
    }
}