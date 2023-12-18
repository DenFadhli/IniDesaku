package com.citiasia.inidesakubeta.data.database

data class Berita(
    var title : String = "",
    var image : String = "",
    var admin : String = "",
    var time : String = "",
    var viewer : String = "",
    var desc : String = "",
)

data class PotensiFisik(
    var title : String = "",
    var image : String = "",
    var admin : String = "",
    var time : String = "",
    var viewer : String = "",
    var desc : String = "",
)

data class PotensiNonFisik(
    var title: String = "",
    var value: String = "",
    var year: String = "",
)

data class Budaya(
    var title : String = "",
    var image : String = "",
    var admin : String = "",
    var time : String = "",
    var viewer : String = "",
    var desc : String = "",
)

data class Wisata(
    var title : String = "",
    var image : String = "",
    var lokasi : String = "",
    var time : String = "",
    var age : String = "",
    var desc : String = "",
)

data class ProfilDesa(
    var desc: String = "",
    var code: String = "",
    var village: String = "",
    var number: String = "",
    var mail: String = "",
    var web: String = "",
)
