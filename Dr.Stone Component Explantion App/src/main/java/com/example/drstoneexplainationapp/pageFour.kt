package com.example.drstoneexplainationapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

// carbon + sulfur
class pageFour : AppCompatActivity() {

    private lateinit var outputText4: TextView
    private lateinit var nextButton4: ImageButton
    private lateinit var backButton4: ImageButton

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_page_four)

        outputText4 = findViewById(R.id.outputText4)
        backButton4 =findViewById(R.id.backButton4)
        nextButton4 = findViewById(R.id.nextButton4)

        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val text = sharedPreferences.getString("text", "")

        outputText4.text = text

        backButton4.setOnClickListener {
            if (text == "sulfur") {
                val intent = Intent (this,pageTwo::class.java)
                startActivity(intent)
            }
            else {
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            }
        }
        nextButton4.setOnClickListener {
            if (text == "sulfur"){
                val intent = Intent(this,pageThree::class.java)
                startActivity(intent)
            }
            if (text == "carbon") {
                val intent = Intent(this,carbonDioxide::class.java)
                startActivity(intent)
            }
        }
    }
    private fun enableEdgeToEdge() {

    }
}