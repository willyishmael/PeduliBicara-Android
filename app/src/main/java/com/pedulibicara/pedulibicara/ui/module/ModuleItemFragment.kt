package com.pedulibicara.pedulibicara.ui.module

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.pedulibicara.pedulibicara.data.local.Data
import com.pedulibicara.pedulibicara.data.model.ModuleItem
import com.pedulibicara.pedulibicara.databinding.FragmentModuleItemBinding
import com.pedulibicara.pedulibicara.ui.adapter.ModuleItemAdapter
import androidx.appcompat.app.AppCompatActivity

class ModuleItemFragment : Fragment() {

    private var _binding: FragmentModuleItemBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<ModuleItemViewModel>()
    private lateinit var listModuleItem: List<ModuleItem>

    @Suppress("RedundantNullableReturnType")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentModuleItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = "Module"
        val categoryKey = ModuleItemFragmentArgs.fromBundle(arguments as Bundle).categoryKey
        listModuleItem = viewModel.getModuleItems(categoryKey)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val mAdapter = ModuleItemAdapter(listModuleItem)

        mAdapter.setOnItemClickCallback(object : ModuleItemAdapter.OnItemClickCallback {
            override fun onItemClicked(item: ModuleItem) {
                val destination = ModuleItemFragmentDirections
                    .actionModuleItemFragmentToModuleItemDetailFragment(item)
                findNavController().navigate(destination)
            }
        })

        binding.rvModuleItem.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = mAdapter
        }
    }

}