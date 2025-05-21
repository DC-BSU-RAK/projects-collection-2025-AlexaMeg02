package com.example.appdemo2

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.PopupWindow
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.appdemo2.R

@Suppress("UNREACHABLE_CODE")
class MainActivity : AppCompatActivity() {

    // Data class to hold description and image resource ID
    data class ElementReaction(val description: String, val imageResId: Int)

    // Map of element combos with reaction descriptions and image resource IDs
    private val elementResult = mapOf(
        "Iron" to mapOf(
            "Carbon" to ElementReaction(
                "Iron + Carbon = Steel\nComponent: Structural metal – used in tools, weapons, machines.",
                R.drawable.steel
            ),
            "Oxygen" to ElementReaction(
                "Iron + Oxygen = Iron Oxide (Fe₂O₃)\nComponent: Used in thermite, pigments, or magnetic cores.",
                R.drawable.iron_oxide
            ),
            "Sulfur" to ElementReaction(
                "Iron + Sulfur = Iron Sulfide (FeS)\nComponent: Early chemical compound – can be used for reactions or metallurgy.",
                R.drawable.iron_sulfide
            )
        ),
        "Carbon" to mapOf(
            "Oxygen" to ElementReaction(
                "Carbon + Oxygen → Carbon Dioxide (CO₂)\nComponent: Gas used in cooling, plant growth, fire suppression.",
                R.drawable.co
            ),
            "Iron" to ElementReaction(
                "Iron + Carbon = Steel\nComponent: Structural metal – used in tools, weapons, machines.",
                R.drawable.steel
            ),
            "Sulfur" to ElementReaction(
                "Carbon + Sulfur → Carbon Disulfide (CS₂)\nComponent: Industrial solvent – good for chemical production and synthetic fibers.",
                R.drawable.carbon_disulfide
            )
        ),
        "Oxygen" to mapOf(
            "Iron" to ElementReaction(
                "Iron + Oxygen = Iron Oxide (Fe₂O₃)\nComponent: Used in thermite, pigments, or magnetic cores.",
                R.drawable.iron_oxide
            ),
            "Carbon" to ElementReaction(
                "Carbon + Oxygen → Carbon Dioxide (CO₂)\nComponent: Gas used in cooling, plant growth, fire suppression.",
                R.drawable.co
            ),
            "Sulfur" to ElementReaction(
                "Sulfur + Oxygen → Sulfur Dioxide (SO₂)\nComponent: Used to make sulfuric acid, which unlocks batteries, fertilizers, explosives.",
                R.drawable.carbon_disulfide
            )
        ),
        "Sulfur" to mapOf(
            "Iron" to ElementReaction(
                "Iron + Sulfur = Iron Sulfide (FeS)\nComponent: Early chemical compound – can be used for reactions or metallurgy.",
                R.drawable.iron_sulfide
            ),
            "Carbon" to ElementReaction(
                "Carbon + Sulfur → Carbon Disulfide (CS₂)\nComponent: Industrial solvent – good for chemical production and synthetic fibers.",
                R.drawable.carbon_disulfide
            ),
            "Oxygen" to ElementReaction(
                "Sulfur + Oxygen → Sulfur Dioxide (SO₂)\nComponent: Used to make sulfuric acid, which unlocks batteries, fertilizers, explosives.",
                R.drawable.sc
            )
        )
    )


    private lateinit var resultTextView: TextView
    private lateinit var resultImageView: ImageView
    private lateinit var showInfoInstruct : ImageButton
    private val selectedElements = mutableListOf<String>()
//=======================================================================

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//=======================================================================

        val ironButton: ImageButton = findViewById(R.id.ironButton)
        val carbonButton: ImageButton = findViewById(R.id.carbonButton)
        val oxygenButton: ImageButton = findViewById(R.id.oxygenButton)
        val sulfurButton: ImageButton = findViewById(R.id.sulfurButton)
        val infoButton: ImageButton = findViewById(R.id.infoButton)
        resultTextView = findViewById(R.id.resultTextView)
        resultImageView = findViewById(R.id.resultImageView)

//=======================================================================

//=======================================================================

        val elementButtons = listOf(
            "Iron" to ironButton,
            "Carbon" to carbonButton,
            "Oxygen" to oxygenButton,
            "Sulfur" to sulfurButton
        )

        for ((element, button) in elementButtons) {
            button.setOnClickListener {
                onElementClicked(element)
            }
        }
    }

//========================================================================

    private fun onElementClicked(element: String) {
        // Check if the element is already selected
        if (selectedElements.contains(element)) {
            Toast.makeText(this, "$element is already selected", Toast.LENGTH_SHORT).show()
            return
        }

        // Clear previous selection if already selected two
        if (selectedElements.size == 2) {
            selectedElements.clear()
            resultTextView.text = ""
            resultImageView.setImageDrawable(null)
        }


        selectedElements.add(element)
        resultTextView.text = "So ( ${selectedElements.joinToString(" + ")} ) Mix With"
        resultImageView.setImageDrawable(null) // Clear image on first selection

        // When two elements selected, lookup and display result
        if (selectedElements.size == 2) {
            val first = selectedElements[0]
            val second = selectedElements[1]

            val reaction = elementResult[first]?.get(second) ?: elementResult[second]?.get(first)

            if (reaction != null) {
                resultTextView.text = reaction.description
                resultImageView.setImageResource(reaction.imageResId)
            } else {
                resultTextView.text = "No data available for $first + $second"
                resultImageView.setImageDrawable(null)
            }

            // Clear for next selection
            selectedElements.clear()
        }
        showInfoInstruct = findViewById(R.id.infoButton)
        showInfoInstruct.setOnClickListener {
            showPopup()
        }
    }
    private fun showPopup() {
        val inflater = getSystemService(LAYOUT_INFLATER_SERVICE)as LayoutInflater
        val popView = inflater.inflate(R.layout.activity_infopopup,null)

        val width = 1000
        val height = 2050


        val instructWindow = PopupWindow(popView, width, height, true)
        instructWindow.showAtLocation(popView, Gravity.CENTER, 10, 20)

        val closeButton = popView.findViewById<Button>(R.id.closeButton)
        closeButton.setOnClickListener{instructWindow.dismiss()}
    }
}