package com.citiasia.inidesakubeta.ui.konfirmasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.ui.konfirmasi.pin.KonfirmasiPinFragment

class KonfirmasiActivity : AppCompatActivity() {

    private lateinit var fromPage: String
    private lateinit var hargaProdukPasarDesa: String
    private lateinit var totalHargaProdukPasarDesa: String
    private lateinit var fromPPOBPage: String
    private lateinit var fromPasarDesaPage: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_konfirmasi)

        fromPage = intent.getStringExtra("PIN_PAGE")!!
        hargaProdukPasarDesa = intent.getStringExtra("HARGA_PRODUK").toString()
        totalHargaProdukPasarDesa = intent.getStringExtra("TOTAL_HARGA_PRODUK").toString()

        val bundle = Bundle().apply {
            putString("PIN_PAGE", fromPage)
            putString("HARGA_PRODUK", hargaProdukPasarDesa)
            putString("TOTAL_HARGA_PRODUK", totalHargaProdukPasarDesa)
        }

        val konfirmasiPinFragment = KonfirmasiPinFragment()
        konfirmasiPinFragment.arguments = bundle

        supportFragmentManager.commit {
            replace(R.id.fragmentContainerView, konfirmasiPinFragment)
        }

    }
}