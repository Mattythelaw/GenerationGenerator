package com.example.generationgenerator

import android.R.attr.button
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //Linking the XML views to Kotlin variables using their IDs//
        val edtYear = findViewById<EditText>(R.id.edtYear)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        val txtGen = findViewById<TextView>(R.id.txtGen)

        //using a set on click listener when the user clicks on it//
        btnSubmit.setOnClickListener {

            // Get the text the user typed in the EditText and convert it to a String//
            val yearText = edtYear.text.toString()

            // Check if the conversion failed (e.g. user typed letters instead of numbers)
            if (yearText.isEmpty()) {
                txtGen.text = "Please enter a year"
                return@setOnClickListener
            }
            // Convert the String to an Integer directly//
            val year = yearText.toInt()

            // Use a when statement with ranges to determine the generation
            val generation = when (year) {
                in 1901..1927 -> "The Greatest Generation"
                in 1928..1945 -> "The Silent Generation"
                in 1946..1964 -> "Baby Boomer"
                in 1965..1980 -> "Generation X"
                in 1981..1996 -> "Millennial"
                in 1997..2012 -> "Generation Z"
                in 2013..2025 -> "Generation Alpha"
                else -> "Generation not found in this year"
            }
            //Displaying the users generation//
            txtGen.text = "You are in: $generation"

        }




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}