package com.application.ui.add

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.application.di.module.ViewModelAssistedFactory
import com.application.repository.MyRepository
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject

class AddViewModel @AssistedInject constructor(
    private val repository: MyRepository,
    @Assisted private val stateHandle: SavedStateHandle
) : ViewModel() {

    @AssistedInject.Factory
    interface Factory : ViewModelAssistedFactory<AddViewModel>
}