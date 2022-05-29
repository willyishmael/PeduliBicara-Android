package com.pedulibicara.pedulibicara.ui.auth

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pedulibicara.pedulibicara.R

class PickGenderFragment : Fragment() {

    companion object {
        fun newInstance() = PickGenderFragment()
    }

    private lateinit var viewModel: PickGenderViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pick_gender, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PickGenderViewModel::class.java)
        // TODO: Use the ViewModel
    }

}