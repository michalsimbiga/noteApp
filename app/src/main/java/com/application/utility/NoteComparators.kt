package com.application.utility

import com.application.model.Note

class DateAscendingComparator : Comparator<Note> {
    override fun compare(firstNote: Note, secondNote: Note) =
        secondNote.created.compareTo(firstNote.created)
}

class DateDescendingComparator : Comparator<Note> {
    override fun compare(firstNote: Note, secondNote: Note) =
        firstNote.created.compareTo(secondNote.created)
}
