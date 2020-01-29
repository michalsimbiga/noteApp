package com.application.repository

import androidx.lifecycle.LiveData
import com.application.model.Note

interface LocalDataSource {

    suspend fun saveNote(note: Note)
    fun getNotes(): LiveData<List<Note>>
    suspend fun editNote(editedNote: Note): Boolean
}