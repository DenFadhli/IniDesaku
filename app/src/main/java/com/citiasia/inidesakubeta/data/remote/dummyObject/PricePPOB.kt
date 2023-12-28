package com.citiasia.inidesakubeta.data.remote.dummyObject

import android.util.Log
import com.citiasia.inidesakubeta.data.remote.model.PriceListDummy
import com.citiasia.inidesakubeta.data.remote.model.ResponseTvcc

object PricePPOB {

    val nominal = arrayListOf(
        "5.000",
        "10.000",
        "15.000",
        "20.000",
        "25.000",
        "30.000",
        "35.000",
        "40.000",
        "45.000",
    )

    val tambahanHari = arrayListOf(
        2,
        5,
        7,
        8,
        10,
        12,
        23,
        50,
        12,
    )

    val total = arrayListOf(
        7000.0,
        12000.0,
        17000.0,
        22000.0,
        27000.0,
        32000.0,
        37000.0,
        42000.0,
        47000.0,
    )

    fun getPulsaList(): ArrayList<PriceListDummy> {
        val tempList = arrayListOf<PriceListDummy>()
        for (i in nominal.indices) {
            Log.e("jumlah data tvcc", i.toString())
            val tvcc = PriceListDummy(
                jenis = "Pulsa",
                nominal = nominal[i],
                tambahanHari = tambahanHari[i],
                harga = total[i]
            )
            tempList.add(tvcc)
        }
        return tempList
    }

    fun getTokenList(): ArrayList<PriceListDummy> {
        val tempList = arrayListOf<PriceListDummy>()
        for (i in nominal.indices) {
            Log.e("jumlah data tvcc", i.toString())
            val tvcc = PriceListDummy(
                jenis = "Token Listrik",
                nominal = nominal[i],
                tambahanHari = tambahanHari[i],
                harga = total[i]
            )
            tempList.add(tvcc)
        }
        return tempList
    }

}