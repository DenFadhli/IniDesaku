package com.citiasia.inidesakubeta.di

import android.content.Context
import com.citiasia.inidesakubeta.data.remote.network.ApiConfig
import com.citiasia.inidesakubeta.data.remote.network.ApiService
import com.citiasia.inidesakubeta.data.repo.FiturRepository
import com.citiasia.inidesakubeta.data.repo.LoginRepository
import com.citiasia.inidesakubeta.utils.PulsaPreference

object Injection {

    var tokenUser: String = "yGo59zsvIcmjcnqilQ7sNkoiCuevrclHpkaFDIxR9Ygvth92BwgQQl2rxIZG"

    fun setToken(context: Context) {
        val data = PulsaPreference(context).getData()
        tokenUser = data.provider!!
    }

    fun provideLoginRepo(context: Context) : LoginRepository{
        val service = ApiConfig.getApiService()
        return LoginRepository(service)
    }

    fun provideFiturnRepo(context: Context) : FiturRepository{
        return FiturRepository()
    }
}