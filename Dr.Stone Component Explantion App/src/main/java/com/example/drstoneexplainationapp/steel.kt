package com.example.drstoneexplainationapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class steel : AppCompatActivity() {

    private lateinit var backButton6: ImageButton
    private lateinit var outputText6:TextView

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

        outputText6 = findViewById(R.id.outputText6)
        backButton6 = findViewById(R.id.backButton6)


        sharedPreferences = getSharedPreferences("MyPrefs",Context.MODE_PRIVATE)
        val text = sharedPreferences.getString("text", "")

        outputText6.text = text

        backButton6.setOnClickListener {
            if (text == "carbon"){
                val intent = Intent(this, carbonDioxide::class.java)
                startActivity(intent)
            }else {
                val intent = Intent(this, pageTwo::class.java)
                startActivity(intent)
            }
        }
    }
    private fun enableEdgeToEdge() {
        // Implement edge-to-edge display settings if required
    }
}

