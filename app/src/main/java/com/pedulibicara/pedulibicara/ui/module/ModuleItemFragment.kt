package com.pedulibicara.pedulibicara.ui.module

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.pedulibicara.pedulibicara.R
import com.pedulibicara.pedulibicara.data.local.Data
import com.pedulibicara.pedulibicara.data.model.ModuleItem
import com.pedulibicara.pedulibicara.databinding.FragmentModuleItemBinding
import com.pedulibicara.pedulibicara.ui.adapter.ModuleItemAdapter

class ModuleItemFragment : Fragment() {

    companion object {
        fun newInstance() = ModuleItemFragment()
    }

    private var _binding: FragmentModuleItemBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: ModuleItemViewModel
    private lateinit var listModuleItem: List<ModuleItem>

    @Suppress("RedundantNullableReturnType")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentModuleItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    @Suppress("DEPRECATION")
    @Deprecated("Deprecated in Java")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ModuleItemViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val categoryKey = ModuleItemFragmentArgs.fromBundle(arguments as Bundle).categoryKey
        listModuleItem = Data.getModuleItem(categoryKey)

        val mAdapter = ModuleItemAdapter(listModuleItem)

        binding.rvModuleItem.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = mAdapter
        }
    }

}