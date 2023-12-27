package com.citiasia.inidesakubeta.ui.desa.penyuluhan_desa.list

import androidx.lifecycle.ViewModel
import com.citiasia.inidesakubeta.data.remote.model.ResponsePenyuluhan
import com.citiasia.inidesakubeta.data.repo.FiturRepository

class PenyuluhanDesaViewModel(private val repository: FiturRepository) : ViewModel()  {
    fun getPenyuluhanList(): List<ResponsePenyuluhan>{
        return repository.getPenyuluhan()
    }
}