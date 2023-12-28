package com.citiasia.inidesakubeta.data.remote.dummyObject

import com.citiasia.inidesakubeta.data.remote.model.ResponseDonasi

object Donasi {

    val title = arrayListOf(
        "Bantu Anak-Anak Kurang Beruntung",
        "Peduli Lingkungan: Tanam Satu Pohon, Lestarikan Bumi",
        "Dukung Pendidikan Anak Miskin, Berikan Mereka Masa Depan",
        "Donasi untuk Penyembuhan Pasien Kritis",
        "Berbagi Makanan, Sediakan Hidangan untuk Mereka yang Lapar",
        "Krisis Kemanusiaan: Bantu Korban Bencana Alam"
    )

    val time =  arrayListOf(
        "27 Desember 2023, 23.59 WIB",
        "29 Desember 2023, 23.59 WIB",
        "30 Desember 2023, 23.59 WIB",
        "01 Januari 2024, 23.59 WIB",
        "05 Januari 2024, 23.59 WIB",
        "07 Januari 2024, 23.59 WIB",
    )


    val admin = arrayListOf(
        "Admin Desa",
        "Admin Desa",
        "Admin Desa",
        "Admin Desa",
        "Admin Desa",
        "Admin Desa",
    )

    val category = arrayListOf(
        arrayListOf("Kemanusiaan"),
        arrayListOf("Lingkungan"),
        arrayListOf("Kemanusiaan", "Pendidikan"),
        arrayListOf("Kemanusiaan", "Kesehatan"),
        arrayListOf("Kemanusiaan"),
        arrayListOf("Kemanusiaan"),
    )

    val imageCover = arrayListOf(
        "https://cdn0-production-images-kly.akamaized.net/I8YrCZpYbYTASRXX3Pjp8jiPqk0=/469x260/smart/filters:quality(75):strip_icc():format(webp)/kly-media-production/medias/3354125/original/043836400_1611122002-IMG-20210118-WA0032.jpg",
        "https://tokohinspiratif.id/wp-content/uploads/2023/03/mPosts_8392108198_artikel_3.jpg",
        "https://static.republika.co.id/uploads/images/headline_slide/pendidikan-gratis-ilustrasi-_130330094638-836.jpg",
        "https://images.bisnis.com/posts/2023/01/03/1614750/hepatitis-akut-misterius-pada-anak.jpg",
        "https://awsimages.detik.net.id/community/media/visual/2021/08/19/rasulullah-saw-sebut-orang-yang-sering-berbagi-makanan-dijamin-masuk-surga.jpeg?w=1200",
        "https://cdns.klimg.com/merdeka.com/i/w/news/2018/10/04/1015433/540x270/bantu-korban-bencana-alam-sulteng-pemprov-sulsel-akan-bangun-100-rumah.jpg"
    )


    val donasiStart = arrayListOf(
        12, 24, 15, 2, 22, 17
    )

    val donasiEnd= arrayListOf(
        45, 30, 20, 30, 60, 30
    )
    val collect = arrayListOf(
        4000000, 500000, 2500000, 750000, 1300000, 500000
    )
    val target = arrayListOf(
        5000000, 3000000, 10000000, 3000000, 45000000, 2500000
    )
    val about = arrayListOf(
        "Donasikan sebagian rezeki Anda untuk membantu anak-anak yang kurang beruntung mendapatkan akses ke pendidikan, perawatan kesehatan, dan kebutuhan dasar lainnya. Bersama-sama, kita dapat memberikan mereka harapan dan kesempatan untuk meraih masa depan yang lebih baik.",
        "Bergabunglah dalam upaya pelestarian lingkungan dengan mendukung kampanye penanaman pohon. Setiap donasi Anda akan menjadi investasi untuk masa depan bumi kita, menciptakan lingkungan yang lebih hijau dan berkelanjutan bagi generasi mendatang.",
        "Ayo bersama-sama memutus lingkaran kemiskinan dengan memberikan kesempatan pendidikan kepada anak-anak miskin. Donasikan untuk mendukung program pendidikan yang memberikan akses, buku, dan fasilitas belajar yang layak bagi mereka yang membutuhkan.",
        "Setiap sumbangan Anda sangat berarti dalam menyediakan dukungan finansial bagi pasien kritis yang memerlukan perawatan medis intensif. Bersama kita bisa membantu mereka mendapatkan perawatan yang dibutuhkan untuk pulih dan melanjutkan kehidupan mereka.",
        "Mari bersama-sama memberikan kehangatan dan kepedulian dengan berbagi makanan kepada mereka yang kelaparan. Donasikan untuk menyediakan hidangan bergizi bagi yang membutuhkan dan bersama-sama kita ciptakan perubahan positif dalam kehidupan mereka.",
        "Kemanusiaan membutuhkan tindakan kita. Donasikan untuk membantu korban bencana alam dan memberikan bantuan mendesak seperti makanan, perlindungan, dan perawatan kesehatan. Bersama-sama kita dapat memberikan harapan dan dukungan saat mereka memulai kembali kehidupan mereka setelah bencana."
    )

    val phone = arrayListOf(
        "+6281383231104",
        "+6281383231104",
        "+6281383231104",
        "+6281383231104",
        "+6281383231104",
        "+6281383231104",
    )

    fun getDonasiList(): ArrayList<ResponseDonasi> {
        val tempList = arrayListOf<ResponseDonasi>()
        for (i in title.indices) {
            val donasi = ResponseDonasi(
                title = this.title[i],
                time = this.time[i],
                admin = this.admin[i],
                category = this.category[i],
                imageCover = this.imageCover[i],
                donasiStart = this.donasiStart[i],
                donasiEnd = this.donasiEnd[i],
                collect = this.collect[i],
                target = this.target[i],
                about = this.about[i],
                phone = this.phone[i]
            )
            tempList.add(donasi)
        }
        return tempList
    }

    fun getCategory(): List<String> {
        val categoryList = category.flatten()
        return categoryList.distinct()
    }
}