package com.pedulibicara.pedulibicara.ui.module

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.pedulibicara.pedulibicara.databinding.FragmentModuleItemDetailBinding
import androidx.appcompat.app.AppCompatActivity

class ModuleItemDetailFragment : Fragment() {

    private lateinit var soundPlayer: MediaPlayer
    private var _binding: FragmentModuleItemDetailBinding? = null
    private val binding get() = _binding!!

    @Suppress("RedundantNullableReturnType")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentModuleItemDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()
    }

    private fun setupView() {
        val moduleItem = ModuleItemDetailFragmentArgs
            .fromBundle(arguments as Bundle)
            .moduleItem
//        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
//        binding.titleToolbar.text = moduleItem.name
        (activity as AppCompatActivity).supportActionBar?.title = moduleItem.name

        binding.apply {
            Glide.with(requireContext())
                .load(moduleItem.image)
                .into(ivModuleItemImage)
            tvModuleItemName.text = moduleItem.name
            tvModuleItemCategory.text = moduleItem.category
            soundPlayer = MediaPlayer.create(context, moduleItem.sound)

            btnPlaySound.setOnClickListener {
                playSound()
            }
        }
    }

    private fun playSound() {
        if (soundPlayer.isPlaying) {
            soundPlayer.stop()
        }
        soundPlayer.start()
    }
}