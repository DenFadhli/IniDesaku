package com.citiasia.inidesakubeta.data.remote.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PriceListDummy(
    var jenis: String,
    var nominal: String,
    var tambahanHari: Int?,
    var harga: Double

) : Parcelable

@Parcelize
data class DataPulsaUser(
    var dataPaket: PriceListDummy,
    var dataUserPhoneChoose: PulsaDataInput
) : Parcelable
