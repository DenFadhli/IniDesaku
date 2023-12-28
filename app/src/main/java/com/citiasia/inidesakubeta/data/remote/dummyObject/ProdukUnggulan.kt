package com.citiasia.inidesakubeta.data.remote.dummyObject

import com.citiasia.inidesakubeta.data.remote.model.ResponseProdukUnggulan

object ProdukUnggulan {
    val title = arrayListOf(
        "Madu Desa Berkualitas",
        "Kerajinan Tangan Anyaman Desa",
        "Kopi Lokal Desa",
        "Produk Olahan Buah Lokal",
        "Batik Desa Berwawasan Lingkungan",
        "Sabun Organik Desa"
    )
    val time = arrayListOf(
        "25 Desember 2023",
        "26 Desember 2023",
        "27 Desember 2023",
        "28 Desember 2023",
        "29 Desember 2023",
        "30 Desember 2023",
    )

    val admin = arrayListOf(
        "Aldi",
        "Aldi",
        "Bambang",
        "Aldi",
        "Bambang",
        "Aldi",
    )

    val view = arrayListOf(
        5, 10, 2, 7, 8, 15
    )

    val category= arrayListOf(
        arrayListOf("Pangan"),
        arrayListOf("Kerajinan"),
        arrayListOf("Pangan"),
        arrayListOf("Pangan", "Olahan"),
        arrayListOf("Kerajinan"),
        arrayListOf("Olahan"),
    )

    val imageCover = arrayListOf(
        "https://media.karousell.com/media/photos/products/2022/12/27/madu_lebah_desa_asli_140gram_m_1672123579_e60cc65f",
        "https://tokohinspiratif.id/wp-content/uploads/2019/11/WhatsApp-Image-2019-11-25-at-22.04.33.jpeg",
        "https://awsimages.detik.net.id/community/media/visual/2021/12/25/kopi-khas-desa-tetebatu.jpeg?w=1200",
        "https://slawe-watulimo.trenggalekkab.go.id/assets/files/artikel/sedang_1563718693Gembrungisasi_190719_0002-2.jpg",
        "https://assets-a1.kompasiana.com/items/album/2022/05/18/publikasi-62851ae73623ae41352698e2.jpg",
        "https://imagekiddo.s3.ap-southeast-1.amazonaws.com/wp-content/uploads/2020/12/natural-soap-spa_169016-2049-e1608192218768.jpg"
    )

    val about = arrayListOf(
        "Madu desa murni yang dihasilkan dari sarang lebah lokal. Proses produksi yang alami tanpa menggunakan pestisida kimia. Madu ini memiliki cita rasa unik dari nektar bunga-bunga lokal dan dikenal memiliki khasiat kesehatan.",
        "Produk kerajinan tangan berupa anyaman dari bahan lokal seperti bambu, daun pandan, atau rotan. Dibuat dengan keahlian tradisional, menghasilkan berbagai produk seperti keranjang, tas, dan pernak-pernik rumah tangga.",
        "Kopi berkualitas tinggi yang ditanam dan diproses secara lokal. Ditanam dengan metode pertanian berkelanjutan untuk menghasilkan biji kopi dengan aroma khas. Kopi lokal desa ini cocok untuk pecinta kopi yang menghargai keberlanjutan dan keaslian rasa.",
        "Assortimen produk makanan olahan dari buah-buahan lokal seperti selai, sirup, atau kue kering. Diolah dengan metode tradisional untuk menjaga keaslian rasa dan kualitas nutrisinya.",
        "Batik khas desa dengan motif-motif tradisional yang dihasilkan melalui proses pewarnaan ramah lingkungan. Menggunakan pewarna alami dan teknik batik tradisional, menghasilkan produk tekstil yang indah dan berkelanjutan.",
        "Sabun mandi organik yang diproduksi dari bahan-bahan alami lokal seperti minyak kelapa, madu, dan herba tradisional. Tanpa tambahan bahan kimia berbahaya, produk ini memberikan pengalaman mandi yang alami dan menyehatkan bagi kulit."
    )

    val phone = arrayListOf(
        "+6281383231104",
        "+6281383231104",
        "+6281383231104",
        "+6281383231104",
        "+6281383231104",
        "+6281383231104",
    )

    fun getProdukUnggulanList(): ArrayList<ResponseProdukUnggulan> {
        val tempList = arrayListOf<ResponseProdukUnggulan>()
        for (i in title.indices) {
            val produk = ResponseProdukUnggulan(
                title = this.title[i],
                time = this.time[i],
                admin = this.admin[i],
                view = this.view[i],
                category = this.category[i],
                imageCover = this.imageCover[i],
                about = this.about[i],
                phone = this.phone[i]
            )
            tempList.add(produk)
        }
        return tempList
    }

    fun getCategory(): List<String> {
        val categoryList = category.flatten()
        return categoryList.distinct()
    }
}