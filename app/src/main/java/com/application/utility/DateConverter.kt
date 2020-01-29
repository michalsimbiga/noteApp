package com.application.utility

import androidx.room.TypeConverter
import java.text.SimpleDateFormat
import java.time.Instant
import java.util.*

val dateFormatWithTimeForTicketDetail = SimpleDateFormat("dd MMM yyyy HH:mm:ss", Locale.getDefault())
val dateFormatHourMinutes = SimpleDateFormat("HH:mm", Locale.getDefault())

class DateConverter {
    @TypeConverter
    fun fromTimestamp(timestamp: Long?): Date? = timestamp?.let { Date(it) }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? = date?.time
}