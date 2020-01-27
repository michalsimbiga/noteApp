package com.application.repository

import com.application.model.Note

interface LocalDataSource {

    suspend fun saveNote(note: Note)
    suspend fun getNotes(): List<Note>
    suspend fun editNote(editedNote: Note): Boolean
}