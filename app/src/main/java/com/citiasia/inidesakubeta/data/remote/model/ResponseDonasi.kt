package com.citiasia.inidesakubeta.data.remote.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseDonasi (
    val title: String,
    val time: String,
    val admin: String,
    val category: ArrayList<String>,
    val imageCover: String,
    val donasiStart: Int,
    val donasiEnd: Int,
    val collect: Int,
    val target: Int,
    val about: String,
    val phone : String,
) : Parcelable