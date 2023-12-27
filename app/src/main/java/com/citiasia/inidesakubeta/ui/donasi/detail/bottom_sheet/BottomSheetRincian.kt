package com.citiasia.inidesakubeta.ui.donasi.detail.bottom_sheet

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.ui.donasi.detail.DonasiSelesaiActivity
import com.citiasia.inidesakubeta.utils.DonasiPreference
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.text.DecimalFormat

class BottomSheetRincian : BottomSheetDialogFragment() {
    private lateinit var btnBayar: Button
    private lateinit var iconClose: ImageView
    private lateinit var tvNominal: TextView
    private lateinit var tvTotal: TextView
    private lateinit var donasiPreference: DonasiPreference

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.bottom_sheet_rincian_donasi, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnBayar = view.findViewById(R.id.btn_bayar_rincian)
        iconClose = view.findViewById(R.id.ic_close)
        tvNominal = view.findViewById(R.id.tv_rincian_nominal_donasi_uang)
        tvTotal = view.findViewById(R.id.tv_rincian_total_biaya_uang)

        setData()

        iconClose.setOnClickListener {
            this.dismiss()
        }

        btnBayar.setOnClickListener {
            val intent = Intent(requireActivity(), DonasiSelesaiActivity::class.java)
            startActivity(intent)
            this@BottomSheetRincian.dismiss()
        }
    }

    private fun setData() {
        donasiPreference = DonasiPreference(requireContext())
        val nominal = donasiPreference.getData().total ?: "0"

        val formattedNominal = formatCurrency(nominal)

        tvNominal.text = "Rp $formattedNominal"

        val totalAmount = nominal.toIntOrNull() ?: 0
        val total = totalAmount + 2500

        val formattedTotal = formatCurrency(total.toString())

        tvTotal.text = "Rp $formattedTotal"
    }

    private fun formatCurrency(value: String): String {
        val formatter = DecimalFormat("#,###,###")
        val formattedValue = formatter.format(value.toInt())
        return "$formattedValue,00"
    }

    companion object {
        const val TAG = "BottomSheetDialog"
    }

}