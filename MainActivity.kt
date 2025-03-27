package com.example.assignment1

import android.annotation.SuppressLint
import android.os.Build.VERSION_CODES.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val SubmitButton = findViewById<Button>(R.id.SubmitButton)
        val ResetButton = findViewById<Button>(R.id.ResetButton)
        val editHour = findViewById<EditText>(R.id.editHour)
        val suggestionText = findViewById<EditText>(R.id.suggestionText)

        SubmitButton.setOnClickListener {
            val timeOfDay: String = editHour.text.toString().trim().lowercase()
            val mealSuggestion: String = getMealSuggestion(timeOfDay)
            suggestionText.text = mealSuggestion
        }

        ResetButton.setOnClickListener {
            editHour.text.clear()
            suggestionText.text = "Meal suggestion will appear"
        }
    }

    private fun getMealSuggestion(timeOfDay: String): String {
        return when (timeOfDay) {
            "morning" -> "Breakfast: Eggs, Toast"
            "afternoon" -> "Lunch: Salmon salad"
            "dinner" -> "Dinner: Rice and chicken"
            else -> "Invalid time of day. Please enter morning, afternoon or dinner"
        }
    }
