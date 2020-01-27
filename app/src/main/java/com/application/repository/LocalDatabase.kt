package com.application.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import com.application.constants.DATABASE_VERSION
import com.application.model.Note

@Database(entities = [Note::class], version = DATABASE_VERSION)
abstract class LocalDatabase : RoomDatabase() {
    abstract val noteDao: NoteDao
}