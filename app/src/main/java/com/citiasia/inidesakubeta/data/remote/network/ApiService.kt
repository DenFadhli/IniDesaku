package com.citiasia.inidesakubeta.data.remote.network


import com.citiasia.inidesakubeta.data.remote.model.LoginResponse
import okhttp3.MultipartBody
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ApiService {

    @Multipart
    @POST("/login")
    suspend fun login(
        @Part("email") email: String,
        @Part("password") password: String
    ) : LoginResponse
}