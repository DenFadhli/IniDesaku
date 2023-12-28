package com.citiasia.inidesakubeta.ui.ppob.bpjs.bpjsDialog


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.ui.konfirmasi.KonfirmasiActivity
import com.citiasia.inidesakubeta.utils.DataJenisPembayaranPreference
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.text.DateFormatSymbols
import java.util.Calendar

class BottomSheetBpjs: BottomSheetDialogFragment() {

    private lateinit var mIdTransaksi: TextView
    private lateinit var mNoVa: TextView
    private lateinit var mJumlahBulan: TextView
    private lateinit var mBulan: TextView
    private lateinit var mJumlahIuran: TextView
    private lateinit var mTotal: TextView
    private lateinit var mButtonBayar: Button
    private lateinit var mIconCross: ImageView

    private var idTransaksi: String? = null
    private var jumlahBulan: Int? = null

    private lateinit var pref: DataJenisPembayaranPreference

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        idTransaksi = arguments?.getString(ID_TRANSAKSI)
        jumlahBulan = arguments?.getInt(JUMLAH_BULAN)

        return inflater.inflate(R.layout.bottom_sheet_bpjs, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mIdTransaksi = view.findViewById(R.id.tvIdTransaksiValue)
        mNoVa = view.findViewById(R.id.tvNomorVaValue)
        mJumlahBulan = view.findViewById(R.id.tvJumlahBulanValue)
        mBulan = view.findViewById(R.id.tvBulanValue)
        mJumlahIuran = view.findViewById(R.id.tvJumlahIuranValue)
        mTotal = view.findViewById(R.id.tvTotalValue)
        mButtonBayar = view.findViewById(R.id.btnBayar)
        mIconCross = view.findViewById(R.id.iconCross)

        mIconCross.setOnClickListener {
            this@BottomSheetBpjs.dismiss()
        }

        pref = DataJenisPembayaranPreference((requireContext()))

        setUpData()
    }

    private fun setUpData() {
        mIdTransaksi.text = idTransaksi
        mNoVa.text = idTransaksi
        mJumlahBulan.text = jumlahBulan.toString()
        mBulan.text = getDataBulan(jumlahBulan!!)

        val harga = 60 * jumlahBulan!!
        val total = harga + 2
        mJumlahIuran.text = toRupiah(harga)
        mTotal.text = toRupiah(total)

        mButtonBayar.setOnClickListener {
            pref.saveData("BPJS", toRupiah(harga), toRupiah(total))

            val intent = Intent(requireActivity(), KonfirmasiActivity::class.java)
            startActivity(intent)
            this@BottomSheetBpjs.dismiss()
        }
    }

    private fun toRupiah(nilai: Int) : String {
        return "Rp. $nilai.000,00"
    }

    private fun getDataBulan(jumlah: Int) : String {
        val calendar = Calendar.getInstance()

        val monthList = mutableListOf<String>()

        for (i in 0 until jumlah) {
            val monthName = DateFormatSymbols().months[calendar.get(Calendar.MONTH)]
            monthList.add(monthName)

            calendar.add(Calendar.MONTH, 1)
        }

        val result = monthList.joinToString(", ")

        return result
    }
    companion object {
        const val TAG = "BottomSheetBpjsDialog"
        private const val ID_TRANSAKSI = "id_transaksi"
        private const val JUMLAH_BULAN = "jumlah_bulan"

        fun newInstance(param1: String, param2: Int): BottomSheetBpjs {
            val fragment = BottomSheetBpjs()
            val args = Bundle()
            args.putString(ID_TRANSAKSI, param1)
            args.putInt(JUMLAH_BULAN, param2)
            fragment.arguments = args
            return fragment
        }
    }

}