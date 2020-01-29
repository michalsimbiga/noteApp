package com.application.ui.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.application.databinding.FragmentOverviewBinding
import com.application.model.Note
import com.application.utility.DateAscendingComparator
import com.application.utility.OverviewRecyclerAdapter
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_overview.*
import javax.inject.Inject

class OverviewFragment : DaggerFragment() {

    @Inject
    lateinit var vmFactory: ViewModelProvider.Factory

    private val viewModel: OverviewViewModel by viewModels { vmFactory }

    private val recyclerAdapter =
        OverviewRecyclerAdapter().apply { setComparator(DateAscendingComparator()) }

    private lateinit var binding: FragmentOverviewBinding

    private val noteObserver = Observer<List<Note>> { newNotes ->
        recyclerAdapter.setItems(newNotes)
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

        viewModel.savedNotes.observe(viewLifecycleOwner, noteObserver)
    }
}