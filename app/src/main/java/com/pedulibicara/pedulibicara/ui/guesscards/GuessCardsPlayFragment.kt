package com.pedulibicara.pedulibicara.ui.guesscards

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pedulibicara.pedulibicara.R

class GuessCardsPlayFragment : Fragment() {

    companion object {
        fun newInstance() = GuessCardsPlayFragment()
    }

    private lateinit var viewModel: GuessCardsPlayViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_guess_cards_play, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(GuessCardsPlayViewModel::class.java)
        // TODO: Use the ViewModel
    }

}