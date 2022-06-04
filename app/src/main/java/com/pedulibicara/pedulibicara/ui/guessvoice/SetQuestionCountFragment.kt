package com.pedulibicara.pedulibicara.ui.guessvoice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.pedulibicara.pedulibicara.databinding.FragmentSetQuestionCountBinding

class SetQuestionCountFragment : Fragment() {

    private var _binding: FragmentSetQuestionCountBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSetQuestionCountBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()
    }

    private fun setupView() {
        binding.btnNext.setOnClickListener {
            val questionCount = binding.nbQuestionCount.value
            val destination = SetQuestionCountFragmentDirections
                .actionSetQuestionCountFragmentToGuessVoicePlayFragment(questionCount)
            findNavController().navigate(destination)
        }
    }
}