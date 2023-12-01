package com.citiasia.inidesakubeta.data.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.citiasia.inidesakubeta.data.remote.dummyObject.Tvcc
import com.citiasia.inidesakubeta.data.remote.model.LoginResponse
import com.citiasia.inidesakubeta.data.remote.model.ResponseTvcc

class FiturRepository {

    fun getTvcc() : List<ResponseTvcc>  {
        return Tvcc.getTvccList()
    }
}