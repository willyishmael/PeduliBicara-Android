package com.pedulibicara.pedulibicara.data.local

import com.pedulibicara.pedulibicara.R
import com.pedulibicara.pedulibicara.data.model.Gender
import com.pedulibicara.pedulibicara.data.model.ModuleCategory
import com.pedulibicara.pedulibicara.data.model.MenuCategory
import com.pedulibicara.pedulibicara.data.model.ModuleItem
import com.pedulibicara.pedulibicara.utils.Strings

object Data {

    fun getGender() : List<Gender> {
        return listOf(
            Gender(
                Strings.get(R.string.boy),
                R.drawable.img_boy
            ),
            Gender(
                Strings.get(R.string.girl),
                R.drawable.img_girl
            )
        )
    }

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
            image = R.drawable.img_sole,
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
            image = R.drawable.img_cheek,
            sound = R.raw.snd_cheek
        ),
        ModuleItem(
            category = MODULE_BODY_PARTS,
            name = Strings.get(R.string.waist),
            image = R.drawable.img_waist,
            sound = R.raw.snd_waist
        ),
        ModuleItem(
            category = MODULE_BODY_PARTS,
            name = Strings.get(R.string.belly),
            image = R.drawable.img_belly,
            sound = R.raw.snd_belly
        ),
        ModuleItem(
            category = MODULE_BODY_PARTS,
            name = Strings.get(R.string.mouth),
            image = R.drawable.img_mouth,
            sound = R.raw.snd_mouth
        ),
        ModuleItem(
            category = MODULE_BODY_PARTS,
            name = Strings.get(R.string.knee),
            image = R.drawable.img_knee,
            sound = R.raw.snd_knee
        ),
        ModuleItem(
            category = MODULE_BODY_PARTS,
            name = Strings.get(R.string.tongue),
            image = R.drawable.img_tongue,
            sound = R.raw.snd_tongue
        ),
        ModuleItem(
            category = MODULE_BODY_PARTS,
            name = Strings.get(R.string.arm),
            image = R.drawable.img_arm,
            sound = R.raw.snd_arm
        ),
        ModuleItem(
            category = MODULE_BODY_PARTS,
            name = Strings.get(R.string.nail),
            image = R.drawable.img_nail,
            sound = R.raw.snd_nail
        ),
        ModuleItem(
            category = MODULE_BODY_PARTS,
            name = Strings.get(R.string.leg),
            image = R.drawable.img_leg,
            sound = R.raw.snd_leg
        ),
        ModuleItem(
            category = MODULE_BODY_PARTS,
            name = Strings.get(R.string.fingers),
            image = R.drawable.img_fingers,
            sound = R.raw.snd_finger
        ),
        ModuleItem(
            category = MODULE_BODY_PARTS,
            name = Strings.get(R.string.forehead),
            image = R.drawable.img_forehead,
            sound = R.raw.snd_forehead
        ),
        ModuleItem(
            category = MODULE_FOOD,
            name = Strings.get(R.string.fried_rice),
            image = R.drawable.img_fried_rice,
            sound = R.raw.snd_fried_rice
        ),
        ModuleItem(
            category = MODULE_FOOD,
            name = Strings.get(R.string.cake),
            image = R.drawable.img_cake,
            sound = R.raw.snd_cake,
        ),
        ModuleItem(
            category = MODULE_FOOD,
            name = Strings.get(R.string.fried_chicken),
            image = R.drawable.img_chicken,
            sound = R.raw.snd_fried_chicken,
        ),
        ModuleItem(
            category = MODULE_FOOD,
            name = Strings.get(R.string.ice_cream),
            image = R.drawable.img_ice_cream,
            sound = R.raw.snd_ice_cream
        ),
        ModuleItem(
            category = MODULE_FOOD,
            name = Strings.get(R.string.cheese),
            image = R.drawable.img_chesee,
            sound = R.raw.snd_cheese
        ),
        ModuleItem(
            category = MODULE_FOOD,
            name = Strings.get(R.string.rice),
            image = R.drawable.img_rice,
            sound = R.raw.snd_rice
        ),
        ModuleItem(
            category = MODULE_FOOD,
            name = Strings.get(R.string.pudding),
            image = R.drawable.img_pudding,
            sound = R.raw.snd_pudding
        ),
        ModuleItem(
            category = MODULE_FOOD,
            name = Strings.get(R.string.milk),
            image = R.drawable.img_milk,
            sound = R.raw.snd_milk
        ),
        ModuleItem(
            category = MODULE_FOOD,
            name = Strings.get(R.string.sausage),
            image = R.drawable.img_sausage,
            sound = R.raw.snd_sausage
        ),
        ModuleItem(
            category = MODULE_FOOD,
            name = Strings.get(R.string.lettuce),
            image = R.drawable.img_lettuce,
            sound = R.raw.snd_lettuce
        ),
        ModuleItem(
            category = MODULE_FOOD,
            name = Strings.get(R.string.donut),
            image = R.drawable.img_donut,
            sound = R.raw.snd_donut
        ),
        ModuleItem(
            category = MODULE_FOOD,
            name = Strings.get(R.string.bread),
            image = R.drawable.img_bread,
            sound = R.raw.snd_bread
        ),
        ModuleItem(
            category = MODULE_FOOD,
            name = Strings.get(R.string.satay),
            image = R.drawable.img_satay,
            sound = R.raw.snd_satay
        ),
        ModuleItem(
            category = MODULE_FOOD,
            name = Strings.get(R.string.mellon),
            image = R.drawable.img_mellon,
            sound = R.raw.snd_melon
        ),
        ModuleItem(
            category = MODULE_FOOD,
            name = Strings.get(R.string.banana),
            image = R.drawable.img_banana,
            sound = R.raw.snd_banana
        ),
        ModuleItem(
            category = MODULE_FOOD,
            name = Strings.get(R.string.watermelon),
            image = R.drawable.img_watermellon,
            sound = R.raw.snd_watermelon
        ),
        ModuleItem(
            category = MODULE_FOOD,
            name = Strings.get(R.string.apple),
            image = R.drawable.img_apple,
            sound = R.raw.snd_apple
        ),
        ModuleItem(
            category = MODULE_FOOD,
            name = Strings.get(R.string.pineapple),
            image = R.drawable.img_pineapple,
            sound = R.raw.snd_pineapple
        ),
        ModuleItem(
            category = MODULE_FOOD,
            name = Strings.get(R.string.orange),
            image = R.drawable.img_orange,
            sound = R.raw.snd_orange
        ),
        ModuleItem(
            category = MODULE_FOOD,
            name = Strings.get(R.string.grape),
            image = R.drawable.img_grape,
            sound = R.raw.snd_grape
        ),
        ModuleItem(
            category = MODULE_FOOD,
            name = Strings.get(R.string.mango),
            image = R.drawable.img_mango,
            sound = R.raw.snd_mango
        ),
        ModuleItem(
            category = MODULE_FOOD,
            name = Strings.get(R.string.cereal),
            image = R.drawable.img_cereal,
            sound = R.raw.snd_cereal
        ),
        ModuleItem(
            category = MODULE_FOOD,
            name = Strings.get(R.string.porridge),
            image = R.drawable.img_poridge,
            sound = R.raw.snd_porridge
        ),
        ModuleItem(
            category = MODULE_FOOD,
            name = Strings.get(R.string.egg),
            image = R.drawable.img_egg,
            sound = R.raw.snd_egg
        ),
        ModuleItem(
            category = MODULE_FOOD,
            name = Strings.get(R.string.papaya),
            image = R.drawable.img_papaya,
            sound = R.raw.snd_papaya
        ),
        ModuleItem(
            category = MODULE_ANIMALS,
            name = Strings.get(R.string.crocodile),
            image = R.drawable.img_crocodile,
            sound = R.raw.snd_crocodile
        ),
        ModuleItem(
            category = MODULE_ANIMALS,
            name = Strings.get(R.string.bird),
            image = R.drawable.img_bird,
            sound = R.raw.snd_bird
        ),
        ModuleItem(
            category = MODULE_ANIMALS,
            name = Strings.get(R.string.elephant),
            image = R.drawable.img_elephant,
            sound = R.raw.snd_elephant
        ),
        ModuleItem(
            category = MODULE_ANIMALS,
            name = Strings.get(R.string.tiger),
            image = R.drawable.img_tiger,
            sound = R.raw.snd_tiger
        ),
        ModuleItem(
            category = MODULE_ANIMALS,
            name = Strings.get(R.string.giraffe),
            image = R.drawable.img_giraffe,
            sound = R.raw.snd_giraffe
        ),
        ModuleItem(
            category = MODULE_ANIMALS,
            name = Strings.get(R.string.turtle),
            image = R.drawable.img_turtle,
            sound = R.raw.snd_turtle
        ),
        ModuleItem(
            category = MODULE_ANIMALS,
            name = Strings.get(R.string.monkey),
            image = R.drawable.img_monkey,
            sound = R.raw.snd_monkey
        ),
        ModuleItem(
            category = MODULE_ANIMALS,
            name = Strings.get(R.string.panda),
            image = R.drawable.img_monkey,
            sound = R.raw.snd_panda
        ),
        ModuleItem(
            category = MODULE_ANIMALS,
            name = Strings.get(R.string.penguin),
            image = R.drawable.img_pinguin,
            sound = R.raw.snd_penguin
        ),
        ModuleItem(
            category = MODULE_ANIMALS,
            name = Strings.get(R.string.deer),
            image = R.drawable.img_deer,
            sound = R.raw.snd_deer
        ),
        ModuleItem(
            category = MODULE_ANIMALS,
            name = Strings.get(R.string.cow),
            image = R.drawable.img_cow,
            sound = R.raw.snd_cow
        ),
        ModuleItem(
            category = MODULE_ANIMALS,
            name = Strings.get(R.string.lion),
            image = R.drawable.img_lion,
            sound = R.raw.snd_lion
        ),
        ModuleItem(
            category = MODULE_ANIMALS,
            name = Strings.get(R.string.zebra),
            image = R.drawable.img_zebra,
            sound = R.raw.snd_zebra
        ),
        ModuleItem(
            category = MODULE_ANIMALS,
            name = Strings.get(R.string.cat),
            image = R.drawable.img_cat,
            sound = R.raw.snd_cat
        ),
        ModuleItem(
            category = MODULE_ANIMALS,
            name = Strings.get(R.string.dog),
            image = R.drawable.img_dog,
            sound = R.raw.snd_dog
        ),
        ModuleItem(
            category = MODULE_ANIMALS,
            name = Strings.get(R.string.chicken),
            image = R.drawable.img_chicken,
            sound = R.raw.snd_chicken
        ),
        ModuleItem(
            category = MODULE_ANIMALS,
            name = Strings.get(R.string.goat),
            image = R.drawable.img_goat,
            sound = R.raw.snd_goat
        ),
        ModuleItem(
            category = MODULE_ANIMALS,
            name = Strings.get(R.string.rabbit),
            image = R.drawable.img_rabbit,
            sound = R.raw.snd_rabbit
        ),
        ModuleItem(
            category = MODULE_ANIMALS,
            name = Strings.get(R.string.kangaroo),
            image = R.drawable.img_kangaroo,
            sound = R.raw.snd_kangaroo
        ),
        ModuleItem(
            category = MODULE_ANIMALS,
            name = Strings.get(R.string.mosquito),
            image = R.drawable.img_mosquito,
            sound = R.raw.snd_mosquito
        ),
        ModuleItem(
            category = MODULE_ANIMALS,
            name = Strings.get(R.string.ant),
            image = R.drawable.img_ant,
            sound = R.raw.snd_ant
        ),
        ModuleItem(
            category = MODULE_ANIMALS,
            name = Strings.get(R.string.butterfly),
            image = R.drawable.img_butterfly,
            sound = R.raw.snd_butterfly
        ),
        ModuleItem(
            category = MODULE_ANIMALS,
            name = Strings.get(R.string.crab),
            image = R.drawable.img_crab,
            sound = R.raw.snd_crab
        ),
        ModuleItem(
            category = MODULE_ANIMALS,
            name = Strings.get(R.string.fish),
            image = R.drawable.img_fish,
            sound = R.raw.snd_fish
        ),
        ModuleItem(
            category = MODULE_ANIMALS,
            name = Strings.get(R.string.jellyfish),
            image = R.drawable.img_jellyfish,
            sound = R.raw.snd_jellyfish
        ),
        ModuleItem(
            category = MODULE_ANIMALS,
            name = Strings.get(R.string.lizard),
            image = R.drawable.img_lizard,
            sound = R.raw.snd_lizard
        ),
        ModuleItem(
            category = MODULE_ANIMALS,
            name = Strings.get(R.string.duck),
            image = R.drawable.img_duck,
            sound = R.raw.snd_duck
        )
    )

    const val MENU_MODULE = "menu_module"
    const val MENU_GUESS_CARD = "menu_guess_card"
    const val MENU_GUESS_VOICE = "menu_guess_voice"
    const val MODULE_BODY_PARTS = "module_body_parts"
    const val MODULE_FOOD = "module_food"
    const val MODULE_ANIMALS = "module_animals"
}