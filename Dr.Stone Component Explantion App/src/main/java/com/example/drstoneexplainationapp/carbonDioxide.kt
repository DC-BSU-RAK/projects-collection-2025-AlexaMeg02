package com.example.drstoneexplainationapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

//carbon + oxygen
class carbonDioxide : AppCompatActivity() {

    private lateinit var outputText5: TextView
    private lateinit var nextButton5: ImageButton
    private lateinit var backButton5: ImageButton

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_carbon_dioxide)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        outputText5 = findViewById(R.id.outputText5)
        backButton5 = findViewById(R.id.backButton5)
        nextButton5 = findViewById(R.id.nextButton5)

        nextButton5.visibility = View.GONE

        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val text = sharedPreferences.getString("text", "")

        outputText5.text = text

        // Set button visibility based on the value of text
        when (text) {
            "carbon" -> {
                nextButton5.visibility = View.VISIBLE // Show the button for carbon
            }
            "oxygen" -> {
                nextButton5.visibility = View.GONE // Hide the button for oxygen
            }
            else -> {
                nextButton5.visibility = View.GONE // Hide the button for any other case
            }
        }
        backButton5.setOnClickListener {
            if (text == "oxygen"){
                val intent = Intent(this, pageOne::class.java)
                startActivity(intent)
            }
            if (text == "carbon"){
                val intent = Intent(this, pageFour::class.java)
                startActivity(intent)
            }
        }
        nextButton5.setOnClickListener {
            if (text == "carbon") {
                val intent = Intent(this, steel::class.java)
                startActivity(intent)
            }

        }
    }
    private fun enableEdgeToEdge() {
        // Implement edge-to-edge display settings if required
    }
}
