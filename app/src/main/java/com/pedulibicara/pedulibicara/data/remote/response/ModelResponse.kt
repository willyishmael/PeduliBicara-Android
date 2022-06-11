package com.pedulibicara.pedulibicara.data.remote.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ModelResponse(
	val result: String,
	val error: Boolean,
	val message: String
) : Parcelable
