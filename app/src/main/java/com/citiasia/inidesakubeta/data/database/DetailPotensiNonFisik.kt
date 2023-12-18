package com.citiasia.inidesakubeta.data.database

object DetailPotensiNonFisik {
    private var data = arrayOf(
        arrayOf(
            "Sampel Potensi Non Fisik Desa",
            "23.0",
            "2023",
        ),
        arrayOf(
            "Sampel Potensi Non Fisik Desa",
            "23.0",
            "2023",
        ),
        arrayOf(
            "Sampel Potensi Non Fisik Desa",
            "23.0",
            "2023",
        ),
        arrayOf(
            "Sampel Potensi Non Fisik Desa",
            "23.0",
            "2023",
        ),
        arrayOf(
            "Sampel Potensi Non Fisik Desa",
            "23.0",
            "2023",
        )
    )

    val listData : ArrayList<PotensiNonFisik>get() {
        val list = ArrayList<PotensiNonFisik>()
        for (d in data) {
            val dataDetail = PotensiNonFisik()
            dataDetail.title = d[0]
            dataDetail.value = d[1]
            dataDetail.year = d[2]

            list.add(dataDetail)
        }
        return list
    }
}