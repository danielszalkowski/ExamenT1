package com.pmdm.exament1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class showBookActivity : AppCompatActivity() {

    private lateinit var tvBookText:TextView
    private lateinit var name: String
    private lateinit var seats: String
    private lateinit var time: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_book)
        initComponents()
    }

    private fun initComponents() {
        tvBookText = findViewById(R.id.tvBookText)
        name = intent.extras?.getString("EXTRA_NAME").orEmpty()
        seats = intent.extras?.getString("EXTRA_SEATS").orEmpty()
        time = intent.extras?.getString("EXTRA_TIME").orEmpty()
        setBookText()
    }

    private fun setBookText() {
        tvBookText.text = "MESA RESERVADA PARA $seats PERSONAS A NOMBRE DE $name, A LAS $time"
    }



}