package com.application.utility

import androidx.room.TypeConverter
import java.text.SimpleDateFormat
import java.time.Instant
import java.util.*

val dateFormatWithTimeForTicketDetail = SimpleDateFormat("dd MMM yyyy HH:mm", Locale.getDefault())
val dateFormatWithTime = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())

class DateConverter {

    @TypeConverter
    fun toDate(string: String): Date = dateFormatWithTime.parse(string)

    @TypeConverter
    fun fromDate(date: Date): String = dateFormatWithTimeForTicketDetail.toLocalizedPattern()

}