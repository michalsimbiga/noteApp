package com.application.ui.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.application.R
import com.application.model.Note
import com.application.ui.base.BaseFragment
import com.application.utility.OverviewRecyclerAdapter
import kotlinx.android.synthetic.main.fragment_overview.*

class OverviewFragment : BaseFragment() {

    private val viewModel: OverviewViewModel by viewModels { savedStateVMFactory }

    private val recyclerAdapter = OverviewRecyclerAdapter()

    private val noteObserver =
        Observer<List<Note>> { newNotes -> recyclerAdapter.setItems(newNotes)
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_overview, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        overview_recycler_view.adapter = recyclerAdapter

        viewModel.savedNotes.observe(viewLifecycleOwner, noteObserver)

        viewModel.getSavedNotes()
    }
}