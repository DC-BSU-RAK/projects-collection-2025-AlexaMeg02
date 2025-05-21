package com.example.drstoneexplainationapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

// iron + carbon
class pageTwo : AppCompatActivity() {

    private lateinit var outputText2: TextView
    private lateinit var nextButton2: ImageButton
    private lateinit var back2Button: ImageButton
    private lateinit var sharedPreferences: SharedPreferences


    // sulfur + iron
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_page_two)

        outputText2 = findViewById(R.id.outputText2)
        nextButton2 = findViewById(R.id.nextButton2)
        back2Button = findViewById(R.id.backButton5)

        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val text = sharedPreferences.getString("text", "")

        outputText2.text = text

        back2Button.setOnClickListener {
            if (text == "iron") {
                val intent = Intent(this, pageOne::class.java)
                startActivity(intent)
            } else {
                // Go back to MainActivity for other cases
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
        nextButton2.setOnClickListener {
            if (text == "iron") {
                val intent = Intent(this, steel::class.java)
                startActivity(intent)
            }
            if (text == "sulfur") {
                val intent = Intent(this, pageFour::class.java)
                startActivity(intent)
            }
        }
    }

    private fun enableEdgeToEdge() {
    }
}
