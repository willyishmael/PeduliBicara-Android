package com.pedulibicara.pedulibicara.ui.guesscards

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.pedulibicara.pedulibicara.databinding.FragmentGuessCardsPlayBinding

class GuessCardsPlayFragment : Fragment() {

    private val viewModel by viewModels<GuessCardsPlayViewModel>()

    private var _binding: FragmentGuessCardsPlayBinding? = null
    private val binding get() = _binding!!

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

        
    }

}