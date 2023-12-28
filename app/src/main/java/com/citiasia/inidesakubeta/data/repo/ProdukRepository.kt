package com.citiasia.inidesakubeta.data.repo

import android.app.Application
import androidx.lifecycle.LiveData
import com.citiasia.inidesakubeta.data.database.Produk
import com.citiasia.inidesakubeta.data.database.ProdukDao
import com.citiasia.inidesakubeta.data.database.ProdukRoomDatabase
import com.citiasia.inidesakubeta.model.RekomendasiProdukDummy
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class ProdukRepository(application: Application) {
    private val mProdukDao: ProdukDao
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val db = ProdukRoomDatabase.getDatabase(application)
        mProdukDao = db.produkDao()
    }

    fun insertProduk(produk: Produk) {
        executorService.execute { mProdukDao.insertProduk(produk) }
    }

    fun updateProduk(produk: Produk) {
        executorService.execute { mProdukDao.update(produk) }
    }

    fun checkProdukExists(produkName: String, callback: (Boolean) -> Unit) {
        executorService.execute {
            val existingProduk = mProdukDao.getProdukByName(produkName)
            callback(existingProduk != null)
        }
    }

    fun getKeranjangProduk(namaProduk: String, hargaProduk: String, fotoProduk: Int): LiveData<Produk> {
        return mProdukDao.getKeranjangProduk(namaProduk, hargaProduk, fotoProduk)
    }

    fun getDetailProduk(namaProduk: String): LiveData<List<Produk>> {
        return mProdukDao.getDetailProduk(namaProduk)
    }


    fun getProdukByName(produkName: String): Produk? {
        return mProdukDao.getProdukByName(produkName)
    }

    fun getProdukByNames(produkName: String, callback: (Produk?) -> Unit) {
        executorService.execute {
            val produk = mProdukDao.getProdukByName(produkName)
            callback(produk)
        }
    }

    fun updateJumlahProduk(productId: Int, newJumlah: Int) {
        executorService.execute {
            mProdukDao.updateJumlahProduk(productId, newJumlah)
        }
    }

    fun deleteProdukByName(namaProduk: String) {
        executorService.execute {
            mProdukDao.deleteProdukByName(namaProduk)
        }
    }

    val allProducts: LiveData<List<Produk>> = mProdukDao.getAllProducts()
}