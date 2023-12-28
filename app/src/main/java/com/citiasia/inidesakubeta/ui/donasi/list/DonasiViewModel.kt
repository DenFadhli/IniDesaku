package com.citiasia.inidesakubeta.ui.donasi.list

import androidx.lifecycle.ViewModel
import com.citiasia.inidesakubeta.data.remote.model.ResponseDonasi
import com.citiasia.inidesakubeta.data.repo.FiturRepository

class DonasiViewModel(private val repository: FiturRepository) : ViewModel() {
    fun getDonasiList(): List<ResponseDonasi>{
        return repository.getDonasi()
    }
}