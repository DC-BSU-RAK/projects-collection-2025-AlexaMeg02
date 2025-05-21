package com.example.drstoneexplainationapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

// oxygen + sulfur
class pageThree : AppCompatActivity() {

    private lateinit var outputText3: TextView
    private lateinit var nextButton3: ImageButton
    private lateinit var backButton3: ImageButton
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_page_three)

        outputText3 = findViewById(R.id.outputText3)
        nextButton3 = findViewById(R.id.nextButton3)
        backButton3 = findViewById(R.id.backButton3)

        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val text = sharedPreferences.getString("text", "")

        outputText3.text = text

        when (text) {
            "sulfur" -> {
                nextButton3.visibility = View.GONE // Hide the button for oxygen
            }
            else -> {
                nextButton3.visibility = View.VISIBLE // Hide the button for any other case
            }
        }

        backButton3.setOnClickListener {
            if (text == "oxygen") {
                val intent = Intent(this, pageOne::class.java)
                startActivity(intent)
            }
            if (text == "sulfur") {
                val intent = Intent(this, pageFour::class.java)
                startActivity(intent)
            }

            else{
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }

        }
        nextButton3.setOnClickListener {
            if (text == "oxygen") {
                val intent = Intent(this, pageOne::class.java)
                startActivity(intent)
            }

        }
    }
    private fun enableEdgeToEdge() {
        // Implement edge-to-edge display settings if required
    }
}