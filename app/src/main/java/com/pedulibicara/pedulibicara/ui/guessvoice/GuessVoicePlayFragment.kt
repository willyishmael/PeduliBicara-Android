package com.pedulibicara.pedulibicara.ui.guessvoice

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.pedulibicara.pedulibicara.data.model.Question
import com.pedulibicara.pedulibicara.databinding.FragmentGuessVoicePlayBinding

class GuessVoicePlayFragment : Fragment() {

    private val viewModel by viewModels<GuessVoicePlayViewModel>()
    private var _binding: FragmentGuessVoicePlayBinding? = null
    private val binding get() = _binding!!

    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var questions: List<Question>
    private var questionsCount: Int = 0
    private var currentQuestionPosition = 0

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

        questionsCount = GuessVoicePlayFragmentArgs
            .fromBundle(arguments as Bundle)
            .questionCount

        prepareQuestion(questionsCount)
        setupButtons()
        displayQuestion()
    }

    private fun prepareQuestion(count: Int) {
        questions = viewModel.getQuestions(count)
    }

    private fun displayQuestion() {
        nextQuestion()
    }

    private fun nextQuestion() {
        val question = questions[currentQuestionPosition]
        val listOptions = viewModel.applyQuestionIntoPattern(question)

        binding.apply {
            setImage(listOptions[0].image, miOption0.ivItemImage)
            setImage(listOptions[1].image, miOption1.ivItemImage)
            setImage(listOptions[2].image, miOption2.ivItemImage)
            setImage(listOptions[3].image, miOption3.ivItemImage)
            mediaPlayer = MediaPlayer.create(context, question.answer.sound)
        }
    }

    private fun setImage(image: Int, view: ImageView) {
        Glide.with(requireActivity())
            .load(image)
            .apply(RequestOptions().override(100))
            .into(view)
    }

    private fun setupButtons() {
        binding.apply {
            miOption0.miContainer.setOnClickListener {

            }
            miOption1.miContainer.setOnClickListener {

            }
            miOption2.miContainer.setOnClickListener {

            }
            miOption3.miContainer.setOnClickListener {

            }
            btnPlaySound.setOnClickListener {
                if (mediaPlayer.isPlaying) {
                    mediaPlayer.stop()
                }
                mediaPlayer.start()
            }
        }
    }
}