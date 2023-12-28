package com.citiasia.inidesakubeta.ui.ppob.pulsa.pulsaDialog

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.data.remote.model.DataPulsaUser
import com.citiasia.inidesakubeta.ui.konfirmasi.KonfirmasiActivity
import com.citiasia.inidesakubeta.ui.ppob.bpjs.BpjsActivity
import com.citiasia.inidesakubeta.utils.PulsaPreference
import com.citiasia.inidesakubeta.utils.DataJenisPembayaranPreference
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetPulsa : BottomSheetDialogFragment() {

    lateinit var mImgProvider: ImageView
    lateinit var mIconCross: ImageView
    lateinit var mNumberPhone: TextView
    lateinit var mNominal: TextView
    lateinit var mNominalValue: TextView
    lateinit var mPajak: TextView
    lateinit var mTotal: TextView
    lateinit var mBtnBayar: Button

    private lateinit var pref: DataJenisPembayaranPreference

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.bottom_sheet_pulsa, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data = arguments?.getParcelable<DataPulsaUser>(TAG)

        mImgProvider = view.findViewById(R.id.imgProvider)
        mIconCross = view.findViewById(R.id.iconCross)
        mNumberPhone = view.findViewById(R.id.tvNumberPhone)
        mNominal = view.findViewById(R.id.tvNominal)
        mNominalValue = view.findViewById(R.id.tvNominalValue)
        mPajak = view.findViewById(R.id.tvPajakValue)
        mTotal = view.findViewById(R.id.tvTotalValue)
        mBtnBayar = view.findViewById<Button>(R.id.btnBayar)

        pref = DataJenisPembayaranPreference(requireContext())

        mBtnBayar.setOnClickListener {
            val intent = Intent(requireActivity(), KonfirmasiActivity::class.java)
            intent.putExtra("PIN_PAGE", "PULSA")
            startActivity(intent)
            this@BottomSheetPulsa.dismiss()
        }

        if(data != null) {
            setData(data)
        }

        mIconCross.setOnClickListener {
            this@BottomSheetPulsa.dismiss()
        }

    }

    private fun setData(data: DataPulsaUser) {
        val number = data.dataUserPhoneChoose.number
        val numberPhone = stringApprend("0", number.toString(), null)
        val harga = stringApprend("Rp.", data.dataPaket.nominal, ",00")
        val total = stringApprend("Rp.", data.dataPaket.harga.toInt().toString(), ",00")

        mNumberPhone.text = numberPhone
        mNominalValue.text = harga
//        mPajak.text = data.dataPaket.tambahanHari.toString()
        mTotal.text = total

        when (numberPhone.substring(0, 4)) {
            "0852", "0853", "0811", "0812", "0813", "0821", "0822", "0851" -> mImgProvider.setImageResource(R.drawable.telkomsel_icon)
            "0881", "0882", "0883", "0884", "0885", "0886", "0887", "0888", "0889" -> mImgProvider.setImageResource(R.drawable.smartfren_icon)
            "0896", "0895", "0897", "0898", "0899"-> mImgProvider.setImageResource(R.drawable.tri_icon)
            "0817", "0818", "0819", "0859", "0877", "0878"-> mImgProvider.setImageResource(R.drawable.xl_icon)
            "0832", "0833", "0838"-> mImgProvider.setImageResource(R.drawable.axis_icon)
            "0857", "0856" -> mImgProvider.setImageResource(R.drawable.imthree_icon)
            else -> mImgProvider.setImageResource(R.drawable.tri_icon)
        }

        pref.saveData("Pulsa", harga, total)
    }

    private fun stringApprend(string1: String, string2: String, string3: String?) : String {
        val builder = StringBuilder()

        if (string3 != null) {
            builder.append(string1).append(string2).append(string3)
        } else {
            builder.append(string1).append(string2)
        }

        return builder.toString()
    }
    companion object {
        const val TAG = "BottomSheetDialog"
    }
}