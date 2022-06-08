package com.pedulibicara.pedulibicara.ui.guesscards

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.pedulibicara.pedulibicara.data.model.ModuleItem
import com.pedulibicara.pedulibicara.databinding.FragmentGuessCardsPlayBinding

class GuessCardsPlayFragment : Fragment() {

    private val viewModel by viewModels<GuessCardsPlayViewModel>()

    private var _binding: FragmentGuessCardsPlayBinding? = null
    private val binding get() = _binding!!

    private lateinit var question: ModuleItem

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGuessCardsPlayBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.generateQuestions()
        question = viewModel.getQuestion()
        setupView()
    }

    private fun setupView() {

    }

    private fun nextQuestion() {
        viewModel.nextQuestion()
        question = viewModel.getQuestion()
        setupView()
    }

}