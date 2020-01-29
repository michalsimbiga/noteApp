package com.application.domain.useCase

import com.application.domain.UseCase
import com.application.domain.common.DatabaseRepository
import com.application.domain.entity.Note

class AddNoteUseCase(
    private val databaseRepository: DatabaseRepository
) : UseCase<Unit, AddNoteUseCase.Params>() {

    override suspend fun run(params: Params) = databaseRepository.saveNote(params.note)

    data class Params(
        val note: Note
    )
}
