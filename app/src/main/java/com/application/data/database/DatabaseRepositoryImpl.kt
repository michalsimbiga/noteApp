package com.application.data.database

import com.application.domain.Result
import com.application.domain.common.DatabaseRepository
import com.application.domain.entity.Note
import com.application.domain.safeCall
import com.application.domain.common.LocalDatabase
import kotlinx.coroutines.flow.Flow

class DatabaseRepositoryImpl(private val database: LocalDatabase) : DatabaseRepository {
    override suspend fun saveNote(note: Note): Result<Unit> =
        safeCall { database.noteDao.addNote(note) }

    override suspend fun getNotes(): Result<Flow<List<Note>>> =
        safeCall { database.noteDao.getAllNotes() }

    override suspend fun editNote(editedNote: Note): Result<Unit> =
        safeCall { database.noteDao.updateNote(editedNote) }

    override suspend fun deleteNote(noteToDelete: Note): Result<Unit> =
        safeCall { database.noteDao.deleteNote(noteToDelete) }
}
