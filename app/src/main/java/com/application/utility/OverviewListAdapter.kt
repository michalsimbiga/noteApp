package com.application.utility

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.application.databinding.NoteItemLayoutBinding
import com.application.domain.entity.Note
import java.util.Comparator

class OverviewListAdapter(
    private val clickListener: (Note) -> Unit
) :
    ListAdapter<Note, RecyclerView.ViewHolder>(TaskDiffCallback()) {

    private var _comparator: Comparator<Note>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = NoteItemLayoutBinding.inflate(inflater, parent, false)

        return NoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is NoteViewHolder) holder.bind(getItem(position), clickListener)
    }

    override fun submitList(list: List<Note>?) {
        val sortedList = mutableListOf<Note>().apply { addAll(list ?: return) }
        _comparator?.let { comparator -> sortedList.sortWith(comparator) }
        super.submitList(sortedList)
    }

    fun setComparator(comparator: Comparator<Note>) {
        _comparator = comparator
    }
}

class TaskDiffCallback : DiffUtil.ItemCallback<Note>() {
    override fun areItemsTheSame(oldItem: Note, newItem: Note) = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: Note, newItem: Note) = oldItem == newItem
}

class NoteViewHolder(private val binding: NoteItemLayoutBinding) :
    BaseViewHolder<Note>(binding.root) {
    override fun bind(
        item: Note,
        onClickListener: ((Note) -> Unit)?
    ) {
        val dateToBind = DateHelper(item.created)
        abstractItem = item
        with(binding) {
            this.note = item
            recyclerNoteContent.setOnClickListener { onClickListener?.invoke(item) }
            date = dateToBind
            executePendingBindings()
        }
    }

}