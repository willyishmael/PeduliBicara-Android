package com.pedulibicara.pedulibicara.ui.auth

import androidx.lifecycle.ViewModel
import com.pedulibicara.pedulibicara.data.repository.DataRepository

class PickGenderViewModel : ViewModel() {
    private val repository = DataRepository()
    fun getGender() = repository.getGender()
}