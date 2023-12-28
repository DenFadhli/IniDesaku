package com.citiasia.inidesakubeta.ui

<<<<<<< HEAD
import PasarDesaViewModel
import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.citiasia.inidesakubeta.ui.sign.login.LoginViewModel
import com.citiasia.inidesakubeta.ui.sign.signUp.CompleteProfileViewModel
import com.citiasia.inidesakubeta.ui.sign.signUp.SignUpViewModel

class ViewModelFactory private constructor(private val mApplication: Application) : ViewModelProvider.NewInstanceFactory() {

   companion object {
       @Volatile
       private var INSTANCE: ViewModelFactory? = null

       @JvmStatic
       fun getInstance(application: Application): ViewModelFactory {
           if (INSTANCE == null) {
               synchronized(ViewModelFactory::class.java) {
                   INSTANCE = ViewModelFactory(application)
               }
           }
           return INSTANCE as ViewModelFactory
       }
   }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SignUpViewModel::class.java)) {
            return SignUpViewModel(mApplication) as T
        }
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(mApplication) as T
        }
        if (modelClass.isAssignableFrom(CompleteProfileViewModel::class.java)) {
            return CompleteProfileViewModel(mApplication) as T
        }
        if (modelClass.isAssignableFrom(PasarDesaViewModel::class.java)) {
            return PasarDesaViewModel(mApplication) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
=======
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.citiasia.inidesakubeta.ui.pesona.ListBeritaViewModel
import com.citiasia.inidesakubeta.ui.pesona.ListBudayaViewModel
import com.citiasia.inidesakubeta.ui.pesona.ListPotensiFisikViewModel
import com.citiasia.inidesakubeta.ui.pesona.ListPotensiNonFisikViewModel
import com.citiasia.inidesakubeta.ui.pesona.ListProfilDesaViewModel
import com.citiasia.inidesakubeta.ui.pesona.ListWisataViewModel
import com.citiasia.inidesakubeta.di.Injection
import com.citiasia.inidesakubeta.ui.desa.kegiatan_desa.list.KegiatanDesaViewModel
import com.citiasia.inidesakubeta.ui.desa.pelatihan_desa.list.PelatihanDesaViewModel
import com.citiasia.inidesakubeta.ui.desa.pelayanan_desa.list.PelayananDesaViewModel
import com.citiasia.inidesakubeta.ui.desa.penyuluhan_desa.list.PenyuluhanDesaViewModel
import com.citiasia.inidesakubeta.ui.donasi.list.DonasiViewModel
import com.citiasia.inidesakubeta.ui.produk_unggulan.list.ProdukUnggulanViewModel
import com.citiasia.inidesakubeta.ui.sign.login.LoginViewModel
import com.citiasia.inidesakubeta.ui.tvcc.tvccDetail.TvccDetailViewModel
import com.citiasia.inidesakubeta.ui.tvcc.tvccHome.TvccFrontViewModel

class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return LoginViewModel(Injection.provideLoginRepo(context)) as T
        }
        if (modelClass.isAssignableFrom(TvccFrontViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TvccFrontViewModel(Injection.provideFiturnRepo(context)) as T
        }
        if (modelClass.isAssignableFrom(TvccDetailViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TvccDetailViewModel(Injection.provideFiturnRepo(context)) as T
        }
        if (modelClass.isAssignableFrom(DonasiViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return DonasiViewModel(Injection.provideFiturnRepo(context)) as T
        }
        if (modelClass.isAssignableFrom(KegiatanDesaViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return KegiatanDesaViewModel(Injection.provideFiturnRepo(context)) as T
        }
        if (modelClass.isAssignableFrom(PelatihanDesaViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return PelatihanDesaViewModel(Injection.provideFiturnRepo(context)) as T
        }
        if (modelClass.isAssignableFrom(PelayananDesaViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return PelayananDesaViewModel(Injection.provideFiturnRepo(context)) as T
        }
        if (modelClass.isAssignableFrom(ProdukUnggulanViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return ProdukUnggulanViewModel(Injection.provideFiturnRepo(context)) as T
        }
        if (modelClass.isAssignableFrom(PenyuluhanDesaViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return PenyuluhanDesaViewModel(Injection.provideFiturnRepo(context)) as T
        }
        if (modelClass.isAssignableFrom(ListBeritaViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ListBeritaViewModel(Injection.provideFiturnRepo(context)) as T
        }
        if (modelClass.isAssignableFrom(ListBudayaViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ListBudayaViewModel(Injection.provideFiturnRepo(context)) as T
        }
        if (modelClass.isAssignableFrom(ListPotensiFisikViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ListPotensiFisikViewModel(Injection.provideFiturnRepo(context)) as T
        }
        if (modelClass.isAssignableFrom(ListPotensiNonFisikViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ListPotensiNonFisikViewModel(Injection.provideFiturnRepo(context)) as T
        }
        if (modelClass.isAssignableFrom(ListProfilDesaViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ListProfilDesaViewModel(Injection.provideFiturnRepo(context)) as T
        }
        if (modelClass.isAssignableFrom(ListWisataViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ListWisataViewModel(Injection.provideFiturnRepo(context)) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
>>>>>>> origin/ppob_pages
    }
}