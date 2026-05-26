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

        val edtYear = findViewById<EditText>(R.id.edtYear)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        val txtGen = findViewById<TextView>(R.id.txtGen)

        btnSubmit.setOnClickListener {
            val yearText = edtYear.text.toString()

            if (yearText.isEmpty()) {
                txtGen.text = "Please enter a year"
                return@setOnClickListener
            }

            val year = yearText.toInt()

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

            txtGen.text = "You are in: $generation"

        }




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}