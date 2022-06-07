package com.pedulibicara.pedulibicara.ui.gameresult

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.pedulibicara.pedulibicara.R
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
        setupStars()
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
            activity?.finish()
        }
    }

    private fun setupStars() {
        val star = R.drawable.ic_star
        val starBorder = R.drawable.ic_star_border
        binding.apply {
            when {
                finalScore <= 10 -> {
                    setImage(ivStar1, starBorder)
                    setImage(ivStar2, starBorder)
                    setImage(ivStar3, starBorder)
                    setImage(ivStar4, starBorder)
                    setImage(ivStar5, starBorder)
                }
                finalScore <= 20 -> {
                    setImage(ivStar1, star)
                    setImage(ivStar2, starBorder)
                    setImage(ivStar3, starBorder)
                    setImage(ivStar4, starBorder)
                    setImage(ivStar5, starBorder)
                }
                finalScore <= 40 -> {
                    setImage(ivStar1, star)
                    setImage(ivStar2, star)
                    setImage(ivStar3, starBorder)
                    setImage(ivStar4, starBorder)
                    setImage(ivStar5, starBorder)
                }
                finalScore <= 60 -> {
                    setImage(ivStar1, star)
                    setImage(ivStar2, star)
                    setImage(ivStar3, star)
                    setImage(ivStar4, starBorder)
                    setImage(ivStar5, starBorder)
                }
                finalScore <= 80 -> {
                    setImage(ivStar1, star)
                    setImage(ivStar2, star)
                    setImage(ivStar3, star)
                    setImage(ivStar4, star)
                    setImage(ivStar5, starBorder)
                }
                finalScore <= 100 -> {
                    setImage(ivStar1, star)
                    setImage(ivStar2, star)
                    setImage(ivStar3, star)
                    setImage(ivStar4, star)
                    setImage(ivStar5, star)
                }
            }
        }
    }

    private fun setImage(view: ImageView, imageId: Int) {
        Glide.with(requireContext())
            .load(imageId)
            .apply(RequestOptions().override(64))
            .into(view)
    }
}