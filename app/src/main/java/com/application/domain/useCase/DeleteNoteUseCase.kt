package com.application.domain.useCase

import com.application.domain.UseCase
import com.application.domain.common.DatabaseRepository
import com.application.domain.entity.Note
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DeleteNoteUseCase @Inject constructor(private val databaseRepository: DatabaseRepository) :
    UseCase<Unit, DeleteNoteUseCase.Params>() {

    override suspend fun run(params: Params) = databaseRepository.deleteNote(params.note)

    data class Params(
        val note: Note
    )
}
