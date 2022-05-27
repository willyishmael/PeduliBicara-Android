package com.pedulibicara.pedulibicara.ui.guessvoice

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pedulibicara.pedulibicara.R

class GuessVoicePlayFragment : Fragment() {

    companion object {
        fun newInstance() = GuessVoicePlayFragment()
    }

    private lateinit var viewModel: GuessVoicePlayViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_guess_voice_play, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(GuessVoicePlayViewModel::class.java)
        // TODO: Use the ViewModel
    }

}