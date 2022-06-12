package com.pedulibicara.pedulibicara.data.repository

import com.pedulibicara.pedulibicara.data.remote.response.ModelResponse
import com.pedulibicara.pedulibicara.data.remote.retrofit.ApiConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.MultipartBody

class ModelRepository {
    private val apiService = ApiConfig.getApiService()

    suspend fun predict(
        file: MultipartBody.Part
    ): Flow<Result<ModelResponse>> = flow {
        try {
            val response = apiService.predict(file)
            emit(Result.success(response))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(Result.failure(e))
        }
    }.flowOn(Dispatchers.IO)
}