package com.citiasia.inidesakubeta.ui.pasar_desa

import PasarDesaViewModel
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.data.database.Produk
import com.citiasia.inidesakubeta.databinding.ActivityDetailProdukBinding
import com.citiasia.inidesakubeta.model.RekomendasiProdukDummy
import com.citiasia.inidesakubeta.ui.ViewModelFactory
import com.citiasia.inidesakubeta.ui.konfirmasi.KonfirmasiActivity
import com.google.android.material.button.MaterialButton

class DetailProdukActivity : AppCompatActivity() {

    private var _binding: ActivityDetailProdukBinding? = null
    private val binding get() = _binding!!
    private lateinit var tvTotalPembayaran: String
    private lateinit var pasarDesaViewModel: PasarDesaViewModel
    private var produk: Produk? = null
    private var encounter = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailProdukBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val vmFactory = ViewModelFactory.getInstance(application)
        pasarDesaViewModel = ViewModelProvider(this, vmFactory)[PasarDesaViewModel::class.java]

        var dataRekomendasiProduk = intent.getParcelableExtra<RekomendasiProdukDummy>("key_item")!!
        val productName = intent.getStringExtra("product_name")
        Log.d("Punya Detail", productName.toString())

//        pasarDesaViewModel.getProdukByNames(productName.toString()) { produk ->
//            produk?.let {
//                binding.ivDetailProduk.setImageResource(dataRekomendasiProduk.fotoProduk ?: produk.fotoProduk)
//                binding.ivIconRating.setImageResource(dataRekomendasiProduk.iconNilaiProduk ?: produk.iconNilaiProduk)
//                binding.tvNamaProduk.text = dataRekomendasiProduk.namaProduk ?: produk.namaProduk
//                binding.tvHargaProduk.text = "Rp. " + dataRekomendasiProduk.hargaProduk ?: produk.hargaProduk
//                binding.textRating.text = dataRekomendasiProduk.nilaiProduk ?: produk.nilaiProduk
//                binding.tvProdukTerjual.text = dataRekomendasiProduk.produkTerjual ?: produk.produkTerjual
//                binding.tvDetailRincianProduk.text = dataRekomendasiProduk.deskripsiProduk ?: produk.deskripsiProduk
//            }
//        }

//        if (dataRekomendasiProduk != null) {
//            binding.ivDetailProduk.setImageResource(dataRekomendasiProduk.fotoProduk)
//            binding.ivIconRating.setImageResource(dataRekomendasiProduk.iconNilaiProduk)
//            binding.tvNamaProduk.text = dataRekomendasiProduk.namaProduk
//            binding.tvHargaProduk.text = "Rp. " + dataRekomendasiProduk.hargaProduk
//            binding.textRating.text = dataRekomendasiProduk.nilaiProduk
//            binding.tvProdukTerjual.text = dataRekomendasiProduk.produkTerjual
//            binding.tvDetailRincianProduk.text = dataRekomendasiProduk.deskripsiProduk
//        } else  {
//            pasarDesaViewModel.getProdukByNames(productName.toString()) { produk ->
//                produk?.let {
//                    dataRekomendasiProduk = RekomendasiProdukDummy(
//                        it.fotoProduk,
//                        it.namaProduk,
//                        it.hargaProduk,
//                        it.deskripsiProduk,
//                        it.iconNilaiProduk,
//                        it.nilaiProduk,
//                        it.produkTerjual
//                    )
//                }
//            }
////            if (!productName.isNullOrEmpty()) {
//////                    produk?.let {
//////                        dataRekomendasiProduk. it.fotoProduk
//////                        binding.ivIconRating.setImageResource(it.iconNilaiProduk)
//////                        binding.tvNamaProduk.text = it.namaProduk
//////                        binding.tvHargaProduk.text = it.hargaProduk
//////                        binding.textRating.text = it.nilaiProduk
//////                        binding.tvProdukTerjual.text = it.produkTerjual
//////                        binding.tvDetailRincianProduk.text = it.deskripsiProduk
//////                    }
////                }
////            }
//       }

        binding.ivDetailProduk.setImageResource(dataRekomendasiProduk.fotoProduk)
        binding.ivIconRating.setImageResource(dataRekomendasiProduk.iconNilaiProduk)
        binding.tvNamaProduk.text = dataRekomendasiProduk.namaProduk
        binding.tvHargaProduk.text = "Rp. " + dataRekomendasiProduk.hargaProduk
        binding.textRating.text = dataRekomendasiProduk.nilaiProduk
        binding.tvProdukTerjual.text = dataRekomendasiProduk.produkTerjual
        binding.tvDetailRincianProduk.text = dataRekomendasiProduk.deskripsiProduk

//        binding.ivDetailProduk.setImageResource(dataRekomendasiProduk.fotoProduk)
//        binding.ivIconRating.setImageResource(dataRekomendasiProduk.iconNilaiProduk)
//        binding.tvNamaProduk.text = dataRekomendasiProduk.namaProduk
//        binding.tvHargaProduk.text = "Rp. " + dataRekomendasiProduk.hargaProduk
//        binding.textRating.text = dataRekomendasiProduk.nilaiProduk
//        binding.tvProdukTerjual.text = dataRekomendasiProduk.produkTerjual
//        binding.tvDetailRincianProduk.text = dataRekomendasiProduk.deskripsiProduk

        binding.btnBeli.setOnClickListener {

            binding.scrollPage.background = ColorDrawable(Color.parseColor("#77000000"))
            binding.containerImageProduct.foreground = ColorDrawable(Color.parseColor("#77000000"))

            val inflater = LayoutInflater.from(this)
            val popupView = inflater.inflate(R.layout.pop_up_detail_produk, null)

            val tvNamaProdukPopup: TextView = popupView.findViewById(R.id.tv_nama_produk)
            var tvHargaProdukPopup: TextView = popupView.findViewById(R.id.tv_harga_produk)
            tvHargaProdukPopup.text = "Rp. " + dataRekomendasiProduk?.hargaProduk
            val tvHargaAdminPopup: TextView = popupView.findViewById(R.id.tv_harga_admin)
            tvHargaAdminPopup.text = "Rp. 2.000,00"
            val tvTotalPembayaranPopup: TextView = popupView.findViewById(R.id.tv_total_pembayaran)

            tvNamaProdukPopup.text = dataRekomendasiProduk?.namaProduk
            val cleanedPrice = dataRekomendasiProduk?.hargaProduk?.replace(".", "")?.replace(",", ".")
            val priceDouble = cleanedPrice?.toDoubleOrNull() ?: 0.0
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
                intent.putExtra("PIN_PAGE", "PASAR_DESA")
                intent.putExtra("HARGA_PRODUK", dataRekomendasiProduk?.hargaProduk)
                intent.putExtra("TOTAL_HARGA_PRODUK", tvTotalPembayaran)
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

            pasarDesaViewModel.addOrUpdateProduct(namaProduk!!, hargaProduk!!, fotoProduk!!, deskripsiProduk!!,
                iconNilaiProduk!!, nilaiProduk!!, produkTerjual!!)

            val intent = Intent(this, KeranjangActivity::class.java)
            intent.putExtra("key_item", dataRekomendasiProduk)
            startActivity(intent)
        }
    }

}