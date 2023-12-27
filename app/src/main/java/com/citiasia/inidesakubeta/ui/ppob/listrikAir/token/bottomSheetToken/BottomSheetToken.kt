package com.citiasia.inidesakubeta.ui.ppob.listrikAir.token.bottomSheetToken

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.viewbinding.ViewBindings
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.ui.ppob.bpjs.bpjsDialog.BottomSheetBpjs
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.citiasia.inidesakubeta.databinding.BottomSheetTokenBinding
import com.citiasia.inidesakubeta.ui.konfirmasi.KonfirmasiActivity
import com.citiasia.inidesakubeta.utils.DataJenisPembayaranPreference

class BottomSheetToken: BottomSheetDialogFragment() {

    private var _binding: BottomSheetTokenBinding? = null
    private val binding get() = _binding!!

    private lateinit var pref: DataJenisPembayaranPreference

    private var jumlahIuran: String? = null
    private var total: String? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        jumlahIuran = arguments?.getString(JUMLAH_IURAN)
        total = arguments?.getString(TOTAL_HARGA)
        _binding = BottomSheetTokenBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pref = DataJenisPembayaranPreference(requireContext())

        setUpData()
    }

    private fun setUpData() = with(binding) {
        tvJumlahIuranValue.text = jumlahIuran
        tvTotalValue.text = total

        btnBayar.setOnClickListener {
            pref.saveData("token", jumlahIuran!!, total!!)

            val intent = Intent(requireActivity(), KonfirmasiActivity::class.java)
            startActivity(intent)
            this@BottomSheetToken.dismiss()
        }

        iconCross.setOnClickListener {
            this@BottomSheetToken.dismiss()
        }
    }

    companion object {
        const val TAG = "BottomSheetToken"
        private const val JUMLAH_IURAN = "jumlah_iuran"
        private const val TOTAL_HARGA = "total_harga"

        fun newInstance(param1: String, param2: String): BottomSheetToken {
            val fragment = BottomSheetToken()
            val args = Bundle()
            args.putString(JUMLAH_IURAN, param1)
            args.putString(TOTAL_HARGA, param2)
            fragment.arguments = args
            return fragment
        }
    }
}