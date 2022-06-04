package com.pedulibicara.pedulibicara.ui.main

import androidx.lifecycle.ViewModel
import com.pedulibicara.pedulibicara.data.repository.DataRepository

class MainViewModel: ViewModel() {
    private val repository = DataRepository()
    fun getMenuCategory() = repository.getMenuCategory()
}