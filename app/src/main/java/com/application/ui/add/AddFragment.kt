package com.application.ui.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.application.databinding.FragmentAddBinding
import com.application.ui.base.BaseFragment

class AddFragment : BaseFragment() {

    private val viewModel: AddViewModel by viewModels { savedStateVMFactory }

    private lateinit var binding: FragmentAddBinding

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
}