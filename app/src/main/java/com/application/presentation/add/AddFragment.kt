package com.application.presentation.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.forEach
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.application.R
import com.application.databinding.FragmentAddBinding
import com.application.extensions.hideKeyboard
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.activity_overview.*
import timber.log.Timber
import javax.inject.Inject

class AddFragment : DaggerFragment() {

    @Inject
    lateinit var vmFactory: ViewModelProvider.Factory

    private lateinit var binding: FragmentAddBinding

    private val viewModel: AddFragmentViewModel by viewModels { vmFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        registerForContextMenu(requireActivity().findViewById(R.id.activity_overview_toolbar))
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBinding.inflate(inflater, container, false)

        with(binding) {
            lifecycleOwner = viewLifecycleOwner
            return root
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        Timber.i("TESTING onCreateOptionsMenu")
        menu.clear()
        inflater.inflate(R.menu.toolbar_add_fragment_menu, menu)
//        menu.forEach { item -> item.setOnMenuItemClickListener(onMenuClick) }
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add_fragment_done_button -> {
                Timber.i("TESTING onActionOk clicked create ticket")
                with(binding) {
                    viewModel.addNote(
                        addFragmentDateAndTime.text.toString(),
                        addFragmentHeader.text.toString(),
                        addFragmentContent.text.toString()
                    )
                }
                hideKeyboard()
                findNavController().popBackStack()
            }
        }
        return true
    }

}