package com.pedulibicara.pedulibicara.data.repository

import com.pedulibicara.pedulibicara.data.local.Data
import com.pedulibicara.pedulibicara.data.model.ModuleItem

class DataRepository {

    fun getModuleCategory() = Data.getModuleCategory()
    fun getMenuCategory() = Data.getMenuCategory()
    fun getAllModuleItem() = Data.getAllModuleItem()

    fun getModuleItems(category: String) : List<ModuleItem> {
        val listModuleItem = mutableListOf<ModuleItem>()

        for (item in Data.getAllModuleItem()) {
            if (item.category == category) {
                listModuleItem.add(item)
            }
        }

        return listModuleItem
    }

}