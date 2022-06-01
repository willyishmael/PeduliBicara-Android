package com.pedulibicara.pedulibicara.data.local

import android.content.Context
import android.content.res.Resources
import com.pedulibicara.pedulibicara.R
import com.pedulibicara.pedulibicara.data.model.Category

object Data {

    private val resources = Resources.getSystem()

    fun getModuleCategory() : List<Category> {
        resources.apply {
            return listOf(
                Category(
                    0,
                    getString(R.string.body_parts),
                    getString(R.string.body_parts_description)
                ),
                Category(
                    0,
                    getString(R.string.food),
                    getString(R.string.food_description)
                ),
                Category(
                    0,
                    getString(R.string.animals),
                    getString(R.string.animals_description)
                )
            )
        }


    }

    fun getMenuCategory() : Map<String, Category> {
        resources.apply {
            return mapOf(
                MENU_MODULE to Category(
                    0,
                    getString(R.string.module),
                    getString(R.string.module_description)
                ),
                MENU_GUESS_CARD to Category(
                    0,
                    getString(R.string.guess_card),
                    getString(R.string.guess_card_description)
                ),
                MENU_GUESS_VOICE to Category(
                    0,
                    getString(R.string.guess_voice),
                    getString(R.string.guess_voice_description)
                )
            )

        }
    }

    const val MENU_MODULE = "menu_module"
    const val MENU_GUESS_CARD = "menu_guess_card"
    const val MENU_GUESS_VOICE = "menu_guess_voice"
}