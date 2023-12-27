package com.citiasia.inidesakubeta.data.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.citiasia.inidesakubeta.data.remote.dummyObject.Donasi
import com.citiasia.inidesakubeta.data.remote.dummyObject.KegiatanDesa
import com.citiasia.inidesakubeta.data.remote.dummyObject.Pelatihan
import com.citiasia.inidesakubeta.data.remote.dummyObject.PelayananDesa
import com.citiasia.inidesakubeta.data.remote.dummyObject.Penyuluhan
import com.citiasia.inidesakubeta.data.remote.dummyObject.ProdukUnggulan
import com.citiasia.inidesakubeta.data.remote.dummyObject.Tvcc
import com.citiasia.inidesakubeta.data.remote.model.LoginResponse
import com.citiasia.inidesakubeta.data.remote.model.ResponseDonasi
import com.citiasia.inidesakubeta.data.remote.model.ResponseKegiatanDesa
import com.citiasia.inidesakubeta.data.remote.model.ResponsePelatihan
import com.citiasia.inidesakubeta.data.remote.model.ResponsePelayananDesa
import com.citiasia.inidesakubeta.data.remote.model.ResponsePenyuluhan
import com.citiasia.inidesakubeta.data.remote.model.ResponseProdukUnggulan
import com.citiasia.inidesakubeta.data.remote.model.ResponseTvcc

class FiturRepository {

    fun getTvcc() : List<ResponseTvcc>  {
        return Tvcc.getTvccList()
    }

    fun getDonasi() : List<ResponseDonasi> {
        return Donasi.getDonasiList()
    }

    fun getKegiatan() : List<ResponseKegiatanDesa> {
        return KegiatanDesa.getKegiatanDesaList()
    }

    fun getPelatihan() : List<ResponsePelatihan>{
        return Pelatihan.getPelatihanList()
    }

    fun getPenyuluhan() : List<ResponsePenyuluhan> {
        return Penyuluhan.getPenyuluhanList()
    }

    fun getPelayanan() : List<ResponsePelayananDesa> {
        return PelayananDesa.getPelayananList()
    }

    fun getProdukUnggulan() : List<ResponseProdukUnggulan> {
        return ProdukUnggulan.getProdukUnggulanList()
    }
}