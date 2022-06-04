package com.pedulibicara.pedulibicara.ui.module

import androidx.lifecycle.ViewModel
import com.pedulibicara.pedulibicara.data.repository.DataRepository

class ModuleItemViewModel : ViewModel() {
    private val repository = DataRepository()
    fun getModuleItems(category: String) = repository.getModuleItems(category)
}