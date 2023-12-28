package com.citiasia.inidesakubeta.ui.sign.login

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.citiasia.inidesakubeta.data.database.User
import com.citiasia.inidesakubeta.data.repo.SignUpRepository

class LoginViewModel(application: Application) : ViewModel() {

    private val mSignUpRepository: SignUpRepository = SignUpRepository(application)

    fun loginUser(username: String, email: String, password: String, callback: (Boolean) -> Unit) {
        mSignUpRepository.getUserLogin(username, email, password).observeForever { user ->
            callback(user != null)
        }
    }

    fun getUserByUsernameAndEmail(username: String, email: String): LiveData<User?> {
        return mSignUpRepository.getUserByUsernameAndEmail(username, email)
    }
}