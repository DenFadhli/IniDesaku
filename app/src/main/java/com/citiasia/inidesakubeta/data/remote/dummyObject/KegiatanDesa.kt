package com.citiasia.inidesakubeta.data.remote.dummyObject

import com.citiasia.inidesakubeta.data.remote.model.ResponseKegiatanDesa

object KegiatanDesa {
    val title = arrayListOf(
        "Gotong Royong Bersih Desa",
        "Pertanian Berkelanjutan",
        "Pasar Rakyat Desa",
        "Seni dan Budaya Desa",
        "Posyandu Sehat Desa",
        "Keterampilan untuk Pemuda",
    )
    val time = arrayListOf(
        "27 Desember 2023, 09.00 WIB",
        "29 Desember 2023, 08.45 WIB",
        "30 Desember 2023, 09.00 WIB",
        "04 Januari 2024, 10.00 WIB",
        "05 Januari 2024, 10.00 WIB",
        "07 Januari 2024, 08.45 WIB",
    )

    val place = arrayListOf(
        "Balai Desa",
        "Balai RW 01",
        "Online - Zoom",
        "Balai Desa",
        "Posyandu Desa",
        "Rumah Ibu Kartika, No. 06 RT 01 RW 07",
    )

    val category = arrayListOf(
        arrayListOf("Lingkungan", "Kebersihan"),
        arrayListOf("Pertanian"),
        arrayListOf("Ekonomi"),
        arrayListOf("Kebudayaan", "Pendidikan"),
        arrayListOf("Kesehatan"),
        arrayListOf("Pendidikan", "Kebudayaan"),
    )

    val imageCover = arrayListOf(
        "https://awsimages.detik.net.id/community/media/visual/2022/03/25/pemerintah-kota-pemkot-banda-aceh-kembali-adakan-kegiatan-gotong-royong-gotroy-massal-yang-dipimpin-oleh-wali-kota-banda-aceh-.jpeg?w=1200",
        "https://disk.mediaindonesia.com/files/news/2023/02/f495644f6830c015f0b7b3063bb1f166.jpg",
        "https://curupekspress.disway.id/upload/2020/07/707-ilustrasi_pasar_tradisional_trending_publik.jpg",
        "https://cdn.antarafoto.com/cache/1200x777/2023/07/05/promosi-seni-budaya-sleman-di-bali-17726-dom.jpg",
        "https://portal.sukabumikota.go.id/wp-content/uploads/2018/02/Pembinaan-dan-Pelatihan-Kader-Posyandu-Citamiang-768x510.jpg",
        "https://assets-a1.kompasiana.com/items/album/2022/02/25/img-20220221-wa0024-6218c8703179495b801e4023.jpg",
    )

    val persyaratan = arrayListOf(
        "Partisipasi warga desa semua kalangan. Alat kebersihan seperti sapu, sekop, dan tempat sampah.",
        "Peserta dapat berasal dari petani desa. Luangkan waktu untuk mengikuti seluruh rangkaian pelatihan.",
        "Partisipasi pedagang lokal dan warga desa yang ingin berjualan. Mengikuti pedoman pendaftaran dan penempatan stand.",
        "Partisipasi warga desa yang memiliki keahlian seni dan budaya. Penyelenggaraan pertunjukan dan pameran seni.",
        "Partisipasi ibu hamil, balita, dan warga desa yang membutuhkan pelayanan kesehatan. Memiliki tim kesehatan terlatih.",
        "Peserta terdiri dari pemuda desa yang ingin mengembangkan keterampilan mereka. Ketersediaan instruktur terampil.",

    )
    val rincian = arrayListOf(
        "Area yang dibersihkan mencakup ruang publik, saluran air, dan tempat umum lainnya.",
        "Fokus pada metode pertanian organik, pemupukan, dan teknik irigasi. Dibawakan oleh ahli pertanian setempat.",
        "Menyediakan tempat bagi pedagang lokal untuk mempromosikan dan menjual produk mereka.",
        "Melibatkan pertunjukan seni lokal, pameran lukisan, dan kerajinan tangan. Mengundang seniman lokal sebagai juri.",
        "Menyediakan pemeriksaan kesehatan, imunisasi, dan konsultasi kesehatan.",
        "Melibatkan pelatihan dalam bidang seperti IT, kerajinan tangan, atau keterampilan wirausaha. Diberikan secara berkala selama beberapa bulan.",
    )
    val manfaat = arrayListOf(
        "Meningkatkan kebersihan desa secara keseluruhan. Memperkuat rasa kebersamaan dan kegotong-royongan warga.",
        "Meningkatkan hasil pertanian. Mengurangi penggunaan bahan kimia berbahaya.",
        "Meningkatkan perekonomian lokal. Mendorong kemandirian ekonomi warga desa.",
        "Mempromosikan kekayaan budaya desa. Memberikan peluang bagi seniman lokal untuk berkembang.",
        "Meningkatkan kesehatan ibu dan anak. Mendeteksi dini masalah kesehatan.",
        "Meningkatkan kemampuan dan peluang pekerjaan pemuda. Mendukung pengembangan ekonomi desa.",
    )

    fun getKegiatanDesaList(): ArrayList<ResponseKegiatanDesa> {
        val tempList = arrayListOf<ResponseKegiatanDesa>()
        for (i in title.indices) {
            val kegiatan = ResponseKegiatanDesa(
                title = this.title[i],
                time = this.time[i],
                place = this.place[i],
                category = this.category[i],
                imageCover = this.imageCover[i],
                persyaratan = this.persyaratan[i],
                rincian = this.rincian[i],
                manfaat = this.manfaat[i]
            )
            tempList.add(kegiatan)
        }
        return tempList
    }

    fun getCategory(): List<String>{
        val categoryList = category.flatten()
        return categoryList.distinct()
    }
}