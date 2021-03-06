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
import com.pedulibicara.pedulibicara.R
import com.pedulibicara.pedulibicara.data.local.Data

class ModuleItemDetailFragment : Fragment() {

    private lateinit var mediaPlayer: MediaPlayer
    private var _binding: FragmentModuleItemDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
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

        (activity as AppCompatActivity).supportActionBar?.title = moduleItem.name

        binding.apply {
            Glide.with(requireContext())
                .load(moduleItem.image)
                .into(ivModuleItemImage)
            tvModuleItemName.text = moduleItem.name
            mediaPlayer = MediaPlayer.create(context, moduleItem.sound)

            tvModuleItemCategory.text = when (moduleItem.category) {
                Data.MODULE_BODY_PARTS -> getString(R.string.body_parts)
                Data.MODULE_FOOD -> getString(R.string.food)
                Data.MODULE_ANIMALS -> getString(R.string.animals)
                else -> ""
            }

            btnPlaySound.setOnClickListener {
                playSound()
            }
        }
    }

    private fun playSound() {
        try {
            if (mediaPlayer.isPlaying) mediaPlayer.stop()
            mediaPlayer.start()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}