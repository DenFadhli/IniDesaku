package com.citiasia.inidesakubeta.data.remote.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PulsaDataInput(
    var number: String?,
    var provider: String?
) : Parcelable