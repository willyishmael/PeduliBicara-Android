package com.pedulibicara.pedulibicara.data.local

import com.pedulibicara.pedulibicara.R
import com.pedulibicara.pedulibicara.data.model.ModuleCategory
import com.pedulibicara.pedulibicara.data.model.MenuCategory
import com.pedulibicara.pedulibicara.data.model.ModuleItem
import com.pedulibicara.pedulibicara.utils.Strings

object Data {

    fun getModuleCategory() : List<ModuleCategory> {
        return listOf(
            ModuleCategory(
                0,
                Strings.get(R.string.body_parts),
                Strings.get(R.string.body_parts_description),
                MODULE_BODY_PARTS
            ),
            ModuleCategory(
                0,
                Strings.get(R.string.food),
                Strings.get(R.string.food_description),
                MODULE_FOOD
            ),
            ModuleCategory(
                0,
                Strings.get(R.string.animals),
                Strings.get(R.string.animals_description),
                MODULE_ANIMALS
            )
        )
    }

    fun getMenuCategory() : Map<String, MenuCategory> {
        return mapOf(
            MENU_MODULE to MenuCategory(
                0,
                Strings.get(R.string.module),
                Strings.get(R.string.module_description)
            ),
            MENU_GUESS_CARD to MenuCategory(
                0,
                Strings.get(R.string.guess_card),
                Strings.get(R.string.guess_card_description)
            ),
            MENU_GUESS_VOICE to MenuCategory(
                0,
                Strings.get(R.string.guess_voice),
                Strings.get(R.string.guess_voice_description)
            )
        )
    }

    fun getModuleItem(category: String) : List<ModuleItem> {
        val listModuleItem = mutableListOf<ModuleItem>()

        for (item in getAllModuleItem()) {
            if (item.category == category) {
                listModuleItem.add(item)
            }
        }

        return listModuleItem
    }

    fun getAllModuleItem() = listOf(
        ModuleItem(
            MODULE_BODY_PARTS,
            Strings.get(R.string.head),
            0,
            0
        ),
        ModuleItem(
            MODULE_BODY_PARTS,
            Strings.get(R.string.lips),
            0,
            0
        ),
        ModuleItem(
            MODULE_BODY_PARTS,
            Strings.get(R.string.nose),
            0,
            0
        ),
        ModuleItem(
            MODULE_BODY_PARTS,
            Strings.get(R.string.eyes),
            0,
            0
        ),

    )

    const val MENU_MODULE = "menu_module"
    const val MENU_GUESS_CARD = "menu_guess_card"
    const val MENU_GUESS_VOICE = "menu_guess_voice"

    const val MODULE_BODY_PARTS = "module_body_parts"
    const val MODULE_FOOD = "module_food"
    const val MODULE_ANIMALS = "module_animals"
}