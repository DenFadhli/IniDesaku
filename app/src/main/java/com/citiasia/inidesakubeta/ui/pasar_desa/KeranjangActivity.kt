package com.citiasia.inidesakubeta.ui.pasar_desa

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.databinding.ActivityKeranjangBinding
import com.citiasia.inidesakubeta.model.KeranjangProdukDummy
import com.citiasia.inidesakubeta.model.RekomendasiProdukDummy
import com.citiasia.inidesakubeta.ui.ViewModelFactorySign
import com.citiasia.inidesakubeta.ui.adapter.KeranjangProdukAdapter
import com.citiasia.inidesakubeta.ui.adapter.OnItemCheckedListener
import com.citiasia.inidesakubeta.ui.konfirmasi.KonfirmasiActivity
import com.citiasia.inidesakubeta.utils.DataJenisPembayaranPreference
import com.google.android.material.button.MaterialButton


class KeranjangActivity : AppCompatActivity(), OnItemCheckedListener {

    private var _binding: ActivityKeranjangBinding? = null
    private val binding get() = _binding!!

    private lateinit var rvKeranjangPasarDesa: RecyclerView
    private val list = ArrayList<KeranjangProdukDummy>()

    private lateinit var tvTotalPembayaran: String
    private lateinit var hargaPembayaran: String
    private lateinit var pasarDesaViewModel: PasarDesaViewModel
    private lateinit var pref: DataJenisPembayaranPreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityKeranjangBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.topAppBar.setNavigationOnClickListener {
            onBackPressed()
        }

        val vmFactory = ViewModelFactorySign.getInstance(application)
        pasarDesaViewModel = ViewModelProvider(this, vmFactory)[PasarDesaViewModel::class.java]
        pref = DataJenisPembayaranPreference((this))

        pasarDesaViewModel.allProducts.observe(this) { products ->
           if (products != null && products.isNotEmpty()) {
               binding.productEmpty.visibility = View.GONE
               rvKeranjangPasarDesa = binding.rvKeranjang
               rvKeranjangPasarDesa.setHasFixedSize(true)

               getListRiwayat()
               showRecyclerList()
           } else {
               binding.productEmpty.visibility = View.VISIBLE
           }
        }

        setInitialButtonListeners()
    }

    private fun setInitialButtonListeners() {
        binding.btnBeli.setOnClickListener {
            Toast.makeText(this, "Pilih Item terlebih dahulu", Toast.LENGTH_SHORT).show()
        }
        binding.btnHapus.setOnClickListener {
            Toast.makeText(this, "Pilih Item terlebih dahulu", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onItemChecked(isChecked: Boolean) {
        if (isChecked) {
            binding.btnHapus.setOnClickListener {
                val selectedItems = list.filter { it.isSelected }
                if (selectedItems.isNotEmpty()) {
                    selectedItems.forEach { item ->
                        pasarDesaViewModel.deleteProduct(item.produk.namaProduk)
                    }
                    Toast.makeText(this, "Produk dikeluarkan dari keranjang", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Pilih item terlebih dahulu", Toast.LENGTH_SHORT).show()
                }
            }
            binding.btnBeli.setOnClickListener {
                val selectedItems = list.filter { it.isSelected }
                if (selectedItems.isNotEmpty()) {

                    val inflater = LayoutInflater.from(this)
                    val popupView = inflater.inflate(R.layout.pop_up_detail_produk, null)

                    val namaProduk = selectedItems.map { it.produk.namaProduk }
                    val hargaProduk = selectedItems.map { it.produk.hargaProduk }
                    val jumlahProduk = selectedItems.map { it.produk.jumlah }
                    val hargaProdukIntList = hargaProduk.zip(jumlahProduk).map { (harga) ->
                        harga.replace(".", "").replace(",", "").toIntOrNull()
                            ?: 0
                    }
                    val jumlahProdukIntList = jumlahProduk.map { it }

                    binding.rvKeranjang.background = ColorDrawable(Color.parseColor("#55000000"))
                    val layoutManager = rvKeranjangPasarDesa.layoutManager as LinearLayoutManager
                    val firstVisiblePosition = layoutManager.findFirstVisibleItemPosition()
                    val lastVisiblePosition = layoutManager.findLastVisibleItemPosition()

                    for (i in firstVisiblePosition..lastVisiblePosition) {
                        val view = layoutManager.findViewByPosition(i)
                        val cardView = view?.findViewById<CardView>(R.id.container_item_product)
                        val imageView = view?.findViewById<CardView>(R.id.container_image_product)
                        cardView?.background = ColorDrawable(Color.parseColor("#01000000"))
                        imageView?.foreground = ColorDrawable(Color.parseColor("#77000000"))
                    }

                    val tvNamaProdukPopup: TextView = popupView.findViewById(R.id.tv_nama_produk)
                    val tvHargaProdukPopup: TextView = popupView.findViewById(R.id.tv_harga_produk)
                    tvHargaProdukPopup.text = hargaProduk.zip(jumlahProdukIntList)
                        .joinToString(separator = "\n") { (harga, jumlah) -> "Rp. $harga x $jumlah" }
                    hargaPembayaran = hargaProduk.toString()
                    val tvHargaAdminPopup: TextView = popupView.findViewById(R.id.tv_harga_admin)
                    tvHargaAdminPopup.text = "Rp. 2.000,00"
                    val tvTotalPembayaranPopup: TextView = popupView.findViewById(R.id.tv_total_pembayaran)

                    tvNamaProdukPopup.text = namaProduk.joinToString(separator = "\n")
                    val totalPembayaran = hargaProdukIntList.zip(jumlahProdukIntList)
                        .sumOf { (harga, jumlah) -> harga * jumlah }
                    val fixedTotalPembayaran = totalPembayaran.toString().dropLast(2)
                    val totalPembayaranDenganAdmin = fixedTotalPembayaran.toInt() + 2000
                    val formatter = java.text.NumberFormat.getCurrencyInstance(java.util.Locale("id", "ID"))
                    val currencyFormat = formatter as java.text.DecimalFormat
                    val symbols = currencyFormat.decimalFormatSymbols
                    symbols.currencySymbol = "Rp. "
                    currencyFormat.decimalFormatSymbols = symbols
                    val formattedTotalPembayaran = currencyFormat.format(totalPembayaranDenganAdmin)
                    tvTotalPembayaranPopup.text = formattedTotalPembayaran
                    tvTotalPembayaran = formattedTotalPembayaran

                    val width = LinearLayout.LayoutParams.MATCH_PARENT
                    val height = LinearLayout.LayoutParams.WRAP_CONTENT
                    val focusable = true
                    val popupWindow = PopupWindow(popupView, width, height, focusable)

                    val btnClosePopup: ImageButton = popupView.findViewById(R.id.btnClose)
                    btnClosePopup.setOnClickListener {
                        binding.rvKeranjang.background = window.decorView.background
                        for (i in firstVisiblePosition..lastVisiblePosition) {
                            val view = layoutManager.findViewByPosition(i)
                            val cardView = view?.findViewById<CardView>(R.id.container_item_product)
                            val imageView = view?.findViewById<CardView>(R.id.container_image_product)
                            cardView?.background = ColorDrawable(Color.parseColor("#01000000"))
                            imageView?.foreground = ColorDrawable(Color.TRANSPARENT)
                        }
                        popupWindow.dismiss()
                    }

                    val btnBayar: MaterialButton =  popupView.findViewById(R.id.btnBayar)
                    btnBayar.setOnClickListener {
                        val intent = Intent(this, KonfirmasiActivity::class.java)
                        pref.saveData("Produk", hargaProduk.zip(jumlahProdukIntList)
                            .joinToString(separator = "\n") { (harga, jumlah) -> "Rp. $harga x $jumlah" }, formattedTotalPembayaran)
                        startActivity(intent)
                    }
                    popupWindow.showAtLocation(popupView, Gravity.BOTTOM, 0, 0)
                } else {
                    Toast.makeText(this, "Pilih item terlebih dahulu", Toast.LENGTH_SHORT).show()
                }
            }
        } else {
            setInitialButtonListeners()
        }
    }

    private fun getListRiwayat() {
        pasarDesaViewModel.allProducts.observe(this) { products ->
            products?.let {
                list.clear()
                list.addAll(products.map {
                    KeranjangProdukDummy(it, false)
                })
                showRecyclerList()
            }
        }
    }

    private fun showRecyclerList() {
        rvKeranjangPasarDesa.layoutManager = LinearLayoutManager(this)
        val adapter = KeranjangProdukAdapter(list, pasarDesaViewModel, this)
        rvKeranjangPasarDesa.adapter = adapter
        adapter.setOnItemClickCallback(object : KeranjangProdukAdapter.OnItemClickCallback{
            override fun onItemClicked(data: KeranjangProdukDummy) {
                val intent = Intent(this@KeranjangActivity, DetailProdukActivity::class.java)
                val selectedProduct = data.produk
                val rekomendasiProduk = RekomendasiProdukDummy(
                    selectedProduct.fotoProduk,
                    selectedProduct.namaProduk,
                    selectedProduct.hargaProduk,
                    selectedProduct.deskripsiProduk,
                    selectedProduct.iconNilaiProduk,
                    selectedProduct.nilaiProduk,
                    selectedProduct.produkTerjual
                )
                intent.putExtra("key_item", rekomendasiProduk)
                startActivity(intent)
            }
        })
    }

}