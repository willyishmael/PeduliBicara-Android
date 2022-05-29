package com.pedulibicara.pedulibicara.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pedulibicara.pedulibicara.databinding.ActivityMainBinding
import com.pedulibicara.pedulibicara.ui.guesscards.GuessCardsActivity
import com.pedulibicara.pedulibicara.ui.guessvoice.GuessVoiceActivity
import com.pedulibicara.pedulibicara.ui.module.ModuleActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupActions()
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