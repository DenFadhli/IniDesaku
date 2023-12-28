package com.citiasia.inidesakubeta.ui.desa.pelatihan_desa.list

import androidx.lifecycle.ViewModel
import com.citiasia.inidesakubeta.data.remote.model.ResponsePelatihan
import com.citiasia.inidesakubeta.data.repo.FiturRepository

class PelatihanDesaViewModel(private val repository: FiturRepository) : ViewModel()  {
    fun getPelatihanList(): List<ResponsePelatihan>{
        return repository.getPelatihan()
    }
}