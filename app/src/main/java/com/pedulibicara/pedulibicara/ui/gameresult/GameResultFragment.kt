package com.pedulibicara.pedulibicara.ui.gameresult

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pedulibicara.pedulibicara.R

class GameResultFragment : Fragment() {

    companion object {
        fun newInstance() = GameResultFragment()
    }

    private lateinit var viewModel: GameResultViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_game_result, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(GameResultViewModel::class.java)
        // TODO: Use the ViewModel
    }

}