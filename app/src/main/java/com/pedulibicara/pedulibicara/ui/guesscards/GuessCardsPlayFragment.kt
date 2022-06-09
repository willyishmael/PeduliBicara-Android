package com.pedulibicara.pedulibicara.ui.guesscards

import android.Manifest
import android.content.ContextWrapper
import android.content.pm.PackageManager
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
import com.bumptech.glide.Glide
import com.devlomi.record_view.OnRecordListener
import com.pedulibicara.pedulibicara.data.model.ModuleItem
import com.pedulibicara.pedulibicara.databinding.FragmentGuessCardsPlayBinding
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
    }

    private fun setupView() {
        Glide.with(requireContext())
            .load(question.image)
            .into(binding.ivCardImage)

        setupRecordView()
    }

    private fun setupRecordView() {
        binding.apply {
            recordButton.setRecordView(recordView)
            recordView.setOnRecordListener(object : OnRecordListener {
                override fun onStart() {
                    Log.d("RecordView", "onStart")
                }

                override fun onCancel() {
                    Log.d("RecordView", "onCancel")
                }

                override fun onFinish(recordTime: Long, limitReached: Boolean) {
                    val time: String = recordTime.toString()
                    Log.d("RecordView", "onFinish")
                    Log.d("RecordTime", time)
                }

                override fun onLessThanSecond() {
                    Log.d("RecordView", "onLessThanSecond")
                }

            })
        }
    }

    private fun nextQuestion() {
        viewModel.nextQuestion()
        question = viewModel.getQuestion()
        setupView()
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
        val file = File(musicDirectory, "recordingFile.mp3")
        return file.path
    }

    companion object {
        private const val MICROPHONE_PERMISSION_CODE = 200
    }

}