package com.pedulibicara.pedulibicara.ui.module

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pedulibicara.pedulibicara.databinding.FragmentModuleItemDetailBinding

class ModuleItemDetailFragment : Fragment() {

    companion object {
        fun newInstance() = ModuleItemDetailFragment()
    }

    private lateinit var viewModel: ModuleItemDetailViewModel

    private var _binding: FragmentModuleItemDetailBinding? = null
    private val binding get() = _binding!!

    @Suppress("RedundantNullableReturnType")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentModuleItemDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    @Deprecated("Deprecated in Java")
    @Suppress("DEPRECATION")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ModuleItemDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

}