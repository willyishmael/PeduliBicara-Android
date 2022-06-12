package com.pedulibicara.pedulibicara.ui.guesscards

import android.Manifest
import android.app.Dialog
import android.content.ContextWrapper
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.media.MediaRecorder
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.devlomi.record_view.OnRecordListener
import com.pedulibicara.pedulibicara.R
import com.pedulibicara.pedulibicara.data.model.ModuleItem
import com.pedulibicara.pedulibicara.databinding.FragmentGuessCardsPlayBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File

class GuessCardsPlayFragment : Fragment() {

    private val viewModel by viewModels<GuessCardsPlayViewModel>()

    private var _binding: FragmentGuessCardsPlayBinding? = null
    private val binding get() = _binding!!

    private lateinit var question: ModuleItem
    private var mediaRecorder: MediaRecorder? = null

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

        if (isMicrophoneAvailable()) getMicrophonePermission()

        viewModel.generateQuestions()
        question = viewModel.getQuestion()
        setupView()
        setupRecordView()
    }

    private fun setupView() {
        Glide.with(requireContext())
            .load(question.image)
            .into(binding.ivCardImage)
    }

    private fun setupRecordView() {
        binding.apply {
            recordButton.setRecordView(recordView)
            recordView.setOnRecordListener(object : OnRecordListener {
                override fun onStart() {
                    recordAudio()
                }

                override fun onCancel() {
                    stopRecordAudio()
                }

                override fun onFinish(recordTime: Long, limitReached: Boolean) {
                    stopRecordAudio()
                    val file = File(getRecordingFilePath())
                    uploadFile(file)
                }

                override fun onLessThanSecond() {
                    Log.d("RecordView", "onLessThanSecond")
                }

            })
        }
    }

    private fun nextQuestion() {
        if (viewModel.isGameFinished()) {
            gameFinished()
        } else {
            viewModel.nextQuestion()
            question = viewModel.getQuestion()
            setupView()
        }
    }

    private fun gameFinished() {
        GuessCardsPlayFragmentDirections
            .actionGuessCardsPlayFragmentToGameResultFragment2()
            .apply {
                questionCount = GuessCardsPlayViewModel.QUESTION_COUNT.toFloat()
                rightAnswer = viewModel.getRightAnswer()
                finalScore = viewModel.getFinalScore()
                findNavController().navigate(this)
            }
    }

    private fun isMicrophoneAvailable() : Boolean {
        return requireActivity().packageManager.hasSystemFeature(PackageManager.FEATURE_MICROPHONE)
    }

    private fun getMicrophonePermission() {
        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_DENIED) {
            val permission = arrayOf(Manifest.permission.RECORD_AUDIO)
            ActivityCompat.requestPermissions(requireActivity(), permission, MICROPHONE_PERMISSION_CODE)
        }
    }

    @Suppress("DEPRECATION")
    private fun recordAudio() {
        try {
            mediaRecorder = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                MediaRecorder(requireContext())
            } else MediaRecorder()
            mediaRecorder?.apply {
                setAudioSource(MediaRecorder.AudioSource.MIC)
                setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
                setOutputFile(getRecordingFilePath())
                setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)
                prepare()
                start()
                Toast.makeText(requireContext(), "Recording is started", Toast.LENGTH_SHORT).show()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun stopRecordAudio() {
        mediaRecorder?.apply {
            stop()
            release()
        }
        mediaRecorder = null
        Toast.makeText(requireContext(), "Recording is stopped", Toast.LENGTH_SHORT).show()
    }

    private fun getRecordingFilePath(): String {
        val contextWrapper = ContextWrapper(requireContext().applicationContext)
        val musicDirectory = contextWrapper.getExternalFilesDir(Environment.DIRECTORY_MUSIC)
        val file = File(musicDirectory, "recordingFile.wav")
        return file.path
    }

    private fun uploadFile(file: File) {
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
                            if (isAnswerCorrect) showCorrectDialog() else showWrongDialog()
                            nextQuestion()
                        }
                        response.onFailure {
                            setLoading(false)
                            showResponseFailureDialog()
                            it.printStackTrace()
                        }
                    }
            }
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

    private fun showResponseFailureDialog() {
        val dialog = Dialog(requireContext())
        dialog.apply {
            setContentView(R.layout.dialog_response_failure)
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            show()
        }
    }

    private fun setLoading(state: Boolean) {
        binding.loadingLayout.visibility = if (state) View.VISIBLE else View.GONE
    }

    companion object {
        private const val MICROPHONE_PERMISSION_CODE = 200
    }

}