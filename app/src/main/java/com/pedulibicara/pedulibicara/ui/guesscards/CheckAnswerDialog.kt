package com.pedulibicara.pedulibicara.ui.guesscards

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.pedulibicara.pedulibicara.R
import com.pedulibicara.pedulibicara.databinding.DialogCheckAnswerBinding

class CheckAnswerDialog(
    isAnswerCorrect: Boolean
): DialogFragment() {

    private var _binding: DialogCheckAnswerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogCheckAnswerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    init {
        setDialogImage(isAnswerCorrect)
    }

    /**
     * Set dialog image according to the answer
     * @param isAnswerCorrect Boolean
     */
    private fun setDialogImage(isAnswerCorrect: Boolean) {
        Glide.with(requireActivity())
            .load(if (isAnswerCorrect) R.drawable.img_succeed else R.drawable.img_fail)
            .into(binding.ivDialogImage)
    }
}