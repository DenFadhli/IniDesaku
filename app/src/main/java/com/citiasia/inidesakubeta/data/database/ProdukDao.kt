package com.citiasia.inidesakubeta.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.citiasia.inidesakubeta.model.RekomendasiProdukDummy

@Dao
interface ProdukDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertProduk(produk: Produk)

    @Update
    fun update(produk: Produk)

    @Query("UPDATE produk SET jumlah = :newJumlah WHERE id = :produkId")
    fun updateJumlahProduk(produkId: Int, newJumlah: Int)

    @Query("SELECT * FROM produk WHERE namaProduk = :namaProduk AND hargaProduk = :hargaProduk AND fotoProduk = :fotoProduk")
    fun getKeranjangProduk(namaProduk: String, hargaProduk: String, fotoProduk: Int): LiveData<Produk>

    @Query("SELECT * FROM produk WHERE namaProduk = :namaProduk")
    fun getDetailProduk(namaProduk: String) : LiveData<List<Produk>>

    @Query("SELECT * FROM produk WHERE namaProduk = :namaProduk")
    fun getProdukByName(namaProduk: String): Produk?

    @Query("SELECT * FROM produk ORDER BY id DESC")
    fun getAllProducts(): LiveData<List<Produk>>

    @Query("DELETE FROM produk WHERE namaProduk = :namaProduk")
    fun deleteProdukByName(namaProduk: String)
}