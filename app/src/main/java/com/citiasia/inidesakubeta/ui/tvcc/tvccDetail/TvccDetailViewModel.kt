package com.citiasia.inidesakubeta.ui.tvcc.tvccDetail

import androidx.lifecycle.ViewModel
import com.citiasia.inidesakubeta.data.remote.model.ResponseTvcc
import com.citiasia.inidesakubeta.data.repo.FiturRepository

class TvccDetailViewModel(
    private val repo: FiturRepository
): ViewModel() {

    fun getTvccData(): List<ResponseTvcc> {
        return repo.getTvcc()
    }

}