package com.pedulibicara.pedulibicara.ui.guessvoice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.pedulibicara.pedulibicara.data.model.Question
import com.pedulibicara.pedulibicara.databinding.FragmentGuessVoicePlayBinding

class GuessVoicePlayFragment : Fragment() {

    private val viewModel by viewModels<GuessVoicePlayViewModel>()
    private var _binding: FragmentGuessVoicePlayBinding? = null
    private val binding get() = _binding!!

    private lateinit var questions: List<Question>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGuessVoicePlayBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val questionCount = GuessVoicePlayFragmentArgs
            .fromBundle(arguments as Bundle)
            .questionCount

        prepareQuestion(questionCount)
    }

    private fun prepareQuestion(count: Int) {
        questions = viewModel.getQuestions(count)
    }
}