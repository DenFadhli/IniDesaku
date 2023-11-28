package com.citiasia.inidesakubeta.ui.sign.login

import androidx.lifecycle.ViewModel
import com.citiasia.inidesakubeta.data.repo.LoginRepository

class LoginViewModel(
    private val repository: LoginRepository
) : ViewModel() {

    fun login(
        email: String,
        password: String
    ) = repository.login("rafli.gimnastiar@citiasiainc.id", "X7F1gtYDwv")
}