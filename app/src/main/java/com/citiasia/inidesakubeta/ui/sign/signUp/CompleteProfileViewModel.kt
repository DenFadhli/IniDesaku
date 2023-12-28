package com.citiasia.inidesakubeta.ui.sign.signUp

import android.app.Application
import androidx.lifecycle.ViewModel
import com.citiasia.inidesakubeta.data.database.User
import com.citiasia.inidesakubeta.data.repo.SignUpRepository

class CompleteProfileViewModel(application: Application) : ViewModel() {

    private val mSignUpRepository: SignUpRepository = SignUpRepository(application)

    fun insertUser(user: User) {
        mSignUpRepository.signUpUser(user)
    }

    fun checkEmailExists(phoneNumber: String, callback: (Boolean) -> Unit) {
        mSignUpRepository.checkEmailExists(phoneNumber) { exists ->
            callback(exists)
        }
    }
}