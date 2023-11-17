package com.citiasia.inidesakubeta.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PriceListDummy(
    var nominal: String,
    var tambahanHari: Int,
    var harga: Double

) : Parcelable

@Parcelize
data class DataPulsaUser(
    var dataPaket: PriceListDummy,
    var dataUserPhoneChoose: PulsaDataInput
) : Parcelable
