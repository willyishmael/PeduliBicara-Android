package com.pedulibicara.pedulibicara.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.pedulibicara.pedulibicara.databinding.FragmentPickGenderBinding

class PickGenderFragment : Fragment() {

    private val viewModel by viewModels<PickGenderViewModel>()

    private var _binding: FragmentPickGenderBinding? = null
    private val binding get() = _binding!!
    private var selectedGender = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPickGenderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()
        setupButtons()
    }

    private fun setupView() {
        val gender = viewModel.getGender()
        binding.apply {
            Glide.with(requireActivity())
                .load(gender[0].image)
                .into(gvBoy.ivGenderImage)
            gvBoy.tvGender.text = gender[0].gender
            Glide.with(requireActivity())
                .load(gender[1].image)
                .into(gvGirl.ivGenderImage)
            gvGirl.tvGender.text = gender[1].gender
        }
    }

    private fun setupButtons() {
        binding.apply {
            gvBoy.container.setOnClickListener {
                gvBoy.ivSelected.visibility = View.VISIBLE
                gvGirl.ivSelected.visibility = View.GONE
                selectedGender = BOY
            }
            gvGirl.container.setOnClickListener {
                gvGirl.ivSelected.visibility = View.VISIBLE
                gvBoy.ivSelected.visibility = View.GONE
                selectedGender = GIRL
            }
        }
    }

    companion object {
        private const val BOY = "boy"
        private const val GIRL = "girl"
    }
}