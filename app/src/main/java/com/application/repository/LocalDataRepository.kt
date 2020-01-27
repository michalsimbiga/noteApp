package com.application.repository

import com.application.model.Note

class LocalDataRepository(private val database: LocalDatabase) : LocalDataSource {

    override suspend fun saveNote(note: Note) = database.noteDao.addNote(note)
    override suspend fun getNotes(): List<Note> = database.noteDao.getAllNotes()

    override suspend fun editNote(editedNote: Note): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}