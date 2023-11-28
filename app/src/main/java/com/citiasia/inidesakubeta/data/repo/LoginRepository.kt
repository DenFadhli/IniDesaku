package com.citiasia.inidesakubeta.data.repo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.citiasia.inidesakubeta.data.remote.model.LoginResponse
import com.citiasia.inidesakubeta.data.remote.network.ApiService

class LoginRepository(
    private val apiService: ApiService
) {

    fun login(
        email: String,
        password: String
    ) : LiveData<Resource<LoginResponse>> = liveData {
        emit(Resource.Loading)
        Log.i("Login Test email pass", "$email $password ")
        try {
            val response = apiService.login(
                email,
                password
            )

            if (response.error){
                emit(Resource.Error(response.message))
                Log.i("Login Test", "errorr ${response.message}")
            } else {
                emit(Resource.Success(response))
                Log.i("Login Test", "succsess ${response.message}")
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Log.i("Login Test exception print", "${e.printStackTrace()}")
            emit(Resource.Error(e.message.toString()))
            Log.i("Login Test exception", "exception ${e.message}")
            Log.i("Login Test email pass", "$email $password ")
        }
    }
}