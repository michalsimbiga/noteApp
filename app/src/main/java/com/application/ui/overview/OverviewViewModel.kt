package com.application.ui.overview

import androidx.lifecycle.*
import com.application.model.Note
import com.application.repository.MyRepository
import com.squareup.inject.assisted.AssistedInject
import kotlinx.coroutines.launch

class OverviewViewModel(private val repository: MyRepository) : ViewModel() {

    private val _savedNotes = MutableLiveData<List<Note>>()
    val savedNotes: LiveData<List<Note>> = _savedNotes

    fun getSavedNotes() =
        viewModelScope.launch {
            _savedNotes.postValue(repository.getSavedNotes())
        }
}