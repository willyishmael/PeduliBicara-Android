package com.pedulibicara.pedulibicara.data.local

import android.content.Context
import com.pedulibicara.pedulibicara.R
import com.pedulibicara.pedulibicara.data.model.Category

object Data {

    fun getModuleCategory(context: Context?) : List<Category> {
        if (context != null) {
            return listOf(
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
}