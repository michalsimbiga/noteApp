package com.application.domain.common

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.application.constants.DATABASE_VERSION
import com.application.domain.entity.Note
import com.application.utility.DateConverter

@Database(entities = [Note::class], version = DATABASE_VERSION)
@TypeConverters(DateConverter::class)
abstract class LocalDatabase : RoomDatabase() {
    abstract val noteDao: NoteDao
}