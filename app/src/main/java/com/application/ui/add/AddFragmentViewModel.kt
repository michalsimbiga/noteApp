package com.application.ui.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.application.model.Note
import com.application.repository.LocalDataRepository
import com.application.utility.dateFormatWithTimeForTicketDetail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date

fun Date.toSimpleFormatString(format: SimpleDateFormat = dateFormatWithTimeForTicketDetail): String =
    format.format(this)

class AddFragmentViewModel(private val localDataRepository: LocalDataRepository) : ViewModel() {

    fun addNote(date: String, title: String, content: String) =
        viewModelScope.launch(Dispatchers.IO) {
            val convertedDate = dateFormatWithTimeForTicketDetail.parse(date)
            val note = Note(convertedDate, title, content)
            localDataRepository.saveNote(note)
        }

}