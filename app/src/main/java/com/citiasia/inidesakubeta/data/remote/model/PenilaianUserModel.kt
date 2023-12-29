package com.citiasia.inidesakubeta.data.remote.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PenilaianUserModel(
    val fotoUser: Int?,
    val ratingUser: Int?,
    val namaUser: String?,
    val ulasanUser: String?
) : Parcelable