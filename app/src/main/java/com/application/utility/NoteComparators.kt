package com.application.utility

import com.application.domain.entity.Note

class DateAscendingComparator : Comparator<Note> {
    override fun compare(firstNote: Note, secondNote: Note) =
        secondNote.created.time.compareTo(firstNote.created.time)
}

class DateDescendingComparator : Comparator<Note> {
    override fun compare(firstNote: Note, secondNote: Note) =
        firstNote.created.time.compareTo(secondNote.created.time)
}
