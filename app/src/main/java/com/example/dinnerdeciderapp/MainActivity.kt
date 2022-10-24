package com.example.dinnerdeciderapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var inputText: EditText
    private lateinit var decision: TextView

    private var dinners = ArrayList<String>(arrayListOf("Hamburger", "Pizza", "Mexican" , "American", "Chinese"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inputText = findViewById<EditText>(R.id.input_add)
        decision = findViewById<TextView>(R.id.decision_text)
    }

    fun addDinner(view: View) {
        val text = inputText.text.toString()
        var alertText = "Added $text"
        if (text.isNotEmpty()) {
            dinners.add(text)
            inputText.text.clear()
        } else {
            alertText = "Please insert your Food name"
        }

        val toast = Toast.makeText(applicationContext, alertText, Toast.LENGTH_LONG)
        toast.show()
    }

    fun decideDinner(view: View) {
        val randomIndex = Random.nextInt(dinners.size);
        decision?.text = dinners[randomIndex]
    }
}