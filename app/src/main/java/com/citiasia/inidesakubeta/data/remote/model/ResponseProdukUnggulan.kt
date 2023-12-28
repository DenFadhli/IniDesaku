package com.citiasia.inidesakubeta.data.remote.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseProdukUnggulan(
    val title: String,
    val time: String,
    val admin: String,
    val view: Int,
    val category: ArrayList<String>,
    val imageCover: String,
    val about: String,
    val phone: String,
):Parcelable
