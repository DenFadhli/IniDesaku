package com.citiasia.inidesakubeta.ui.desa.pelayanan_desa.list

import androidx.lifecycle.ViewModel
import com.citiasia.inidesakubeta.data.remote.model.ResponsePelayananDesa
import com.citiasia.inidesakubeta.data.repo.FiturRepository

class PelayananDesaViewModel(private val repository: FiturRepository): ViewModel() {
    fun getPelayanan(): List<ResponsePelayananDesa> {
        return repository.getPelayanan()
    }
}