package com.citiasia.inidesakubeta.data.remote.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PilihWilayahModel(
    val provinsi: String?,
    val kotaKabupaten: String?,
    val kecamatan: String?,
    val desaKelurahan: String?
) : Parcelable