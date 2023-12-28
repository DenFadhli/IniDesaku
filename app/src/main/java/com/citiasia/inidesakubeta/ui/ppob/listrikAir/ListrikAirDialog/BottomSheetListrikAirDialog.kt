package com.citiasia.inidesakubeta.ui.ppob.listrikAir.ListrikAirDialog


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
import com.citiasia.inidesakubeta.ui.ppob.bpjs.bpjsDialog.BottomSheetBpjs
import com.citiasia.inidesakubeta.utils.DataJenisPembayaranPreference
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetListrikAirDialog: BottomSheetDialogFragment() {

    private lateinit var mIdPelanggan: TextView
    private lateinit var mJumlahIuran: TextView
    private lateinit var mTotal: TextView
    private lateinit var mButtonBayar: Button
    private lateinit var mIconCross: ImageView

    private var idPelanggan: String? = null

    private lateinit var pref: DataJenisPembayaranPreference

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        idPelanggan = arguments?.getString(ID_PELANGGAN)

        return inflater.inflate(R.layout.bottom_sheet_listrik_air_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mIdPelanggan = view.findViewById(R.id.tvIdPelangganValue)
        mJumlahIuran = view.findViewById(R.id.tvJumlahIuranValue)
        mTotal = view.findViewById(R.id.tvTotalValue)
        mButtonBayar = view.findViewById(R.id.btnBayar)
        mIconCross = view.findViewById(R.id.iconCross)

        mIconCross.setOnClickListener {
            this@BottomSheetListrikAirDialog.dismiss()
        }

        pref = DataJenisPembayaranPreference((requireContext()))

        setUpData()

    }

    private fun setUpData() {
        mIdPelanggan.text = idPelanggan

        mButtonBayar.setOnClickListener {
            pref.saveData("tagihan", mJumlahIuran.text.toString(), mTotal.text.toString())

            val intent = Intent(requireActivity(), KonfirmasiActivity::class.java)
            startActivity(intent)

            this@BottomSheetListrikAirDialog.dismiss()
        }
    }


    companion object {
        const val TAG = "BottomSheetListrikAirDialog"
        private const val ID_PELANGGAN = "id_pelanggan"

        fun newInstance(param1: String): BottomSheetListrikAirDialog {
            val fragment = BottomSheetListrikAirDialog()
            val args = Bundle()
            args.putString(ID_PELANGGAN, param1)
            fragment.arguments = args
            return fragment
        }
    }

}