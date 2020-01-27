package com.application.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.application.utility.DateConverter
import java.util.*

@Entity
@TypeConverters(DateConverter::class)
data class Note(
    @PrimaryKey(autoGenerate = true) val uid: Int,
    @ColumnInfo(name = "created") var created: Date,
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "content") var content: String
)