package com.application.di.module

import androidx.lifecycle.ViewModel
import com.application.di.ViewModelKey
import com.application.domain.useCase.AddNoteUseCase
import com.application.domain.useCase.DeleteNoteUseCase
import com.application.domain.useCase.RetrieveNotesUseCase
import com.application.repository.MyRepository
import com.application.presentation.add.AddFragmentViewModel
import com.application.presentation.overview.OverviewViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class ViewModelModule {

//    @Provides
//    @IntoMap
//    @ViewModelKey(
//    fun ticketsOverviewActivityViewModel(repository: MyRepository): ViewModel =
//        TicketsOverviewActivityViewModel(repository)

    @Provides
    @IntoMap
    @ViewModelKey(OverviewViewModel::class)
    fun overviewViewModel(
        retrieveNotesUseCase: RetrieveNotesUseCase,
        deleteNoteUseCase: DeleteNoteUseCase,
        addNoteUseCase: AddNoteUseCase
    ): ViewModel =
        OverviewViewModel(
            retrieveNotesUseCase,
            deleteNoteUseCase,
            addNoteUseCase
        )

    @Provides
    @IntoMap
    @ViewModelKey(AddFragmentViewModel::class)
    fun addFragmentViewModel(addNoteUseCase: AddNoteUseCase): ViewModel =
        AddFragmentViewModel(addNoteUseCase)
}