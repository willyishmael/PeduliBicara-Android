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
                thumbnail = R.drawable.img_module_body_parts,
                title = Strings.get(R.string.body_parts),
                description = Strings.get(R.string.body_parts_description),
                key = MODULE_BODY_PARTS
            ),
            ModuleCategory(
                thumbnail = R.drawable.img_module_food,
                title = Strings.get(R.string.food),
                description = Strings.get(R.string.food_description),
                key = MODULE_FOOD
            ),
            ModuleCategory(
                thumbnail = R.drawable.img_module_animals,
                title = Strings.get(R.string.animals),
                description = Strings.get(R.string.animals_description),
                key = MODULE_ANIMALS
            )
        )
    }

    fun getMenuCategory() : Map<String, MenuCategory> {
        return mapOf(
            MENU_MODULE to MenuCategory(
                thumbnail = R.drawable.img_module,
                title = Strings.get(R.string.module),
                description = Strings.get(R.string.module_description)
            ),
            MENU_GUESS_CARD to MenuCategory(
                thumbnail = R.drawable.img_guess_card,
                title = Strings.get(R.string.guess_card),
                description = Strings.get(R.string.guess_card_description)
            ),
            MENU_GUESS_VOICE to MenuCategory(
                thumbnail = R.drawable.img_guess_voice,
                title = Strings.get(R.string.guess_voice),
                description = Strings.get(R.string.guess_voice_description)
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

    fun getAllModuleItem() : List<ModuleItem> = listOf(
        ModuleItem(
            category = MODULE_BODY_PARTS,
            name = Strings.get(R.string.head),
            image = R.drawable.img_head,
            sound = R.raw.snd_head
        ),
        ModuleItem(
            category = MODULE_BODY_PARTS,
            name = Strings.get(R.string.lips),
            image = R.drawable.img_lips,
            sound = R.raw.snd_lips
        ),
        ModuleItem(
            category = MODULE_BODY_PARTS,
            name = Strings.get(R.string.nose),
            image = R.drawable.img_nose,
            sound = R.raw.snd_nose
        ),
        ModuleItem(
            category = MODULE_BODY_PARTS,
            name = Strings.get(R.string.eyes),
            image = 0,
            sound = 0
        ),
        ModuleItem(
            MODULE_BODY_PARTS,
            Strings.get(R.string.ear),
            0,
            0
        ),
        ModuleItem(
            MODULE_BODY_PARTS,
            Strings.get(R.string.sole),
            0,
            0
        ),
        ModuleItem(
            MODULE_BODY_PARTS,
            Strings.get(R.string.hand),
            0,
            0
        ),
        ModuleItem(
            MODULE_BODY_PARTS,
            Strings.get(R.string.hair),
            0,
            0
        ),
        ModuleItem(
            MODULE_BODY_PARTS,
            Strings.get(R.string.shoulders),
            0,
            0
        ),
        ModuleItem(
            MODULE_BODY_PARTS,
            Strings.get(R.string.cheek),
            0,
            0
        ),
        ModuleItem(
            MODULE_BODY_PARTS,
            Strings.get(R.string.waist),
            0,
            0
        ),
        ModuleItem(
            MODULE_BODY_PARTS,
            Strings.get(R.string.belly),
            0,
            0
        ),
        ModuleItem(
            MODULE_BODY_PARTS,
            Strings.get(R.string.mouth),
            0,
            0
        ),
        ModuleItem(
            MODULE_BODY_PARTS,
            Strings.get(R.string.knee),
            0,
            0
        ),
        ModuleItem(
            MODULE_BODY_PARTS,
            Strings.get(R.string.tongue),
            0,
            0
        ),
        ModuleItem(
            MODULE_BODY_PARTS,
            Strings.get(R.string.arm),
            0,
            0
        ),
        ModuleItem(
            MODULE_BODY_PARTS,
            Strings.get(R.string.nail),
            0,
            0
        ),
        ModuleItem(
            MODULE_BODY_PARTS,
            Strings.get(R.string.leg),
            0,
            0
        ),
        ModuleItem(
            MODULE_BODY_PARTS,
            Strings.get(R.string.fingers),
            0,
            0
        ),
        ModuleItem(
            MODULE_BODY_PARTS,
            Strings.get(R.string.forehead),
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