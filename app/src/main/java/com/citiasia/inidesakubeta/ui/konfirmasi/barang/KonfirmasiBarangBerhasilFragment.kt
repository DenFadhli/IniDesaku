package com.citiasia.inidesakubeta.ui.konfirmasi.barang

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.databinding.FragmentKonfirmasiBarangBerhasilBinding
import com.citiasia.inidesakubeta.databinding.FragmentKonfirmasiBerhasilBinding
import com.citiasia.inidesakubeta.ui.pasar_desa.PasarDesaActivity
import com.citiasia.inidesakubeta.ui.splashScreenFragment.SplashScreenFragment
import com.citiasia.inidesakubeta.utils.DataJenisPembayaranPreference
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale
import kotlin.random.Random


class KonfirmasiBarangBerhasilFragment : Fragment() {

    private var _binding: FragmentKonfirmasiBarangBerhasilBinding? = null
    private val binding get() = _binding!!

    private lateinit var pref: DataJenisPembayaranPreference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentKonfirmasiBarangBerhasilBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pref = DataJenisPembayaranPreference(requireContext())

        showLoading()

        onBackPressed()
        binding.tvTanggalValue.text = getTodayDate()
        binding.tvIdValue.text = getRandomIdGenerate()

        binding.tvNominal.text = pref.getData()[0]
        binding.tvNominalValue.text = pref.getData()[1]
        binding.tvTotalBiayaValue.text = pref.getData()[2]

        binding.btnKembali.setOnClickListener {
            findNavController().navigate(R.id.action_konfirmasiBarangBerhasilFragment_to_pasaDesaActivity)
            requireActivity().finish()
        }
    }

    private fun showLoading() = with(binding) {
        tvTerimaKasih.visibility = View.GONE
        Handler().postDelayed({
            lifecycleScope.launchWhenCreated {
                tvTerimaKasih.visibility = View.VISIBLE
                layoutLoading.visibility = View.GONE
            }
        }, SplashScreenFragment.MILISECON.toLong())

    }

//    private fun setUpData(pref: DataJenisPembayaranPreference) = with(binding) {
//
//        tvKodeTokenValue.height = 0
//        tvTanggalValue.text = getTodayDate()
//        tvIdValue.text = getRandomIdGenerate()
//
//        val builder = StringBuilder()
//        tvNominal.text = builder.append("Nominal ").append(pref.getData()[0])
//        tvNominalValue.text = pref.getData()[1]
//        tvTotalBiayaValue.text = pref.getData()[2]
//
//        btnKembali.setOnClickListener {
//            finishActivity()
//        }
//    }

    private fun getRandomIdGenerate() : String {
        val random = Random
        val randomNumber = (0..999_999_999).random()

        val randomString = String.format("%09d", randomNumber)

        return randomString
    }
    private fun getTodayDate() : String {
        // Mengambil data tanggal hari ini "dd MMMM yyyy"
        val today: LocalDate = LocalDate.now()
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale("id"))
        val formattedDate: String = today.format(formatter)

        return formattedDate
    }

    private fun onBackPressed() = with(binding) {
        topAppBar.setNavigationOnClickListener {
            findNavController().navigate(R.id.action_konfirmasiBarangBerhasilFragment_to_pasaDesaActivity)
            requireActivity().finish()
        }
    }

    companion object{
        const val TAG = "KonfirmasiBerhasilFragment"
        const val MILISECON = 3000.0
    }


}