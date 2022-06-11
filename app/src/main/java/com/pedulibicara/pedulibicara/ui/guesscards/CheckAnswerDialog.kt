package com.pedulibicara.pedulibicara.ui.guesscards

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.pedulibicara.pedulibicara.R
import com.pedulibicara.pedulibicara.databinding.DialogCheckAnswerBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File

class CheckAnswerDialog(
    private val viewModel: GuessCardsPlayViewModel,
    private val file: File,
    private val onDialogFinished: () -> Unit
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        uploadFile()
    }

    /**
     * Upload audio file to predict
     *
     */
    private fun uploadFile() {
        setLoading(true)
        lifecycleScope.launchWhenStarted {
            launch {
                val requestAudioFile = file.asRequestBody("audio/wav".toMediaTypeOrNull())
                val audioMultipart: MultipartBody.Part = MultipartBody.Part.createFormData(
                    "audio",
                    file.name,
                    requestAudioFile
                )

                viewModel.predictVoice(audioMultipart)
                    .collect { response ->
                        response.onSuccess {
                            setLoading(false)
                            val isAnswerCorrect = viewModel.checkAnswer(it.result)
                            setDialogImage(isAnswerCorrect)
                            delay(DIALOG_DELAY)
                            onDialogFinished
                            dismiss()
                        }
                        response.onFailure {
                            setLoading(false)
                            it.printStackTrace()
                        }
                    }
            }
        }
    }

    /**
     * Set loading condition
     * @param state Boolean
     */
    private fun setLoading(state: Boolean) {
        binding.apply {
            dotLoader.visibility = if (state) View.VISIBLE else View.GONE
            ivDialogImage.visibility = if (state) View.GONE else View.VISIBLE
        }
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

    companion object {
        const val DIALOG_DELAY = 3000L
    }
}