package com.example.principal.meuapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText
import java.lang.Exception

const val RESULT = "message.result"
const val ERROR = "message.error"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /**Called when the user taps the Send button */
    fun sendMessage(view: View) {
        val intent = Intent(this, DisplayMessageActivity::class.java)
        val editText = findViewById<View>(R.id.editText) as EditText

        try {
            val result = editText.text.toString().toInt()
            intent.putExtra(RESULT, result)
            intent.putExtra(ERROR, "")

        } catch (e: Exception) {
            intent.putExtra(ERROR, "Error: Insira apenas número!")
        }

        startActivity(intent)
    }


}
