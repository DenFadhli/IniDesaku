package com.citiasia.inidesakubeta.data.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.citiasia.inidesakubeta.data.database.Berita
import com.citiasia.inidesakubeta.data.database.Budaya
import com.citiasia.inidesakubeta.data.database.DetailBerita
import com.citiasia.inidesakubeta.data.database.DetailBudaya
import com.citiasia.inidesakubeta.data.database.DetailPotensiFisik
import com.citiasia.inidesakubeta.data.database.DetailPotensiNonFisik
import com.citiasia.inidesakubeta.data.database.DetailProfilDesa
import com.citiasia.inidesakubeta.data.database.DetailWisata
import com.citiasia.inidesakubeta.data.database.GaleriBudaya
import com.citiasia.inidesakubeta.data.database.PicBudaya
import com.citiasia.inidesakubeta.data.database.PotensiFisik
import com.citiasia.inidesakubeta.data.database.PotensiNonFisik
import com.citiasia.inidesakubeta.data.database.ProfilDesa
import com.citiasia.inidesakubeta.data.database.Wisata
import com.citiasia.inidesakubeta.data.remote.dummyObject.Tvcc
import com.citiasia.inidesakubeta.data.remote.model.LoginResponse
import com.citiasia.inidesakubeta.data.remote.model.ResponseTvcc

class FiturRepository {

    fun getTvcc() : List<ResponseTvcc> {
        return Tvcc.getTvccList()
    }

    fun getBerita() : List<Berita> {
        return DetailBerita.getBeritaList()
    }

    fun getBudaya() : List<Budaya> {
        return DetailBudaya.getBudayaList()
    }

    fun getPicBudaya() : List<PicBudaya> {
        return GaleriBudaya.getPicList()
    }

    fun getPotensiFisik() : List<PotensiFisik> {
        return DetailPotensiFisik.getPotensiFisikList()
    }

    fun getPotensiNonFisik() : List<PotensiNonFisik> {
        return DetailPotensiNonFisik.getPotensiNonFisikList()
    }

    fun getProfilDesa() : List<ProfilDesa> {
        return DetailProfilDesa.getProfilDesaList()
    }

    fun getWisata() : List<Wisata> {
        return DetailWisata.getWisataList()
    }

}