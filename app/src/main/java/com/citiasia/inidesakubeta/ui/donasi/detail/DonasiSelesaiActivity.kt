package com.citiasia.inidesakubeta.ui.donasi.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.citiasia.inidesakubeta.databinding.ActivityDonasiSelesaiBinding
import com.citiasia.inidesakubeta.ui.splashScreenFragment.SplashScreenFragment
import com.citiasia.inidesakubeta.utils.DonasiPreference
import java.text.DecimalFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

class DonasiSelesaiActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDonasiSelesaiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDonasiSelesaiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showLoading()
        setRincianDonasi()
        setRincianPembayaran()
        binding.btnKembali.setOnClickListener {
            this.finish()
        }
        binding.topAppBar.setOnClickListener {
            this.finish()
        }
    }

    private fun showLoading() = with(binding) {
        layoutTerimaKasih.visibility = View.GONE
        Handler().postDelayed({
            lifecycleScope.launchWhenCreated {
                layoutTerimaKasih.visibility = View.VISIBLE
                layoutLoading.visibility = View.GONE
            }
        }, SplashScreenFragment.MILISECON.toLong())

    }

    private fun setRincianPembayaran() {
        val preference = DonasiPreference(this)
        val nominal = preference.getData().total ?: "0"

        val formattedNominal = formatCurrency(nominal)

        binding.tvRincianNominalDonasiUang.text = "Rp $formattedNominal"

        val totalAmount = nominal.toIntOrNull() ?: 0
        val total = totalAmount + 2500

        val formattedTotal = formatCurrency(total.toString())

        binding.tvRincianTotalBiayaUang.text = "Rp $formattedTotal"
    }

    private fun formatCurrency(value: String): String {
        val formatter = DecimalFormat("#,###,###")
        val formattedValue = formatter.format(value.toInt())
        return "$formattedValue,00"
    }

    private fun setRincianDonasi() {
        with(binding){
            tvTglPembayaran.text = getTodayDate()
            tvIdDonasinya.text = getRandomIdGenerate()
        }
    }

    private fun getTodayDate(): String {
        val today: LocalDate = LocalDate.now()
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale("id"))

        return today.format(formatter)
    }

    private fun getRandomIdGenerate(): String {
        val randomNumber = (0..999_999_999).random()
        return String.format("%09d", randomNumber)
    }
}