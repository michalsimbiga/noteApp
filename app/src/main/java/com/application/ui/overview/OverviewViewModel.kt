package com.application.ui.overview

import androidx.lifecycle.*
import com.application.model.Note
import com.application.repository.LocalDataRepository
import com.application.repository.MyRepository
import com.squareup.inject.assisted.AssistedInject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class OverviewViewModel(
    private val repository: MyRepository,
    private val localDataRepository: LocalDataRepository
) : ViewModel() {

    private val _savedNotes = MutableLiveData<List<Note>>()
    val savedNotes: LiveData<List<Note>> = _savedNotes

    fun getSavedNotes() =
        viewModelScope.launch {
            _savedNotes.postValue(withContext(Dispatchers.IO) { localDataRepository.getNotes() })
        }
}