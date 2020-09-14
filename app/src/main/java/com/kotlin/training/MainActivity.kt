package com.kotlin.training

import java.util.*
import android.os.Bundle
import java.text.SimpleDateFormat
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        datePickerButton.setOnClickListener {
            // Open date picker dialog
            datePickerDialog()
        }
    }

    private fun datePickerDialog() {
        val currentDate = Calendar.getInstance()
        val currentYear = currentDate.get(Calendar.YEAR)
        val currentMonth = currentDate.get(Calendar.MONTH)
        val currentDay = currentDate.get(Calendar.DAY_OF_MONTH)

        // Show dialog
        DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { _, selectedYear, selectedMonth, selectedDay ->
                // Convert dates to String
                val currentDateString = formatDateToString(currentDay, currentMonth, currentYear)
                val selectedDateString = formatDateToString(selectedDay, selectedMonth, selectedYear)

                // Set selected date in UI
                chosenDate.text = selectedDateString

                // Set result in UI
                result.text = resultString(timeFromDateString(currentDateString), timeFromDateString(selectedDateString))
            },
            currentYear,
            currentMonth,
            currentDay
        ).show()
    }

    private fun formatDateToString(day: Int, month: Int, year: Int) = "$day/${month + 1}/$year"

    private fun timeFromDateString(stingDate: String) = SimpleDateFormat("dd/mm/yy", Locale.FRENCH).parse(stingDate)?.time

    private fun resultString(currentTime: Long?, selectedTime: Long?) = if((currentTime is Long) && (selectedTime is Long)) ((currentTime - selectedTime) / 60).toString() else "Impossible d'éffectuer le calcul"
}