package com.example.drstoneexplainationapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var searchText: EditText
    private lateinit var searchButton: Button
    private lateinit var clearButton: Button
    private lateinit var sharedPreferences: SharedPreferences

    // Map of valid elements to their corresponding activities
    private val elementToActivityMap = mapOf(
        "iron" to pageOne::class.java,
        "sulfur" to pageTwo::class.java, // Assuming you have a PageTwo activity
        "oxygen" to pageThree::class.java, // Assuming you have a PageThree activity
        "carbon" to pageFour::class.java // Assuming you have a PageFour activity
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        searchText = findViewById(R.id.searchText)
        searchButton = findViewById(R.id.searchButton)
        clearButton = findViewById(R.id.clearButton)

        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        searchButton.setOnClickListener {
            val userInput = searchText.text.toString().trim().lowercase()
            if (userInput.isNotBlank()) {
                val activityClass = elementToActivityMap[userInput]
                if (activityClass != null) {
                    val intent = Intent(this, activityClass)
                    startActivity(intent)
                    val editor = sharedPreferences.edit()
                    editor.putString("text", userInput)
                    editor.apply()
                } else {
                    searchText.error = "Please enter a valid element: iron, sulfer, oxygen, or carbon."
                }
            } else {
                searchText.error = "Please enter a search term"
            }
        }

        clearButton.setOnClickListener {
            searchText.text.clear()
        }





    }
}