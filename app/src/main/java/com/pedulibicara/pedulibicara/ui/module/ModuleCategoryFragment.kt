package com.pedulibicara.pedulibicara.ui.module

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.pedulibicara.pedulibicara.data.model.ModuleCategory
import com.pedulibicara.pedulibicara.databinding.FragmentModuleCategoryBinding
import com.pedulibicara.pedulibicara.ui.adapter.ModuleCategoryAdapter

class ModuleCategoryFragment : Fragment() {

    private var _binding: FragmentModuleCategoryBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<ModuleCategoryViewModel>()
    private lateinit var listCategory: List<ModuleCategory>

    @Suppress("RedundantNullableReturnType")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentModuleCategoryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listCategory = viewModel.getModuleCategory()

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val mAdapter = ModuleCategoryAdapter(listCategory)

        mAdapter.setOnItemClickCallback(object : ModuleCategoryAdapter.OnItemClickCallback{
            override fun onItemClicked(moduleCategory: ModuleCategory) {
                val destination = ModuleCategoryFragmentDirections
                    .actionModuleCategoryFragmentToModuleItemFragment()
                destination.categoryKey = moduleCategory.key
                findNavController().navigate(destination)
            }
        })

        binding.rvListCategory.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = mAdapter
        }
    }

}