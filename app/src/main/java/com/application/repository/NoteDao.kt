package com.application.repository

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.application.model.Note

@Dao
interface NoteDao {

    @Query("SELECT * FROM note")
    fun getAllNotes(): LiveData<List<Note>>

    @Insert
    fun addNote(note: Note)
}