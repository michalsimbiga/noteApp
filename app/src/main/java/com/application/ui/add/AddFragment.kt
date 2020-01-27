package com.application.ui.add

import android.os.Bundle
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuBuilder
import androidx.core.view.forEach
import androidx.core.view.get
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.application.R
import com.application.databinding.FragmentAddBinding
import com.application.utility.DateHelper
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.activity_overview.*
import timber.log.Timber
import java.util.*
import javax.inject.Inject

class AddFragment : DaggerFragment() {

    @Inject
    lateinit var vmFactory: ViewModelProvider.Factory

    private lateinit var binding: FragmentAddBinding

    private val viewModel: AddFragmentViewModel by viewModels { vmFactory }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        setHasOptionsMenu(true)
        registerForContextMenu(requireActivity().findViewById(R.id.activity_overview_toolbar))
        binding = FragmentAddBinding.inflate(inflater, container, false)

        with(binding) {
            lifecycleOwner = viewLifecycleOwner
            return root
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.toolbar_add_fragment_menu, menu)
        menu.forEach { item -> item.setOnMenuItemClickListener(onMenuClick) }
        super.onCreateOptionsMenu(menu, inflater)
    }

    private val onMenuClick = MenuItem.OnMenuItemClickListener { item ->
        when (item.itemId) {
            R.id.add_fragment_done_button -> {
                Timber.i("TESTING onActionOk clicked create ticket")
                with(binding) {
                    viewModel.addNote(
                        addFragmentDateAndTime.text.toString(),
                        addFragmentHeader.toString(),
                        addFragmentContent.toString()
                    )
                }
            }
        }
        true
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        Timber.i("TESTING onContextItemSelected")
        return true
    }
}