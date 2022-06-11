package com.pedulibicara.pedulibicara.ui.guesscards

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.pedulibicara.pedulibicara.R
import com.pedulibicara.pedulibicara.databinding.DialogCheckAnswerBinding
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

    private lateinit var binding: DialogCheckAnswerBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = DialogCheckAnswerBinding.inflate(layoutInflater)
        val builder = AlertDialog.Builder(requireActivity())
        builder.setView(binding.root)
        return builder.create()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        uploadFile()
    }

    private fun uploadFile() {
        setLoading(true)
        lifecycleScope.launchWhenStarted {
            launch {
                val requestAudioFile =file.asRequestBody("audio/wav".toMediaTypeOrNull())
                val audioMultipart:MultipartBody.Part =MultipartBody.Part.createFormData(
                    "audio",
                    file.name,
                    requestAudioFile
                )

                viewModel.predictVoice(audioMultipart)
                    .collect { response ->
                        response.onSuccess {
                            setLoading(false)
                        }
                        response.onFailure {
                            setLoading(false)
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
}