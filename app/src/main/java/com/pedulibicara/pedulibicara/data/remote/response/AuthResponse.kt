package com.pedulibicara.pedulibicara.data.remote.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AuthResponse(
	val result: Result,
	val error: Boolean,
	val message: String
) : Parcelable

@Parcelize
data class Result(
	val name: String,
	val email: String
) : Parcelable
