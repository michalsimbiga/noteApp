package com.application.utility

import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.application.databinding.NoteItemLayoutBinding
import com.application.extensions.autoNotify
import com.application.model.Note
import java.util.*
import kotlin.properties.Delegates

class OverviewRecyclerAdapter : RecyclerView.Adapter<BaseViewHolder<*>>() {

    private var listOfNotes: List<Note> by Delegates.observable(emptyList()) { _, oldList, newList ->
        autoNotify(oldList, newList) { oldData, newData -> oldData == newData }
    }

    fun setItems(list: List<Note>) {
        listOfNotes = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val inflater = LayoutInflater.from(parent.context)
        val binding = NoteItemLayoutBinding.inflate(inflater, parent, false)

        return NoteViewHolder(binding)
    }

    override fun getItemCount() = listOfNotes.size

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        if (holder is NoteViewHolder) holder.bind(listOfNotes[position], null)
        else holder.bind()
    }
}

class NoteViewHolder(private val binding: NoteItemLayoutBinding) :
    BaseViewHolder<Note>(binding.root) {
    override fun bind(item: Note?, onClickListener: ((Note) -> Unit)?) {

        val dateToBind = item?.let { DateHelper(it.created) }

        with(binding) {
            note = item
            date = dateToBind?.let { it }
            executePendingBindings()
        }
    }

}
