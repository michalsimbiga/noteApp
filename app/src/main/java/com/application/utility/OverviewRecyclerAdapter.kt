package com.application.utility

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.application.databinding.NoteItemLayoutBinding
import com.application.extensions.autoNotify
import com.application.domain.entity.Note
import java.util.*
import kotlin.properties.Delegates

class OverviewRecyclerAdapter : RecyclerView.Adapter<BaseViewHolder<*>>() {

    private var listOfNotes: List<Note> by Delegates.observable(emptyList()) { _, oldList, newList ->
        autoNotify(oldList, newList) { oldData, newData -> oldData == newData }
    }

    private var _comparator: Comparator<Note>? = null

    fun setItems(list: List<Note>) {
        val newList = mutableListOf<Note>()
        newList.addAll(list)
        _comparator?.let { comparator -> newList.sortWith(comparator) }
        listOfNotes = newList
    }

    fun setComparator(comparator: Comparator<Note>) {
        _comparator = comparator
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val inflater = LayoutInflater.from(parent.context)
        val binding = NoteItemLayoutBinding.inflate(inflater, parent, false)

        return NoteViewHolder(binding)
    }

    override fun getItemCount() = listOfNotes.size

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        if (holder is NoteViewHolder) holder.bind(listOfNotes[position], null)
    }
}

//class NoteViewHolder(private val binding: NoteItemLayoutBinding) :
//    BaseViewHolder<Note>(binding.root) {
//    override fun bind(item: Note?, onClickListener: ((Note) -> Unit)?) {
//
//        val dateToBind = item?.let { DateHelper(it.created) }
//
//        with(binding) {
//            note = item
//            date = dateToBind?.let { it }
//            executePendingBindings()
//        }
//    }
//
//}
