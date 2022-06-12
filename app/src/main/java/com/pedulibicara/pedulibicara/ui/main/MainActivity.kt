package com.pedulibicara.pedulibicara.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.pedulibicara.pedulibicara.data.local.Data
import com.pedulibicara.pedulibicara.data.model.MenuCategory
import com.pedulibicara.pedulibicara.databinding.ActivityMainBinding
import com.pedulibicara.pedulibicara.databinding.ModuleCardViewBinding
import com.pedulibicara.pedulibicara.ui.guesscards.GuessCardsActivity
import com.pedulibicara.pedulibicara.ui.guessvoice.GuessVoiceActivity
import com.pedulibicara.pedulibicara.ui.module.ModuleActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mapMenuCategory: Map<String, MenuCategory>

    private val viewModel by viewModels<MainViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        mapMenuCategory = viewModel.getMenuCategory()

        setupLayout()
        setupActions()
    }

    private fun setupLayout() {
        binding.apply {
            setupModuleCard(Data.MENU_MODULE, mcModule)
            setupModuleCard(Data.MENU_GUESS_CARD, mcGuessCard)
            setupModuleCard(Data.MENU_GUESS_VOICE, mcGuessVoice)
        }
    }

    private fun setupModuleCard(mapKey: String, moduleCard: ModuleCardViewBinding) {
        val category = mapMenuCategory[mapKey]
        if (category != null) {
            Glide.with(this@MainActivity)
                .load(category.thumbnail)
                .apply(RequestOptions().override(100, 100))
                .into(moduleCard.ivModuleImage)
            moduleCard.tvModuleTitle.text = category.title
            moduleCard.tvModuleDescription.text = category.description
        }
    }

    private fun setupActions() {
        binding.apply {

            mcModule.mcContainer.setOnClickListener {
                Intent(this@MainActivity, ModuleActivity::class.java).also { intent ->
                    startActivity(intent)
                }
            }

            mcGuessCard.mcContainer.setOnClickListener {
                Intent(this@MainActivity, GuessCardsActivity::class.java).also { intent ->
                    startActivity(intent)
                }
            }

            mcGuessVoice.mcContainer.setOnClickListener {
                Intent(this@MainActivity, GuessVoiceActivity::class.java).also { intent ->
                    startActivity(intent)
                }
            }

        }
    }
}