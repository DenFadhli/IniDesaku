package com.citiasia.inidesakubeta

import androidx.lifecycle.ViewModel
import com.citiasia.inidesakubeta.data.database.Berita
import com.citiasia.inidesakubeta.data.database.Budaya
import com.citiasia.inidesakubeta.data.database.PicBudaya
import com.citiasia.inidesakubeta.data.database.PotensiFisik
import com.citiasia.inidesakubeta.data.database.PotensiNonFisik
import com.citiasia.inidesakubeta.data.database.ProfilDesa
import com.citiasia.inidesakubeta.data.database.Wisata
import com.citiasia.inidesakubeta.data.remote.model.ResponseTvcc
import com.citiasia.inidesakubeta.data.repo.FiturRepository

class ListBeritaViewModel(
    private val repo: FiturRepository
): ViewModel() {
    fun getBeritaData(): List<Berita> {
        return repo.getBerita()
    }
}

class ListBudayaViewModel(
    private val repo: FiturRepository
): ViewModel() {
    fun getBudayaData(): List<Budaya> {
        return repo.getBudaya()
    }
    fun getPicData(): List<PicBudaya> {
        return repo.getPicBudaya()
    }
}

class ListPotensiFisikViewModel(
    private val repo: FiturRepository
): ViewModel() {
    fun getPotensiFisikData(): List<PotensiFisik> {
        return repo.getPotensiFisik()
    }
}

class ListPotensiNonFisikViewModel(
    private val repo: FiturRepository
): ViewModel() {
    fun getPotensiNonFisikData(): List<PotensiNonFisik> {
        return repo.getPotensiNonFisik()
    }
}

class ListProfilDesaViewModel(
    private val repo: FiturRepository
): ViewModel() {
    fun getProfilDesaData(): List<ProfilDesa> {
        return repo.getProfilDesa()
    }
}

class ListWisataViewModel(
    private val repo: FiturRepository
): ViewModel() {
    fun getWisataData(): List<Wisata> {
        return repo.getWisata()
    }
}