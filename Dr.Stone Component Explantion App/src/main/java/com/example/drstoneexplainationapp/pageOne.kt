package com.example.drstoneexplainationapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


// iron + oxygen
class pageOne : AppCompatActivity() {

    private lateinit var outputText: TextView
    private lateinit var nextButton: ImageButton
    private lateinit var backButton: ImageButton
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_page_one) // Set the correct layout file
        outputText = findViewById(R.id.outputText)
        backButton = findViewById(R.id.backButton)
        nextButton = findViewById(R.id.nextButton)

        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val text = sharedPreferences.getString("text", "")

        // Display the retrieved text in the TextView
        // Display the retrieved text in the TextView
        outputText.text = text
        backButton.setOnClickListener {
                if (text == "oxygen"){
                    val intent = Intent(this, pageThree::class.java)
                    startActivity(intent)
                }else{
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)

                }

        }
        nextButton.setOnClickListener {
            if (text == "iron") {
                val intent = Intent(this, pageTwo::class.java)
                startActivity(intent)
            }
            if (text == "oxygen") {
                val intent = Intent(this, carbonDioxide::class.java)
                startActivity(intent)
            }

        }
    }

        private fun enableEdgeToEdge() {
        // Implement edge-to-edge display settings if required
    }
}
        //nextButton.setOnClickListener {
            //val intent = Intent(this, pageTwo::class.java)
            //startActivity(intent)
        //}

