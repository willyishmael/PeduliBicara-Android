package com.pedulibicara.pedulibicara.ui.guessvoice

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pedulibicara.pedulibicara.R

class SetQuestionCountFragment : Fragment() {

    companion object {
        fun newInstance() = SetQuestionCountFragment()
    }

    private lateinit var viewModel: SetQuestionCountViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_set_question_count, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SetQuestionCountViewModel::class.java)
        // TODO: Use the ViewModel
    }

}