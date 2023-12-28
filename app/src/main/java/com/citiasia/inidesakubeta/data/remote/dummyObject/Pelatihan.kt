package com.citiasia.inidesakubeta.data.remote.dummyObject

import com.citiasia.inidesakubeta.data.remote.model.ResponsePelatihan

object Pelatihan {
    val title = arrayListOf(
        "Pelatihan Pertanian Organik",
        "Pelatihan Kewirausahaan Desa",
        "Pelatihan Pengelolaan Sampah",
        "Pelatihan Teknologi Informasi Desa",
        "Pelatihan Seni dan Kreativitas Desa",
        "Pelatihan Pertolongan Pertama Desa"
    )

    val time = arrayListOf(
        "04 Januari 2024, 09.00 WIB",
        "05 Januari 2024, 09.00 WIB",
        "10 Januari 2024, 08.00 WIB",
        "12 Januari 2024, 10.00 WIB",
        "13 Januari 2024, 09.00 WIB",
        "15 Januari 2024, 08.00 WIB",
    )

    val place = arrayListOf(
        "Balai Desa",
        "Rumah Karang Taruna",
        "Rumah Pengolahan Sampah Desa",
        "Balai Desa",
        "Balai Desa",
        "Balai Desa",
    )

    val fee = arrayListOf(
        "Rp. 10.000",
        "Gratis",
        "Gratis",
        "Gratis",
        "Rp. 10.000",
        "Gratis"
    )
    val category = arrayListOf(
        arrayListOf("Pertanian"),
        arrayListOf("Ekonomi"),
        arrayListOf("Lingkungan"),
        arrayListOf("Pendidikan"),
        arrayListOf("Pendidikan", "Kebudayaan"),
        arrayListOf("Pendidikan", "Kesehatan"),
    )

    val imageCover = arrayListOf(
        "https://www.swadayaonline.com/images/view/-lembang%20ok.jpg",
        "https://besuki-panggul.trenggalekkab.go.id/assets/files/artikel/sedang_1566877809IMG-20190821-WA0010.jpg",
        "https://web-pertamina.azurewebsites.net/Media/Image/post/Pertamina-RU-VI-Latih-Warga-Mendaur-Ulang--Sampah.jpg",
        "https://balingasal.kec-padureso.kebumenkab.go.id/uploads/gambar/25032021064528-Balingasal-Kebumen-gutama.jpg",
        "https://jatimulyo.bantulkab.go.id/assets/files/artikel/sedang_1603680312WhatsAppImage20201026at09.19.16.jpeg",
        "https://srssafetyndo.com/assets/img/service/f18b3da6594099a4a16489195a5f2c1d.PNG"
    )

    val videoPelatihan = arrayListOf(
        "https://media.geeksforgeeks.org/wp-content/uploads/20201217192146/Screenrecorder-2020-12-17-19-17-36-828.mp4?_=1",
        "",
        "",
        "https://youtu.be/NZHt7aJZkl8",
        "",
        "https://youtu.be/NZHt7aJZkl8",
    )

    val persyaratan = arrayListOf(
        "Peserta dapat berasal dari petani desa. Minat dan komitmen untuk menerapkan pertanian organik.",
        "Warga desa yang memiliki minat dalam berwirausaha. Kemauan untuk memahami prinsip-prinsip dasar bisnis.",
        "Partisipasi warga desa dari berbagai kelompok usia. Kesediaan untuk mengadopsi praktik pengelolaan sampah yang lebih baik.",
        "Pemuda desa yang tertarik pada teknologi informasi. Memiliki dasar pengetahuan komputer.",
        "Warga desa dari berbagai kelompok usia dengan minat dalam seni. Tidak ada persyaratan khusus, terbuka untuk semua.",
        "Warga desa dari segala kelompok usia. Tidak diperlukan pengalaman sebelumnya di bidang kesehatan."
    )

    val rincian = arrayListOf(
        "Fokus pada teknik tanam organik, pengelolaan tanah, dan pemupukan alami. Dilaksanakan dalam beberapa sesi praktik lapangan.",
        "Melibatkan pelatihan perencanaan bisnis, pemasaran, dan manajemen keuangan. Pembicara dari kalangan pengusaha lokal.",
        "Pembelajaran cara daur ulang, kompos, dan pengurangan limbah. Praktik pengolahan sampah di lokasi.",
        "Mencakup pengenalan perangkat lunak, pemrograman dasar, dan penggunaan internet. Workshop praktis dengan akses ke perangkat keras dan perangkat lunak.",
        "Melibatkan berbagai bentuk seni seperti seni lukis, tari, dan musik tradisional. Pameran hasil karya seni masyarakat desa.",
        "Mempelajari teknik dasar pertolongan pertama, penanganan darurat, dan CPR. Simulasi kecelakaan dan latihan praktik langsung."
    )

    val manfaat = arrayListOf(
        "Meningkatkan hasil pertanian dan keberlanjutan lingkungan. Menyediakan alternatif pertanian yang lebih sehat.",
        "Meningkatkan keterampilan berwirausaha. Mendorong pertumbuhan usaha lokal.",
        "Mengurangi dampak lingkungan negatif dari sampah. Menciptakan desa yang lebih bersih dan sehat.",
        "Meningkatkan literasi digital penduduk desa. Membuka peluang pekerjaan di bidang teknologi.",
        "Mempromosikan kekayaan budaya desa. Memberikan platform bagi bakat seni lokal.",
        "Meningkatkan kemampuan masyarakat dalam memberikan pertolongan pertama. Menyelamatkan nyawa dan mengurangi dampak cedera."
    )

    fun getPelatihanList(): ArrayList<ResponsePelatihan> {
        val tempList = arrayListOf<ResponsePelatihan>()
        for (i in title.indices) {
            val pelatihan = ResponsePelatihan(
                title = this.title[i],
                time = this.time[i],
                place = this.place[i],
                fee = this.fee[i],
                category = this.category[i],
                imageCover = this.imageCover[i],
                videoPelatihan = this.videoPelatihan[i],
                persyaratan = this.persyaratan[i],
                rincian = this.rincian[i],
                manfaat =this.manfaat[i]
            )
            tempList.add(pelatihan)
        }
        return tempList
    }

    fun getCategory(): List<String> {
        val categoryList = category.flatten()
        return categoryList.distinct()
    }
}