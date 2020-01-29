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

    val savedNotes: LiveData<List<Note>>

    init {
        savedNotes = localDataRepository.getNotes()

    }
}