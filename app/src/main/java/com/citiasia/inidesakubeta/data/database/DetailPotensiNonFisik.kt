package com.citiasia.inidesakubeta.data.database

import android.util.Log

object DetailPotensiNonFisik {
    private var data = arrayOf(
        arrayOf(
            "Sampel Potensi Non Fisik Desa 1",
            "23.0",
            "2023",
        ),
        arrayOf(
            "Sampel Potensi Non Fisik Desa 2",
            "23.0",
            "2023",
        ),
        arrayOf(
            "Sampel Potensi Non Fisik Desa 3",
            "23.0",
            "2023",
        ),
        arrayOf(
            "Sampel Potensi Non Fisik Desa 4",
            "23.0",
            "2023",
        ),
        arrayOf(
            "Sampel Potensi Non Fisik Desa 5",
            "23.0",
            "2023",
        )
    )

//    val listData : ArrayList<PotensiNonFisik>get() {
//        val list = ArrayList<PotensiNonFisik>()
//        for (d in data) {
//            val dataDetail = PotensiNonFisik()
//            dataDetail.title = d[0]
//            dataDetail.value = d[1]
//            dataDetail.year = d[2]
//
//            list.add(dataDetail)
//        }
//        return list
//    }

    fun getPotensiNonFisikList(): ArrayList<PotensiNonFisik> {
        val tempList = arrayListOf<PotensiNonFisik>()
        for (i in data) {
            Log.e("jumlah data Potensi Non Fisik", i.toString())
            val potensiNonFisik = PotensiNonFisik(
                title = i[0],
                value = i[1],
                year = i[2]
            )
            tempList.add(potensiNonFisik)
        }
        return tempList
    }
}