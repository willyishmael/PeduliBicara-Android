package com.pedulibicara.pedulibicara.data.repository

import com.pedulibicara.pedulibicara.data.remote.response.AuthResponse
import com.pedulibicara.pedulibicara.data.remote.retrofit.ApiConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class AuthRepository {
    private val apiService = ApiConfig.getApiService()

    suspend fun login(email: String, password: String): Flow<Result<AuthResponse>> = flow {
        try {
            val response = apiService.login(email, password)
            emit(Result.success(response))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(Result.failure(e))
        }
    }.flowOn(Dispatchers.IO)

    suspend fun register(
        parentName: String,
        name: String,
        email: String,
        password: String
    ): Flow<Result<AuthResponse>> = flow {
        try {
            val response = apiService.register(parentName, name, email, password)
            emit(Result.success(response))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(Result.failure(e))
        }
    }
}