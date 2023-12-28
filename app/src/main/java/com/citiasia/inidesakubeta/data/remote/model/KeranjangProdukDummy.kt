package com.citiasia.inidesakubeta.model

import android.os.Parcelable
import com.citiasia.inidesakubeta.data.database.Produk
import kotlinx.parcelize.Parcelize

@Parcelize
data class KeranjangProdukDummy(
    val produk: Produk,
    var isSelected: Boolean = false
): Parcelable
