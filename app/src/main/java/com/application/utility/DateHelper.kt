package com.application.utility

import android.text.format.DateFormat
import java.util.*

class DateHelper(date: Date) {

    val monthShort: String = DateFormat.format(MONTH_SHORT_NAME, date).toString().capitalize()
    val year = DateFormat.format(YEAR, date)
    val day = DateFormat.format(DAY, date)
    val ampm = DateFormat.format(AM_PM, date)
    val minute = DateFormat.format(MINUTES, date)
    val hour = DateFormat.format(HOUR, date)
    val fullHour = "$hour:$minute$ampm"

    companion object {
        private const val MONTH_SHORT_NAME = "MMM"
        private const val MONTH_FULL_NAME = "EEEE"
        private const val MONTH_NUMBER = "MM"
        private const val YEAR = "yyyy"
        private const val DAY = "dd"
        private const val AM_PM = "a"
        private const val MINUTES = "M"
        private const val HOUR = "h"
    }
}