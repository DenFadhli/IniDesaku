package com.citiasia.inidesakubeta.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.citiasia.inidesakubeta.ui.sign.login.LoginViewModel
import com.citiasia.inidesakubeta.ui.sign.signUp.CompleteProfileViewModel
import com.citiasia.inidesakubeta.ui.sign.signUp.SignUpViewModel
import com.citiasia.inidesakubeta.ui.pasar_desa.PasarDesaViewModel

class ViewModelFactorySign private constructor(private val mApplication: Application) : ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var INSTANCE: ViewModelFactorySign? = null

        @JvmStatic
        fun getInstance(application: Application): ViewModelFactorySign {
            if (INSTANCE == null) {
                synchronized(ViewModelFactorySign::class.java) {
                    INSTANCE = ViewModelFactorySign(application)
                }
            }
            return INSTANCE as ViewModelFactorySign
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SignUpViewModel::class.java)) {
            return SignUpViewModel(mApplication) as T
        }
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(mApplication) as T
        }
        if (modelClass.isAssignableFrom(CompleteProfileViewModel::class.java)) {
            return CompleteProfileViewModel(mApplication) as T
        }
        if (modelClass.isAssignableFrom(PasarDesaViewModel::class.java)) {
            return PasarDesaViewModel(mApplication) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}