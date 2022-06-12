package com.pedulibicara.pedulibicara.data.remote.retrofit

import com.pedulibicara.pedulibicara.data.remote.response.AuthResponse
import com.pedulibicara.pedulibicara.data.remote.response.ModelResponse
import okhttp3.MultipartBody
import retrofit2.http.*

interface ApiService {

    /**
     * Call the API to handle login
     *
     * @param email User's email
     * @param password User's password
     */
    @FormUrlEncoded
    @POST("login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): AuthResponse

    /**
     * Call the API to handle registration to create new account
     *
     * @param parentName Child's parent name
     * @param name Child's name
     * @param email User's email
     * @param password User's password
     */
    @FormUrlEncoded
    @POST("register")
    suspend fun register(
        @Field("ortuname") parentName: String,
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): AuthResponse

    /**
     * Call the API to handle voice prediction
     *
     * @param file Recorded voice to predict
     */
    @Multipart
    @POST("model")
    suspend fun predict(
        @Part file: MultipartBody.Part
    ): ModelResponse

}