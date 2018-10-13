package com.example.principal.meuapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText
import android.widget.TextView

const val RESULT = "message.result"
const val CHALLENGE = "message.challenge"
const val ERROR = "message.error"
const val CHALLENGE_CALCULATE = "message.challenge.calculate"

@SuppressLint("SetTextI18n")
class MainActivity : AppCompatActivity() {

    private var firstNumber = 1
    private var secondNumber = 1
    private var challengeLabel = "Aperte o botão"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.challenge)
        textView.text = challengeLabel
    }

    fun startChallenge(view: View) {
        firstNumber = (1..20).shuffled().first()
        secondNumber = (1..20).shuffled().first()

        val textView = findViewById<TextView>(R.id.challenge)
        challengeLabel = "$firstNumber x $secondNumber"
        textView.text = "$challengeLabel = ?"
    }

    fun sendMessage(view: View) {
        val challengeMessage = findViewById<View>(R.id.challenge) as TextView
        if (challengeMessage.text != "Aperte o botão") {

            val intent = Intent(this, DisplayMessageActivity::class.java)
            val editText = findViewById<View>(R.id.editText) as EditText
            try {
                val result = editText.text.toString().toInt()
                intent.putExtra(RESULT, result)
                intent.putExtra(ERROR, "")
                intent.putExtra(CHALLENGE, firstNumber * secondNumber)
                intent.putExtra(CHALLENGE_CALCULATE, challengeLabel)

            } catch (e: Exception) {
                intent.putExtra(ERROR, "Error: Insira apenas número!")
            }

            startActivity(intent)
        }
    }
}
