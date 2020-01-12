package com.application.ui.overview

import androidx.lifecycle.*
import com.application.di.module.ViewModelAssistedFactory
import com.application.model.Joke
import com.application.model.Note
import com.application.net.Response
import com.application.repository.MyRepository
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class OverviewViewModel @AssistedInject constructor(
    private val repository: MyRepository,
    @Assisted private val stateHandle: SavedStateHandle
) : ViewModel() {

    @AssistedInject.Factory
    interface Factory : ViewModelAssistedFactory<OverviewViewModel>

    private val _savedNotes = MutableLiveData<List<Note>>()
    val savedNotes: LiveData<List<Note>> = _savedNotes

    fun getSavedNotes() =
        viewModelScope.launch {
            _savedNotes.postValue(repository.getSavedNotes())
        }
}