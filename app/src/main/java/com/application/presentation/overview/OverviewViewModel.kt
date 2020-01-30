package com.application.presentation.overview

import androidx.lifecycle.*
import com.application.domain.doOnSuccess
import com.application.domain.entity.Note
import com.application.domain.useCase.AddNoteUseCase
import com.application.domain.useCase.DeleteNoteUseCase
import com.application.domain.useCase.RetrieveNotesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

class OverviewViewModel(
    private val retrieveNotesUseCase: RetrieveNotesUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase,
    private val addNoteUseCase: AddNoteUseCase
) : ViewModel() {

    private val _savedNotes = MutableLiveData<List<Note>>()
    val savedNotes: LiveData<List<Note>> = _savedNotes

    init {
        fetchNotes()
    }

    private fun fetchNotes() = viewModelScope.launch(Dispatchers.IO) {
        retrieveNotesUseCase.run()
            .doOnSuccess { newList -> setupFlow(newList) }
    }

    fun deleteNote(noteToDelete: Note) = viewModelScope.launch(Dispatchers.IO) {
        deleteNoteUseCase.run(DeleteNoteUseCase.Params(noteToDelete))
    }

    fun addNote(noteToAdd: Note) = viewModelScope.launch(Dispatchers.IO) {
        addNoteUseCase.run(AddNoteUseCase.Params(noteToAdd))
    }

    private fun setupFlow(flow: Flow<List<Note>>) = viewModelScope.launch {
        flow
            .flowOn(Dispatchers.IO)
            .collect { newList -> _savedNotes.postValue(newList) }
    }
}