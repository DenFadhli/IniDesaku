package com.citiasia.inidesakubeta.data.database

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "produk")
@Parcelize
data class Produk(
    @PrimaryKey(autoGenerate = true)

    @ColumnInfo(name = "id")
    var id: Int = 0,

    @ColumnInfo(name = "fotoProduk")
    var fotoProduk: Int,

    @ColumnInfo(name = "namaProduk")
    var namaProduk: String,

    @ColumnInfo(name = "hargaProduk")
    var hargaProduk: String,

    @ColumnInfo(name = "deskripsiProduk")
    var deskripsiProduk: String,

    @ColumnInfo(name = "iconNilaiProduk")
    var iconNilaiProduk: Int,

    @ColumnInfo(name = "nilaiProduk")
    var nilaiProduk: String,

    @ColumnInfo(name = "produkTerjual")
    var produkTerjual: String,

    @ColumnInfo(name = "jumlah")
    var jumlah: Int,
) : Parcelable
