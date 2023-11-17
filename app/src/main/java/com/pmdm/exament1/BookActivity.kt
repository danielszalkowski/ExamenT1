package com.pmdm.exament1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class BookActivity : AppCompatActivity() {

    private var seats: String = "2"
    private var timeT: String = "20:00"
    private var isTwoSeatsSelected: Boolean = true
    private var isFourSeatsSelected: Boolean = false
    private var isEightSeatsSelected: Boolean = false
    private lateinit var cvTwoSeats: CardView
    private lateinit var cvFourSeats: CardView
    private lateinit var cvEightSeats: CardView
    private lateinit var btnOk: FloatingActionButton
    private lateinit var etName: EditText
    private lateinit var btnLeft: FloatingActionButton
    private lateinit var btnRight: FloatingActionButton
    private lateinit var tvTime: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)
        initComponents()
        initListeners()
    }

    private fun initComponents() {
        cvTwoSeats = findViewById(R.id.cvTwoSeats)
        cvFourSeats = findViewById(R.id.cvFourSeats)
        cvEightSeats = findViewById(R.id.cvEightSeats)
        btnOk = findViewById(R.id.btnOk)
        etName = findViewById(R.id.etName)
        btnLeft = findViewById(R.id.btnLeft)
        btnRight = findViewById(R.id.btnRight)
        tvTime = findViewById(R.id.tvTime)
    }

    private fun initListeners() {
        cvTwoSeats.setOnClickListener() {
            isTwoSeatsSelected = true
            isFourSeatsSelected = false
            isEightSeatsSelected = false
            seats = "2"
            setSeatsColor()

        }
        cvFourSeats.setOnClickListener() {
            isTwoSeatsSelected = false
            isFourSeatsSelected = true
            isEightSeatsSelected = false
            seats = "4"
            setSeatsColor()
        }
        cvEightSeats.setOnClickListener() {
            isTwoSeatsSelected = false
            isFourSeatsSelected = false
            isEightSeatsSelected = true
            seats = "8"
            setSeatsColor()
        }
        btnOk.setOnClickListener() {
            val name = etName.text.toString()
            if (name.isEmpty()) {
                Toast.makeText(this, "¡El nombre no puede estar vacío!", Toast.LENGTH_LONG).show()
            } else {
                val intentGA = Intent(this, showBookActivity::class.java)
                intentGA.putExtra("EXTRA_NAME", name)
                intentGA.putExtra("EXTRA_SEATS", seats)
                intentGA.putExtra("EXTRA_TIME", timeT)
                startActivity(intentGA)
            }
            btnRight.setOnClickListener() {
                timeT = tvTime.toString()
                setTimeRight()
            }
            btnLeft.setOnClickListener() {
                timeT = tvTime.toString()
                setTimeLeft()
            }
        }
    }

    private fun setSeatsColor() {
        cvTwoSeats.setCardBackgroundColor(getBackgroundColor(isTwoSeatsSelected))
        cvFourSeats.setCardBackgroundColor(getBackgroundColor(isFourSeatsSelected))
        cvEightSeats.setCardBackgroundColor(getBackgroundColor(isEightSeatsSelected))
    }

    private fun getBackgroundColor(isComponentSelected: Boolean): Int {
        val colorReference = if (isComponentSelected) {
            R.color.bgCompSel
        } else {
            R.color.bgComp
        }
        return ContextCompat.getColor(this, colorReference)
    }

    private fun setTimeRight() {
        if (timeT == "20:00") {
            timeT = "21:00"
            tvTime.text = timeT
        } else if (timeT == "21:00") {
            timeT = "22:00"
            tvTime.text = timeT
        } else {
            timeT = "20:00"
            tvTime.text = timeT
        }

    }

    private fun setTimeLeft() {
        if (timeT == "20:00") {
            timeT = "22:00"
            tvTime.text = timeT
        } else if (timeT == "21:00") {
            timeT = "20:00"
            tvTime.text = timeT
        } else {
            timeT = "21:00"
            tvTime.text = timeT
        }
    }

}