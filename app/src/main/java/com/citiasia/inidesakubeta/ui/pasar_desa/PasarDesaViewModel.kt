package com.citiasia.inidesakubeta.ui.pasar_desa

import android.app.Application
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.citiasia.inidesakubeta.data.database.Produk
import com.citiasia.inidesakubeta.data.repo.ProdukRepository
import com.citiasia.inidesakubeta.model.RekomendasiProdukDummy

class PasarDesaViewModel(application: Application) : ViewModel() {

    private val mProdukRepository: ProdukRepository = ProdukRepository(application)
    private val mKeranjangProduk: MutableLiveData<Produk> = MutableLiveData()

    fun insertUser(produk: Produk) {
        mProdukRepository.insertProduk(produk)
    }

    fun addOrUpdateProduct(namaProduk: String, hargaProduk: String, fotoProduk: Int, deskripsiProduk: String, iconNilaiProduk: Int, nilaiProduk: String, produkTerjual: String) {
        checkProdukExists(namaProduk) { isProdukExists ->
            if (!isProdukExists) {
                val newProduct = Produk(
                    fotoProduk = fotoProduk,
                    namaProduk = namaProduk,
                    hargaProduk = hargaProduk,
                    deskripsiProduk = deskripsiProduk, // Set appropriate value
                    iconNilaiProduk = iconNilaiProduk, // Set appropriate value
                    nilaiProduk = nilaiProduk, // Set appropriate value
                    produkTerjual = produkTerjual, // Set appropriate value
                    jumlah = 1 // Set initial quantity to 1 for new products
                )
                insertUser(newProduct)
            } else {
                val existingProduct = getExistingProduct(namaProduk)
                existingProduct?.let {
                    val newJumlah = it.jumlah + 1
                    updateProductQuantity(it.id, newJumlah)
                }
            }
        }
    }

    private fun getExistingProduct(namaProduk: String): Produk? {
        return mProdukRepository.getProdukByName(namaProduk)
    }

    fun updateProductQuantity(productId: Int, newJumlah: Int) {
        mProdukRepository.updateJumlahProduk(productId, newJumlah)
    }

    fun checkProdukExists(produkName: String, callback: (Boolean) -> Unit) {
        mProdukRepository.checkProdukExists(produkName) { exists ->
            callback(exists)
        }
    }

    fun deleteProduct(namaProduk: String) {
        mProdukRepository.deleteProdukByName(namaProduk)
    }

    val allProducts: LiveData<List<Produk>> = mProdukRepository.allProducts

    fun getProdukByNames(produkName: String, callback: (Produk?) -> Unit) {
        mProdukRepository.getProdukByNames(produkName) { produk ->
            callback(produk)
        }
    }
}
