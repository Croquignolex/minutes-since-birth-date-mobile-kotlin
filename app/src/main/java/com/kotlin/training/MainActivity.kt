package com.kotlin.training

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        datePickerButton.setOnClickListener {datePickerButtonView ->
            datePickerDialog(datePickerButtonView)
        }
    }

    private fun datePickerDialog(view: View) {
        val currentDate = Calendar.getInstance()
        val currentYear = currentDate.get(Calendar.YEAR)
        val currentMonth = currentDate.get(Calendar.MONTH)
        val currentDay = currentDate.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { _, DatePickerDialogYear, DatePickerDialogMonth, DatePickerDialogDay ->
                Toast.makeText(
                    this,
                    "l'année $DatePickerDialogYear, le mois ${DatePickerDialogMonth + 1}, le jour $DatePickerDialogDay",
                    Toast.LENGTH_SHORT
                ).show()
            },
            currentYear,
            currentMonth,
            currentDay
        ).show()
    }
}