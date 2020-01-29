package com.application.utility

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.application.constants.zero
import com.application.domain.entity.Note

class SwipeToDeleteCallback(private val onSwipeDeleteCallback: (Note) -> Unit) :
    ItemTouchHelper.SimpleCallback(Int.zero, ItemTouchHelper.LEFT) {

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean = false

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        if (direction == ItemTouchHelper.LEFT) {
            if (viewHolder is NoteViewHolder) viewHolder.abstractItem?.let {
                onSwipeDeleteCallback.invoke(
                    it
                )
            }
        }
    }
}