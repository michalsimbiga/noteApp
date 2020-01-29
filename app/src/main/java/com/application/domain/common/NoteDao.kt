package com.application.domain.common

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.application.domain.entity.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("SELECT * FROM note")
    fun getAllNotes(): Flow<List<Note>>

    @Insert
    fun addNote(note: Note)

    @Update
    fun updateNote(updatedNote: Note)

    @Delete
    fun deleteNote(noteToDelete: Note)
}