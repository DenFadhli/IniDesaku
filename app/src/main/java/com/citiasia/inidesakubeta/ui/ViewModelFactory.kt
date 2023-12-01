package com.citiasia.inidesakubeta.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.citiasia.inidesakubeta.di.Injection
import com.citiasia.inidesakubeta.ui.sign.login.LoginViewModel
import com.citiasia.inidesakubeta.ui.tvcc.tvccDetail.TvccDetailViewModel
import com.citiasia.inidesakubeta.ui.tvcc.tvccHome.TvccFrontViewModel

class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return LoginViewModel(Injection.provideLoginRepo(context)) as T
        }
        if (modelClass.isAssignableFrom(TvccFrontViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TvccFrontViewModel(Injection.provideFiturnRepo(context)) as T
        }
        if (modelClass.isAssignableFrom(TvccDetailViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TvccDetailViewModel(Injection.provideFiturnRepo(context)) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}