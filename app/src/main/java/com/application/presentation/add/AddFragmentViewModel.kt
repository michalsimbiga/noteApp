package com.application.presentation.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.application.domain.entity.Note
import com.application.domain.useCase.AddNoteUseCase
import com.application.utility.dateFormatWithTimeForTicketDetail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date

fun Date.toSimpleFormatString(format: SimpleDateFormat = dateFormatWithTimeForTicketDetail): String =
    format.format(this)

class AddFragmentViewModel(private val addNoteUseCase: AddNoteUseCase) : ViewModel() {

    fun addNote(date: String, title: String, content: String) =
        viewModelScope.launch(Dispatchers.IO) {
            val convertedDate = dateFormatWithTimeForTicketDetail.parse(date)
            val preparedNote = Note(convertedDate, title, content)
            addNoteUseCase.run(AddNoteUseCase.Params(preparedNote))
        }
}