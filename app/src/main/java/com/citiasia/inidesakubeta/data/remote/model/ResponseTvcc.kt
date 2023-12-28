package com.citiasia.inidesakubeta.data.remote.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResponseTvcc(
    val title: String,
    val kategori: ArrayList<String>,
    val jamMulai: Int,
    val jamSelesai: Int,
    val thumnailGambar: String,
    val urlVideo: String
): Parcelable
