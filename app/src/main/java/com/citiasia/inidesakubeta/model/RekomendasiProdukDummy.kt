package com.citiasia.inidesakubeta.model

import android.os.Parcelable
import com.citiasia.inidesakubeta.data.database.Produk
import kotlinx.parcelize.Parcelize

@Parcelize
data class RekomendasiProdukDummy(
    val fotoProduk: Int,
    val namaProduk: String,
    val hargaProduk: String,
    val deskripsiProduk: String,
    val iconNilaiProduk: Int,
    val nilaiProduk: String,
    val produkTerjual: String,
) : Parcelable