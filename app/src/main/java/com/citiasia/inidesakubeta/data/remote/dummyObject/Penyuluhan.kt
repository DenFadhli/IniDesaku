package com.citiasia.inidesakubeta.data.remote.dummyObject

import com.citiasia.inidesakubeta.data.remote.model.ResponsePenyuluhan

object Penyuluhan {
    val title = arrayListOf(
        "Penyuluhan Pertanian Berkelanjutan",
        "Penyuluhan Kesehatan Reproduksi",
        "Penyuluhan Pengelolaan Keuangan Keluarga",
        "Penyuluhan Pemanfaatan Energi Terbarukan",
        "Penyuluhan Pendidikan Anak",
        "Penyuluhan Pengelolaan Bencana"
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
        "Puskesmas Desa",
        "Online - Zoom",
        "Balai Desa",
        "Balai Desa",
        "Balai Desa"
    )

    val category = arrayListOf(
        arrayListOf("Pertanian"),
        arrayListOf("Kesehatan", "Kebersihan"),
        arrayListOf("Ekonomi"),
        arrayListOf("Lingkungan", "Kebersihan"),
        arrayListOf("Pendidikan"),
        arrayListOf("Lingkungan"),
    )

    val imageCover = arrayListOf(
        "https://awsimages.detik.net.id/visual/2020/04/01/11a9d80e-1627-4fcc-bf62-35cb7faf05ef_169.jpeg?w=650",
        "https://mediacenter.slemankab.go.id/wp-content/uploads/2022/04/penyuluhan-kesehatan-reproduksi.jpg",
        "https://www.manadotoday.co.id/wp-content/uploads/2018/11/Penelitian-1.jpg",
        "https://sdgs.telkomuniversity.ac.id/wp-content/uploads/2020/01/b.png",
        "https://ppid.bengkaliskab.go.id/asset/berita/original/95136209115-84351915128-photogrid_1629869800144.jpg",
        "https://klik7tv.co.id/wp-content/uploads/2021/10/b054af8b-9c38-411f-9f8f-43b7263c9b85.jpg"
    )

    val persyaratan = arrayListOf(
        "Peserta dapat berasal dari petani desa. Minat untuk menerapkan praktik pertanian berkelanjutan.",
        "Terbuka untuk semua lapisan masyarakat, terutama perempuan usia reproduksi. Partisipasi sukarela untuk memahami informasi kesehatan reproduksi.",
        "Terbuka untuk semua anggota keluarga dan pemuda desa. Kesediaan untuk belajar mengelola keuangan secara bijak.",
        "Terbuka untuk seluruh warga desa yang ingin mengurangi konsumsi energi konvensional. Kesediaan untuk menerapkan solusi energi terbarukan.",
        "Terbuka untuk orang tua, guru, dan semua yang terlibat dalam pendidikan anak. Minat untuk meningkatkan pemahaman tentang pendidikan anak.",
        "Terbuka untuk semua warga desa. Kesediaan untuk belajar dan berpartisipasi dalam upaya mitigasi bencana."
    )

    val rincian = arrayListOf(
        "Fokus pada teknik pertanian organik, pengelolaan sumber daya alam, dan diversifikasi tanaman. Melibatkan pertanian berkelanjutan sebagai solusi untuk meningkatkan hasil dan keberlanjutan lingkungan.",
        "Mengajarkan pentingnya perencanaan keluarga, kesehatan reproduksi, dan pencegahan penyakit menular seksual. Melibatkan tenaga kesehatan profesional sebagai pembicara.",
        "Memahamkan tentang anggaran keluarga, tabungan, dan investasi kecil. Melibatkan narasumber dari lembaga keuangan atau ahli keuangan.",
        "Mempelajari cara menggunakan energi terbarukan seperti panel surya, energi angin kecil, dan energi biomassa. Demonstrasi pemanfaatan energi terbarukan di lingkungan sekitar.",
        "Membahas pentingnya pendidikan awal, pola asuh yang baik, dan stimulasi perkembangan anak. Melibatkan psikolog anak atau pendidik anak sebagai pembicara.",
        "Memberikan informasi tentang risiko bencana di daerah tersebut dan cara menguranginya. Melibatkan petugas penanggulangan bencana setempat.",
    )

    val manfaat = arrayListOf(
        "Meningkatkan produktivitas pertanian. Mengurangi dampak negatif pertanian terhadap lingkungan.",
        "Meningkatkan kesadaran tentang kesehatan reproduksi. Mendukung keluarga dalam perencanaan keluarga yang sehat.",
        "Meningkatkan literasi keuangan masyarakat. Memberdayakan keluarga dalam pengelolaan keuangan yang baik.",
        "Mengurangi ketergantungan pada energi konvensional. Menyelamatkan lingkungan melalui penggunaan energi yang lebih ramah lingkungan.",
        "Meningkatkan pemahaman orang tua tentang pentingnya pendidikan anak. Memberikan dukungan untuk perkembangan optimal anak.",
        "Meningkatkan kesiapsiagaan desa dalam menghadapi bencana. Mengurangi risiko kerugian akibat bencana alam."
    )

    fun getPenyuluhanList(): ArrayList<ResponsePenyuluhan>{
        val tempList = arrayListOf<ResponsePenyuluhan>()
        for (i in title.indices) {
            val penyuluhan = ResponsePenyuluhan(
                title = this.title[i],
                time = this.time[i],
                place = this.place[i],
                category = this.category[i],
                imageCover = this.imageCover[i],
                persyaratan = this.persyaratan[i],
                rincian = this.rincian[i],
                manfaat = this.manfaat[i]
            )
            tempList.add(penyuluhan)
        }
        return tempList
    }

    fun getCategory(): List<String> {
        val categoryList = category.flatten()
        return categoryList.distinct()
    }
}