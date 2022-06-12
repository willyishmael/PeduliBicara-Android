package com.pedulibicara.pedulibicara.ui.guessvoice

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.media.AudioAttributes
import android.media.SoundPool
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.pedulibicara.pedulibicara.R
import com.pedulibicara.pedulibicara.data.model.Question
import com.pedulibicara.pedulibicara.databinding.FragmentGuessVoicePlayBinding

class GuessVoicePlayFragment : Fragment() {

    private val viewModel by viewModels<GuessVoicePlayViewModel>()
    private var _binding: FragmentGuessVoicePlayBinding? = null
    private val binding get() = _binding!!

    private var soundPool: SoundPool? = null
    private lateinit var questions: List<Question>
    private var questionsCount: Int = 0
    private var currentQuestionPosition = 0
    private var currentAnswerPosition = 0
    private var soundId = 0

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
        soundPool?.release()
        soundPool = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        questionsCount = GuessVoicePlayFragmentArgs
            .fromBundle(arguments as Bundle)
            .questionCount

        prepareQuestion(questionsCount)
        setupButtons()
        setupSoundPool()
        displayQuestion()
    }

    private fun prepareQuestion(count: Int) {
        questions = viewModel.getQuestions(count)
    }

    private fun displayQuestion() {
        nextQuestion()
    }

    private fun nextQuestion() {
        if (currentQuestionPosition < questionsCount) {
            val question = questions[currentQuestionPosition]
            val listOptions = viewModel.applyQuestionIntoPattern(question)

            binding.apply {
                setImage(listOptions[0].image, miOption0.ivItemImage)
                setImage(listOptions[1].image, miOption1.ivItemImage)
                setImage(listOptions[2].image, miOption2.ivItemImage)
                setImage(listOptions[3].image, miOption3.ivItemImage)
                soundId = soundPool!!.load(context, question.answer.sound, 1)
            }

            currentAnswerPosition = question.indexPattern[0]
            currentQuestionPosition += 1
        } else {
            gameFinished()
        }
    }

    private fun setImage(image: Int, view: ImageView) {
        Glide.with(requireActivity())
            .load(image)
            .apply(RequestOptions().override(100))
            .into(view)
    }

    private fun setupSoundPool() {
        val audioAttributes = AudioAttributes.Builder()
            .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
            .setUsage(AudioAttributes.USAGE_GAME)
            .build()

        soundPool = SoundPool.Builder()
            .setAudioAttributes(audioAttributes)
            .build()
    }

    private fun setupButtons() {
        binding.apply {
            miOption0.miContainer.setOnClickListener {
                checkAnswer(0)
                nextQuestion()
            }
            miOption1.miContainer.setOnClickListener {
                checkAnswer(1)
                nextQuestion()
            }
            miOption2.miContainer.setOnClickListener {
                checkAnswer(2)
                nextQuestion()
            }
            miOption3.miContainer.setOnClickListener {
                checkAnswer(3)
                nextQuestion()
            }
            btnPlaySound.setOnClickListener {
                Log.d("debug", "soundPool = $soundPool")
                Log.d("debug", "soundId = $soundId")

                soundPool?.play(soundId,1f,1f,1,0, 1f)
            }
        }
    }

    private fun checkAnswer(clickedButton: Int) {
        if (clickedButton == currentAnswerPosition) {
            viewModel.addScore()
            showCorrectDialog()
        } else {
            showWrongDialog()
        }
        Log.d("checkAnswer()","score = ${viewModel.getFinalScore()}")
    }

    private fun gameFinished() {
        GuessVoicePlayFragmentDirections
            .actionGuessVoicePlayFragmentToGameResultFragment()
            .apply {
                questionCount = viewModel.getQuestionCount()
                rightAnswer = viewModel.getRightAnswer()
                finalScore = viewModel.getFinalScore()
                findNavController().navigate(this)
            }
    }

    private fun showCorrectDialog() {
        val dialog = Dialog(requireContext())
        dialog.apply {
            setContentView(R.layout.dialog_correct_answer)
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            show()
        }
    }

    private fun showWrongDialog() {
        val dialog = Dialog(requireContext())
        dialog.apply {
            setContentView(R.layout.dialog_wrong_answer)
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            show()
        }
    }
}