package com.pedulibicara.pedulibicara.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ModuleItem(
    val category: String = "",
    val name: String = "",
    val image: Int = 0,
    val sound: Int= 0,
) : Parcelable