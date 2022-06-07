package com.pedulibicara.pedulibicara.ui.gameresult

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.pedulibicara.pedulibicara.databinding.FragmentGameResultBinding

class GameResultFragment : Fragment() {

    private var _binding: FragmentGameResultBinding? = null
    private val binding get() = _binding!!

    private var questionCount = 0f
    private var rightAnswer = 0f
    private var wrongAnswer = 0f
    private var finalScore = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getNavArguments()
        setupContent()
        setupButton()
    }

    private fun getNavArguments() {
        val args = GameResultFragmentArgs.fromBundle(arguments as Bundle)
        questionCount = args.questionCount
        rightAnswer = args.rightAnswer
        wrongAnswer = questionCount - rightAnswer
        finalScore = args.finalScore.toInt()
    }

    private fun setupContent() {
        binding.apply {
            tvQuestionCount.text = questionCount.toInt().toString()
            tvRightAnswer.text = rightAnswer.toInt().toString()
            tvWrongAnswer.text = wrongAnswer.toInt().toString()
            tvScore.text = finalScore.toString()
        }
    }

    private fun setupButton() {
        binding.btnMainMenu.setOnClickListener {
            GameResultFragmentDirections.actionGameResultFragmentToMainActivity2().apply {
                findNavController().navigate(this)
            }
        }
    }
}