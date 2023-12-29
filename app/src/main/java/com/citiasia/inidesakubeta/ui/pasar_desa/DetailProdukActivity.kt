package com.citiasia.inidesakubeta.ui.pasar_desa

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.data.database.Produk
import com.citiasia.inidesakubeta.data.remote.model.PenilaianUserModel
import com.citiasia.inidesakubeta.databinding.ActivityDetailProdukBinding
import com.citiasia.inidesakubeta.model.RekomendasiProdukDummy
import com.citiasia.inidesakubeta.ui.ViewModelFactorySign
import com.citiasia.inidesakubeta.ui.adapter.ListRekomendasiProdukAdapter
import com.citiasia.inidesakubeta.ui.adapter.PenilaianUserAdapter
import com.citiasia.inidesakubeta.ui.konfirmasi.KonfirmasiActivity
import com.citiasia.inidesakubeta.utils.DataJenisPembayaranPreference
import com.google.android.material.button.MaterialButton

class DetailProdukActivity : AppCompatActivity() {

    private var _binding: ActivityDetailProdukBinding? = null
    private val binding get() = _binding!!
    private lateinit var tvTotalPembayaran: String
    private lateinit var pasarDesaViewModel: PasarDesaViewModel
    private var produk: Produk? = null
    private var encounter = 1
    private lateinit var pref: DataJenisPembayaranPreference
    private lateinit var rvPenilaianUser: RecyclerView
    private val userPenilaianList = ArrayList<PenilaianUserModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailProdukBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val vmFactory = ViewModelFactorySign.getInstance(application)
        pasarDesaViewModel = ViewModelProvider(this, vmFactory)[PasarDesaViewModel::class.java]
        pref = DataJenisPembayaranPreference((this))
        rvPenilaianUser = binding.rvPenilaianUser
        userPenilaianList.addAll(getPenilaianUser())
        showRecyclerList()

        binding.topAppBar.setNavigationOnClickListener {
            onBackPressed()
        }

        var dataRekomendasiProduk = intent.getParcelableExtra<RekomendasiProdukDummy>("key_item")!!

        binding.ivDetailProduk.setImageResource(dataRekomendasiProduk.fotoProduk)
        binding.ivIconRating.setImageResource(dataRekomendasiProduk.iconNilaiProduk)
        binding.tvNamaProduk.text = dataRekomendasiProduk.namaProduk
        binding.tvHargaProduk.text = "Rp. " + dataRekomendasiProduk.hargaProduk
        binding.textRating.text = dataRekomendasiProduk.nilaiProduk
        binding.tvProdukTerjual.text = dataRekomendasiProduk.produkTerjual
        binding.tvDetailRincianProduk.text = dataRekomendasiProduk.deskripsiProduk

        binding.btnBeli.setOnClickListener {
            binding.scrollPage.background = ColorDrawable(Color.parseColor("#77000000"))
            binding.containerImageProduct.foreground = ColorDrawable(Color.parseColor("#77000000"))

            val inflater = LayoutInflater.from(this)
            val popupView = inflater.inflate(R.layout.pop_up_detail_produk, null)

            val tvNamaProdukPopup: TextView = popupView.findViewById(R.id.tv_nama_produk)
            var tvHargaProdukPopup: TextView = popupView.findViewById(R.id.tv_harga_produk)
            tvHargaProdukPopup.text = "Rp. " + dataRekomendasiProduk.hargaProduk
            val tvHargaAdminPopup: TextView = popupView.findViewById(R.id.tv_harga_admin)
            tvHargaAdminPopup.text = "Rp. 2.000,00"
            val tvTotalPembayaranPopup: TextView = popupView.findViewById(R.id.tv_total_pembayaran)

            tvNamaProdukPopup.text = dataRekomendasiProduk.namaProduk
            val cleanedPrice = dataRekomendasiProduk.hargaProduk.replace(".", "").replace(",", ".")
            val priceDouble = cleanedPrice.toDoubleOrNull() ?: 0.0
            val totalPembayaran = priceDouble + 2000
            val formatter = java.text.NumberFormat.getCurrencyInstance(java.util.Locale("id", "ID"))
            val currencyFormat = formatter as java.text.DecimalFormat
            val symbols = currencyFormat.decimalFormatSymbols
            symbols.currencySymbol = "Rp. "
            currencyFormat.decimalFormatSymbols = symbols
            val formattedTotalPembayaran = currencyFormat.format(totalPembayaran)
            tvTotalPembayaranPopup.text = formattedTotalPembayaran
            tvTotalPembayaran = formattedTotalPembayaran

            val width = LinearLayout.LayoutParams.MATCH_PARENT
            val height = LinearLayout.LayoutParams.WRAP_CONTENT
            val focusable = true
            val popupWindow = PopupWindow(popupView, width, height, focusable)

            val btnClosePopup: ImageButton = popupView.findViewById(R.id.btnClose)
            btnClosePopup.setOnClickListener {
                binding.scrollPage.background = window.decorView.background
                binding.containerImageProduct.foreground = ColorDrawable(Color.TRANSPARENT)
                popupWindow.dismiss()
            }

            val btnBayar: MaterialButton =  popupView.findViewById(R.id.btnBayar)
            btnBayar.setOnClickListener {
                val intent = Intent(this, KonfirmasiActivity::class.java)
                pref.saveData("Produk", dataRekomendasiProduk.hargaProduk, tvTotalPembayaran)
                startActivity(intent)
            }

            popupWindow.showAtLocation(popupView, Gravity.BOTTOM, 0, 0)
        }

        binding.btnKeranjang.setOnClickListener {
            val namaProduk = dataRekomendasiProduk.namaProduk
            val hargaProduk = dataRekomendasiProduk.hargaProduk
            val fotoProduk = dataRekomendasiProduk.fotoProduk
            val deskripsiProduk = dataRekomendasiProduk.deskripsiProduk
            val iconNilaiProduk = dataRekomendasiProduk.iconNilaiProduk
            val nilaiProduk = dataRekomendasiProduk.nilaiProduk
            val produkTerjual = dataRekomendasiProduk.produkTerjual

            pasarDesaViewModel.addOrUpdateProduct(namaProduk, hargaProduk, fotoProduk, deskripsiProduk,
                iconNilaiProduk, nilaiProduk, produkTerjual)

            val intent = Intent(this, KeranjangActivity::class.java)
            intent.putExtra("key_item", dataRekomendasiProduk)
            startActivity(intent)
        }
    }

    private fun getPenilaianUser(): ArrayList<PenilaianUserModel> {
        val dataFotoUser = resources.obtainTypedArray(R.array.user_foto_rating_ulasan_produk)
        val dataNilaiUser = resources.obtainTypedArray(R.array.user_icon_rating_ulasan_produk)
        val dataNamaUser = resources.getStringArray(R.array.user_name_rating_ulasan_produk)
        val dataUlasanUser = resources.getStringArray(R.array.user_ulasan_produk)
        val listData = ArrayList<PenilaianUserModel>()
        for (i in dataNamaUser.indices) {
            val data = PenilaianUserModel(dataFotoUser.getResourceId(i, -1), dataNilaiUser.getResourceId(i, -1), dataNamaUser[i], dataUlasanUser[i])
            listData.add(data)
        }
        return listData
    }

    private fun showRecyclerList() {
        rvPenilaianUser.layoutManager = LinearLayoutManager(this)
        val listPenilaianUserAdapter = PenilaianUserAdapter(userPenilaianList)
        rvPenilaianUser.adapter = listPenilaianUserAdapter
    }

}