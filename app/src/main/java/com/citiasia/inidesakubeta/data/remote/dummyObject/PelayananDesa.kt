package com.citiasia.inidesakubeta.data.remote.dummyObject

import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.data.remote.model.ResponsePelayananDesa

object PelayananDesa {
    val title = arrayListOf(
        "Pusat Informasi Desa (PID)",
        "Layanan Kesehatan Keliling",
        "Layanan Pembinaan Usaha Desa",
        "Pos Pendidikan Rakyat",
        "Layanan Pengolahan Limbah",
        "Layanan Keamanan Desa"
    )

    val time = arrayListOf(
        "Senin - Jumat, 10.00 - 15.00",
        "Senin - Jumat, 10.00 - 15.00",
        "Rabu, 10.00 - 15.00",
        "Senin - Jumat, 10.00 - 15.00",
        "Jumat, 10.00 - 15.00",
        "Senin - Jumat, 10.00 - 15.00",
    )

    val place = arrayListOf(
        "Balai Desa",
        "Balai Desa",
        "Balai Desa",
        "Balai Desa",
        "Balai Desa",
        "Balai Desa",
    )

    val category = arrayListOf(
        arrayListOf("Informasi"),
        arrayListOf("Kesehatan"),
        arrayListOf("Ekonomi"),
        arrayListOf("Pendidikan"),
        arrayListOf("Kebersihan", "Lingkungan"),
        arrayListOf("Keamanan", "Lingkungan"),
    )

    val persyaratan = arrayListOf(
        "Tenaga informasi yang terlatih. Aksesibilitas informasi yang baik.",
        "Tim kesehatan terlatih. Kendaraan kesehatan yang dilengkapi peralatan medis dasar.",
        "Ahli bisnis dan ekonomi. Dana pembinaan usaha desa.",
        "Tenaga pendidik terlatih. Sarana dan prasarana pendidikan yang memadai.",
        "Fasilitas pengolahan limbah yang sesuai. Tenaga kerja terlatih.",
        "Tim keamanan atau petugas keamanan desa. Sistem pemantauan dan pelaporan keamanan."
    )

    val rincian = arrayListOf(
        "Menyediakan informasi terkini seputar kegiatan desa, peraturan, dan program pemerintah. Menggunakan teknologi untuk meningkatkan aksesibilitas, seperti situs web desa atau aplikasi seluler.",
        "Memberikan pelayanan kesehatan dasar, imunisasi, dan penyuluhan kesehatan di berbagai titik desa. Jadwal rutin dan tanggap darurat.",
        "Memberikan bimbingan kepada pengusaha lokal, membantu perencanaan bisnis, dan memberikan pelatihan. Menyediakan sumber daya finansial untuk pengembangan usaha.",
        "Menyelenggarakan kelas tambahan, kursus, dan pelatihan keterampilan. Memberikan akses pendidikan yang terjangkau bagi semua lapisan masyarakat desa.",
        "Mengelola pengumpulan dan pengolahan limbah rumah tangga. Memberikan edukasi tentang pengelolaan limbah yang ramah lingkungan.",
        "Menjaga keamanan wilayah desa. Mengorganisir patroli keamanan dan program pencegahan kejahatan."
    )

    val manfaat = arrayListOf(
        "Memperbaiki komunikasi antara pemerintah desa dan warganya. Meningkatkan transparansi dan partisipasi masyarakat.",
        "Meningkatkan kesehatan masyarakat desa. Mencegah penyebaran penyakit dan memberikan akses kesehatan bagi yang sulit dijangkau.",
        "Meningkatkan daya saing usaha lokal. Mendorong pertumbuhan ekonomi dan menciptakan lapangan kerja.",
        "Meningkatkan tingkat pendidikan masyarakat desa. Mengurangi kesenjangan pendidikan dan meningkatkan keterampilan masyarakat.",
        "Meningkatkan kebersihan desa. Mengurangi dampak negatif limbah terhadap lingkungan.",
        "Menciptakan lingkungan yang aman bagi warga desa. Mengurangi tingkat kejahatan dan meningkatkan perasaan aman masyarakat."
    )

    fun getPelayananList(): ArrayList<ResponsePelayananDesa> {
        val tempList = arrayListOf<ResponsePelayananDesa>()
        for (i in title.indices) {
            val pelayanan = ResponsePelayananDesa(
                title = this.title[i],
                time = this.time[i],
                place = this.place[i],
                category = this.category[i],
                persyaratan = this.persyaratan[i],
                rincian = this.rincian[i],
                manfaat = this.manfaat[i]
            )
            tempList.add(pelayanan)
        }
        return tempList
    }

    fun getCategory(): List<String> {
        val categoryList = category.flatten()
        return categoryList.distinct()
    }
}