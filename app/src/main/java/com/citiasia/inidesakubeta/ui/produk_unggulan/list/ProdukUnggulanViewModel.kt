package com.citiasia.inidesakubeta.ui.produk_unggulan.list

import androidx.lifecycle.ViewModel
import com.citiasia.inidesakubeta.data.remote.model.ResponseProdukUnggulan
import com.citiasia.inidesakubeta.data.repo.FiturRepository

class ProdukUnggulanViewModel(private val repository: FiturRepository): ViewModel() {
    fun getProdukUnggulanData(): List<ResponseProdukUnggulan> {
        return repository.getProdukUnggulan()
    }
}