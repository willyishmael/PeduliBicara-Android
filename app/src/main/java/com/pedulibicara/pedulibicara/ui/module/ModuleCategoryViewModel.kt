package com.pedulibicara.pedulibicara.ui.module

import androidx.lifecycle.ViewModel
import com.pedulibicara.pedulibicara.data.repository.DataRepository

class ModuleCategoryViewModel : ViewModel() {
    private val repository = DataRepository()
    fun getModuleCategory() = repository.getModuleCategory()
}