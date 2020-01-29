package com.application.di.module

import com.application.domain.common.DatabaseRepository
import com.application.domain.useCase.AddNoteUseCase
import com.application.domain.useCase.DeleteNoteUseCase
import com.application.domain.useCase.RetrieveNotesUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Provides
    @Singleton
    fun provideRetrieveNotesUseCase(databaseRepository: DatabaseRepository): RetrieveNotesUseCase =
        RetrieveNotesUseCase(databaseRepository)

    @Provides
    @Singleton
    fun provideAddNoteUseCase(databaseRepository: DatabaseRepository): AddNoteUseCase =
        AddNoteUseCase(databaseRepository)

    @Provides
    @Singleton
    fun provideDeleteNoteUseCase(databaseRepository: DatabaseRepository): DeleteNoteUseCase =
        DeleteNoteUseCase(databaseRepository)
}