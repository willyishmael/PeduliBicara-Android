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
            image = R.drawable.img_eye,
            sound = R.raw.snd_eye
        ),
        ModuleItem(
            category = MODULE_BODY_PARTS,
            name = Strings.get(R.string.ear),
            image = R.drawable.img_ear,
            sound = R.raw.snd_ear
        ),
        ModuleItem(
            category = MODULE_BODY_PARTS,
            name = Strings.get(R.string.foot),
            image = 0,
            sound = R.raw.snd_foot
        ),
        ModuleItem(
            category = MODULE_BODY_PARTS,
            name = Strings.get(R.string.hand),
            image = R.drawable.img_hand,
            sound = R.raw.snd_hand
        ),
        ModuleItem(
            category = MODULE_BODY_PARTS,
            name = Strings.get(R.string.hair),
            image = R.drawable.img_hair,
            sound = R.raw.snd_hair
        ),
        ModuleItem(
            category = MODULE_BODY_PARTS,
            name = Strings.get(R.string.shoulders),
            image = R.drawable.img_shoulders,
            sound = R.raw.snd_shoulders
        ),
        ModuleItem(
            category = MODULE_BODY_PARTS,
            name = Strings.get(R.string.cheek),
            image = 0,
            sound = 0
        ),
        ModuleItem(
            category = MODULE_BODY_PARTS,
            name = Strings.get(R.string.waist),
            image = 0,
            sound = 0
        ),
        ModuleItem(
            category = MODULE_BODY_PARTS,
            name = Strings.get(R.string.belly),
            image = 0,
            sound = 0
        ),
        ModuleItem(
            category = MODULE_BODY_PARTS,
            name = Strings.get(R.string.mouth),
            image = 0,
            sound = 0
        ),
        ModuleItem(
            category = MODULE_BODY_PARTS,
            name = Strings.get(R.string.knee),
            image = 0,
            sound = 0
        ),
        ModuleItem(
            category = MODULE_BODY_PARTS,
            name = Strings.get(R.string.tongue),
            image = 0,
            sound = 0
        ),
        ModuleItem(
            category = MODULE_BODY_PARTS,
            name = Strings.get(R.string.arm),
            image = 0,
            sound = 0
        ),
        ModuleItem(
            category = MODULE_BODY_PARTS,
            name = Strings.get(R.string.nail),
            image = 0,
            sound = 0
        ),
        ModuleItem(
            category = MODULE_BODY_PARTS,
            name = Strings.get(R.string.leg),
            image = 0,
            sound = 0
        ),
        ModuleItem(
            category = MODULE_BODY_PARTS,
            name = Strings.get(R.string.fingers),
            image = 0,
            sound = 0
        ),
        ModuleItem(
            category = MODULE_BODY_PARTS,
            name = Strings.get(R.string.forehead),
            image = 0,
            sound = 0
        ),

    )

    const val MENU_MODULE = "menu_module"
    const val MENU_GUESS_CARD = "menu_guess_card"
    const val MENU_GUESS_VOICE = "menu_guess_voice"
    const val MODULE_BODY_PARTS = "module_body_parts"
    const val MODULE_FOOD = "module_food"
    const val MODULE_ANIMALS = "module_animals"
}