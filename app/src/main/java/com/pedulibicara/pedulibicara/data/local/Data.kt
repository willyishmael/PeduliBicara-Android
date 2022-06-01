package com.pedulibicara.pedulibicara.data.local

import android.content.Context
import com.pedulibicara.pedulibicara.R
import com.pedulibicara.pedulibicara.data.model.Category

object Data {

    fun getModuleCategory(context: Context?) : List<Category> {
        return if (context != null) {
            listOf(
                Category(
                    0,
                    context.getString(R.string.body_parts),
                    context.getString(R.string.body_parts_description)
                ),
                Category(
                    0,
                    context.getString(R.string.food),
                    context.getString(R.string.food_description)
                ),
                Category(
                    0,
                    context.getString(R.string.animals),
                    context.getString(R.string.animals_description)
                )
            )
        } else {
            return emptyList()
        }
    }

    fun getMenuCategory(context: Context?) : Map<String, Category> {
        return if (context != null) {
            mapOf(
                MENU_MODULE to Category(
                    0,
                    context.getString(R.string.module),
                    context.getString(R.string.module_description)
                ),
                MENU_GUESS_CARD to Category(
                    0,
                    context.getString(R.string.guess_card),
                    context.getString(R.string.guess_card_description)
                ),
                MENU_GUESS_VOICE to Category(
                    0,
                    context.getString(R.string.guess_voice),
                    context.getString(R.string.guess_voice_description)
                )
            )
        } else {
            emptyMap()
        }

    }

    const val MENU_MODULE = "menu_module"
    const val MENU_GUESS_CARD = "menu_guess_card"
    const val MENU_GUESS_VOICE = "menu_guess_voice"
}