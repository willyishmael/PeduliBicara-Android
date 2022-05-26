package com.pedulibicara.pedulibicara.ui.module

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pedulibicara.pedulibicara.R

class ModuleItemDetailFragment : Fragment() {

    companion object {
        fun newInstance() = ModuleItemDetailFragment()
    }

    private lateinit var viewModel: ModuleItemDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_module_item_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ModuleItemDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}