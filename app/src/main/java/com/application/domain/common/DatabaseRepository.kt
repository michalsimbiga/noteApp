package com.application.domain.common

import com.application.domain.Result
import com.application.domain.entity.Note
import kotlinx.coroutines.flow.Flow

interface DatabaseRepository {

    suspend fun saveNote(note: Note): Result<Unit>
    suspend fun getNotes(): Result<Flow<List<Note>>>
    suspend fun editNote(editedNote: Note): Result<Unit>
    suspend fun deleteNote(noteToDelete: Note): Result<Unit>
}