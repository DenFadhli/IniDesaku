package com.citiasia.inidesakubeta.ui.konfirmasi.pulsaBerhasil

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.databinding.FragmentKonfirmasiPinBinding
import com.citiasia.inidesakubeta.databinding.FragmentKonfrimasiBerhasilBinding
import com.citiasia.inidesakubeta.ui.splashScreenFragment.SplashScreenFragment
import com.citiasia.inidesakubeta.utils.DataJenisPembayaranPreference
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale
import kotlin.random.Random


class KonfrimasiBerhasilFragment : Fragment() {

    private var _binding: FragmentKonfrimasiBerhasilBinding? = null
    private val binding get() = _binding!!

    private lateinit var pref: DataJenisPembayaranPreference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentKonfrimasiBerhasilBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pref = DataJenisPembayaranPreference(requireContext())

        showLoading()

        onBackPressed()
        setUpData(pref)
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

    private fun setUpData(pref: DataJenisPembayaranPreference) = with(binding) {

        tvKodeTokenValue.height = 0
        tvTanggalValue.text = getTodayDate()
        tvIdValue.text = getRandomIdGenerate()

        val builder = StringBuilder()
        tvNominal.text = builder.append("Nominal ").append(pref.getData()[0])
        tvNominalValue.text = pref.getData()[1]
        tvTotalBiayaValue.text = pref.getData()[2]

        btnKembali.setOnClickListener {
            finishActivity()
        }
    }

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

//    private fun onBackPressed() = with(binding) {
//        topAppBar.setNavigationOnClickListener { view ->
//            view.findNavController().navigateUp()
//        }
//    }

    private fun onBackPressed() = with(binding) {
        topAppBar.setNavigationOnClickListener {
            finishActivity()
        }
    }
    private fun finishActivity() {
        requireActivity().finish()
    }

    companion object{
        const val TAG = "KonfirmasiBerhasilFragment"
        const val MILISECON = 3000.0
    }


}