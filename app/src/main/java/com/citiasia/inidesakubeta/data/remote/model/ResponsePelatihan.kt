package com.citiasia.inidesakubeta.data.remote.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponsePelatihan(
    val title: String,
    val time: String,
    val place: String,
    val fee: String,
    val category: ArrayList<String>,
    val imageCover: String,
    val videoPelatihan: String,
    val persyaratan: String,
    val rincian: String,
    val manfaat: String
):Parcelable
