package com.application.domain.useCase

import com.application.domain.NoParametersUseCase
import com.application.domain.common.DatabaseRepository
import com.application.domain.entity.Note
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RetrieveNotesUseCase @Inject constructor(
    private val databaseRepository: DatabaseRepository
) : NoParametersUseCase<Flow<List<Note>>>() {

    override suspend fun run() = databaseRepository.getNotes()
}