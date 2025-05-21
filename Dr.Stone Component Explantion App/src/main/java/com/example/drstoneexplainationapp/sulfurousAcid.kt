package com.example.drstoneexplainationapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

//Sulfur Dioxide + water
class sulfurousAcid : AppCompatActivity() {

    private lateinit var outputText7: TextView
    private lateinit var backButton7: ImageButton

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_steel)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        outputText7 = findViewById(R.id.outputText7)
        backButton7 = findViewById(R.id.backButton7)

        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val text = sharedPreferences.getString("text", "")

        outputText7.text = text


        backButton7.setOnClickListener {
            val intent = Intent(this, pageThree::class.java)
            startActivity(intent)
        }
    }
    private fun enableEdgeToEdge() {
        // Implement edge-to-edge display settings if required
    }
}