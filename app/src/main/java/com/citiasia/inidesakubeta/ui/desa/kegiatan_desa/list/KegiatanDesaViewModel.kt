package com.citiasia.inidesakubeta.ui.desa.kegiatan_desa.list

import androidx.lifecycle.ViewModel
import com.citiasia.inidesakubeta.data.remote.model.ResponseKegiatanDesa
import com.citiasia.inidesakubeta.data.repo.FiturRepository

class KegiatanDesaViewModel(private val repository: FiturRepository) : ViewModel()  {
    fun getKegiatanList() : List<ResponseKegiatanDesa>{
        return repository.getKegiatan()
    }
}