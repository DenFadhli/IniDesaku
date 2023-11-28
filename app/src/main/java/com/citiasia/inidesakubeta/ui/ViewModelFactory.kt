package com.citiasia.inidesakubeta.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.citiasia.inidesakubeta.di.Injection
import com.citiasia.inidesakubeta.ui.sign.login.LoginViewModel

class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return LoginViewModel(Injection.provideLoginRepo(context)) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}