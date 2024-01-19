package com.citiasia.inidesakubeta.ui.pasar_desa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.data.remote.model.PenilaianUserModel
import com.citiasia.inidesakubeta.databinding.ActivityPasarDesaBinding
import com.citiasia.inidesakubeta.model.RekomendasiProdukDummy
import com.citiasia.inidesakubeta.ui.adapter.ListRekomendasiProdukAdapter
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel

class PasarDesaActivity : AppCompatActivity() {

    private var _binding: ActivityPasarDesaBinding? = null
    private val binding get() = _binding!!

    private lateinit var rvItemPasarDesa: RecyclerView
    private val list = ArrayList<RekomendasiProdukDummy>()
    val imageList = ArrayList<SlideModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityPasarDesaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvItemPasarDesa = binding.rvListContent
        rvItemPasarDesa.setHasFixedSize(true)

        binding.topAppBar.setNavigationOnClickListener {
            onBackPressed()
        }

        binding.topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_keranjang -> {
                    val intent = Intent(this, KeranjangActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }

        list.addAll(getListProduk())
        showRecyclerList()

        imageList.add(SlideModel(R.drawable.carousel_1))
        imageList.add(SlideModel(R.drawable.carousel_2))
        imageList.add(SlideModel(R.drawable.carousel_3))
        imageList.add(SlideModel(R.drawable.carousel_4))
        imageList.add(SlideModel(R.drawable.carousel_5))

        binding.imageSlider.setImageList(imageList)
    }

    private fun getListProduk(): ArrayList<RekomendasiProdukDummy> {
        val dataFotoProduk = resources.obtainTypedArray(R.array.data_rekomendasi_foto_produk)
        val dataNamaProduk = resources.getStringArray(R.array.data_rekomendasi_nama_produk)
        val dataDeskripsiProduk = resources.getStringArray(R.array.data_rekomendasi_deskripsi_produk)
        val dataHargaProduk = resources.getStringArray(R.array.data_rekomendasi_harga_produk)
        val dataIconNilaiProduk = resources.obtainTypedArray(R.array.data_rekomendasi_icon_nilai_produk)
        val dataNilaiProduk = resources.getStringArray(R.array.data_rekomendasi_nilai_produk)
        val dataProdukTerjual = resources.getStringArray(R.array.data_rekomendasi_produk_terjual)
        val listProduk = ArrayList<RekomendasiProdukDummy>()
        for (i in dataNamaProduk.indices) {
            val produk = RekomendasiProdukDummy(dataFotoProduk.getResourceId(i, -1), dataNamaProduk[i], dataHargaProduk[i], dataDeskripsiProduk[i], dataIconNilaiProduk.getResourceId(i, -1), dataNilaiProduk[i], dataProdukTerjual[i])
            listProduk.add(produk)
        }
        return listProduk
    }

    private fun showRecyclerList() {
        rvItemPasarDesa.layoutManager = GridLayoutManager(this, 2)
        val listProdukAdapter = ListRekomendasiProdukAdapter(list)
        rvItemPasarDesa.adapter = listProdukAdapter
    }

}