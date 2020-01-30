package com.application.presentation.overview

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.application.databinding.FragmentOverviewBinding
import com.application.domain.entity.Note
import com.application.utility.DateAscendingComparator
import com.application.utility.OverviewListAdapter
import com.application.utility.SwipeToDeleteCallback
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_overview.*
import timber.log.Timber
import javax.inject.Inject

class OverviewFragment : DaggerFragment() {

    @Inject
    lateinit var vmFactory: ViewModelProvider.Factory

    private val viewModel: OverviewViewModel by viewModels { vmFactory }

    private val itemTouchHelper by lazy {
        ItemTouchHelper(SwipeToDeleteCallback { note ->
            viewModel.deleteNote(note)
            allowToRestoreNote(note)
        })
    }

    private val recyclerAdapter =
        OverviewListAdapter(
            clickListener = { click -> Timber.i("Testing $click") })
            .apply {
                setComparator(DateAscendingComparator())
                registerAdapterDataObserver(object : RecyclerView.AdapterDataObserver() {
                    override fun onChanged() {
                        overview_recycler_view.scrollToPosition(0)
                    }

                    override fun onItemRangeRemoved(positionStart: Int, itemCount: Int) {
                        overview_recycler_view.scrollToPosition(0)
                    }

                    override fun onItemRangeMoved(
                        fromPosition: Int,
                        toPosition: Int,
                        itemCount: Int
                    ) {
                        overview_recycler_view.scrollToPosition(0)
                    }

                    override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
                        overview_recycler_view.scrollToPosition(0)
                    }

                    override fun onItemRangeChanged(positionStart: Int, itemCount: Int) {
                        overview_recycler_view.scrollToPosition(0)
                    }

                    override fun onItemRangeChanged(
                        positionStart: Int,
                        itemCount: Int,
                        payload: Any?
                    ) {
                        overview_recycler_view.scrollToPosition(0)
                    }
                })
            }
//        OverviewRecyclerAdapter().apply { setComparator(DateAscendingComparator()) }

    private lateinit var binding: FragmentOverviewBinding

    private val noteObserver = Observer<List<Note>> { newNotes ->
        recyclerAdapter.submitList(newNotes)
        //        recyclerAdapter.setItems(newNotes)
        with(binding) {
            numOfItems = newNotes.size
            executePendingBindings()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentOverviewBinding.inflate(inflater, container, false)

        with(binding) {
            lifecycleOwner = viewLifecycleOwner
            return root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        overview_recycler_view.adapter = recyclerAdapter
        itemTouchHelper.attachToRecyclerView(overview_recycler_view)

        viewModel.savedNotes.observe(viewLifecycleOwner, noteObserver)
    }

    private fun allowToRestoreNote(note: Note) {
        Snackbar.make(binding.fragmentOverviewMainLayout, "Note Removed", Snackbar.LENGTH_LONG)
            .apply {
                setAction("UNDO") { viewModel.addNote(note) }
                setActionTextColor(Color.YELLOW)
                show()
            }
    }
}