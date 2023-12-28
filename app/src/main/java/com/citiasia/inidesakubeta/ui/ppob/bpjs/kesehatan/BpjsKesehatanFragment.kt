package com.citiasia.inidesakubeta.ui.ppob.bpjs.kesehatan

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.databinding.FragmentBpjsKesehatanBinding
import com.citiasia.inidesakubeta.ui.adapter.BulanTahunAdapter
import com.citiasia.inidesakubeta.ui.adapter.PulsaListAdapter
import com.citiasia.inidesakubeta.ui.ppob.bpjs.bpjsDialog.BottomSheetBpjs
import com.citiasia.inidesakubeta.ui.ppob.listrikAir.ListrikAirDialog.BottomSheetListrikAirDialog


class BpjsKesehatanFragment : Fragment() {

    private var _binding: FragmentBpjsKesehatanBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBpjsKesehatanBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpData()
    }

    private fun setUpData() = with(binding) {
        textPembayaran.addTextChangedListener(inputTextWatcher())
        spinPeriode.addTextChangedListener(inputTextWatcher())

        btnBayar.setOnClickListener {
            val jumlahBulan = extractNumericValue(spinPeriode.text.toString())
            val dialog = BottomSheetBpjs.newInstance(textPembayaran.text.toString(), jumlahBulan)

            dialog.show(parentFragmentManager, BottomSheetBpjs.TAG)
        }

    }

    fun extractNumericValue(input: String): Int {
        // Mengambil hanya karakter angka dari string
        val numericValue = input.filter { it.isDigit() }.toIntOrNull() ?: 0

        return numericValue
    }

    private fun inputTextWatcher(): TextWatcher {
        return object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
//                // Pemeriksaan apakah teks di kedua view sudah terisi
                with(binding) {
                    val isTextIdFilled = !textPembayaran.text.isNullOrBlank()
                    val isSpinPeriodeFilled = spinPeriode.text.toString() != resources.getString(R.string.periode_tagihan)

                    btnBayar.isEnabled = isTextIdFilled && isSpinPeriodeFilled
                }

            }
        }
    }

    private fun buttonEnable() {

    }



}