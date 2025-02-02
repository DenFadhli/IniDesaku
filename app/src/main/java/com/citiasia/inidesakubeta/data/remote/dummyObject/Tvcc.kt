package com.citiasia.inidesakubeta.data.remote.dummyObject

import android.util.Log
import com.citiasia.inidesakubeta.data.remote.model.ResponseTvcc

object Tvcc {

    val title = arrayListOf(
        "Indramayu",
        "Tasikmalaya",
        "Kuningan",
        "Cirebon",
        "Garut",
        "Bandung",
    )

    val kategori = arrayListOf(
        arrayListOf("Kesehatan", "Penjualan", "Pendidikan"),
        arrayListOf("Kesehatan"),
        arrayListOf("Penjualan", "Pendidikan"),
        arrayListOf("Kesehatan", "Pendidikan"),
        arrayListOf("Kesehatan", "Penjualan"),
        arrayListOf("Pendidikan"),
    )

    val jamMulai = arrayListOf(
        13, 21, 14, 16, 10, 19
    )

    val jamSelesai = arrayListOf(
        14, 22, 16, 17, 12, 20
    )

    val thumnailGambar = arrayListOf(
        "https://picsum.photos/360/240",
        "https://picsum.photos/360/250",
        "https://picsum.photos/360/260",
        "https://picsum.photos/360/270",
        "https://picsum.photos/360/255",
        "https://picsum.photos/360/245",
    )

    val urlVideo = arrayListOf(
        "https://media.geeksforgeeks.org/wp-content/uploads/20201217192146/Screenrecorder-2020-12-17-19-17-36-828.mp4?_=1",
        "https://media.geeksforgeeks.org/wp-content/uploads/20201217192146/Screenrecorder-2020-12-17-19-17-36-828.mp4?_=1",
        "https://media.geeksforgeeks.org/wp-content/uploads/20201217192146/Screenrecorder-2020-12-17-19-17-36-828.mp4?_=1",
        "https://media.geeksforgeeks.org/wp-content/uploads/20201217192146/Screenrecorder-2020-12-17-19-17-36-828.mp4?_=1",
        "https://media.geeksforgeeks.org/wp-content/uploads/20201217192146/Screenrecorder-2020-12-17-19-17-36-828.mp4?_=1",
        "https://media.geeksforgeeks.org/wp-content/uploads/20201217192146/Screenrecorder-2020-12-17-19-17-36-828.mp4?_=1",
    )

    fun getImageData(): List<String> {
        return thumnailGambar
    }

    fun getTvccList(): ArrayList<ResponseTvcc> {
        val tempList = arrayListOf<ResponseTvcc>()
        for (i in title.indices) {
            Log.e("jumlah data tvcc", i.toString())
            val tvcc = ResponseTvcc(
                title = this.title[i],
                kategori = this.kategori[i],
                jamMulai = this.jamMulai[i],
                jamSelesai = this.jamSelesai[i],
                thumnailGambar = this.thumnailGambar[i],
                urlVideo = this.urlVideo[i],
            )
            tempList.add(tvcc)
        }
        return tempList
    }

    fun getKategori() : List<String> {
        val flattenedList = kategori.flatten()

        val uniqueValues = flattenedList.distinct()

        return uniqueValues
    }
}