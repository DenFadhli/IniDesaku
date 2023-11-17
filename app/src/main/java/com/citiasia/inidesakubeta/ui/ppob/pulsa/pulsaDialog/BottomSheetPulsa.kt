package com.citiasia.inidesakubeta.ui.ppob.pulsa.pulsaDialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.model.DataPulsaUser
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetPulsa : BottomSheetDialogFragment() {

    lateinit var mNumberPhone: TextView
    lateinit var mNominal: TextView
    lateinit var mNominalValue: TextView
    lateinit var mPajak: TextView
    lateinit var mTotal: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.bottom_sheet_pulsa, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data = arguments?.getParcelable<DataPulsaUser>(TAG)

        mNumberPhone = view.findViewById(R.id.tvNumberPhone)
        mNominal = view.findViewById(R.id.tvNominal)
        mNominalValue = view.findViewById(R.id.tvNominalValue)
        mPajak = view.findViewById(R.id.tvPajakValue)
        mTotal = view.findViewById(R.id.tvTotalValue)

        if(data != null) {
            setData(data)
        }

    }

    private fun setData(data: DataPulsaUser) {
        mNumberPhone.text = data.dataUserPhoneChoose.number
        mNominal.text = "Pulsa ${data.dataPaket.nominal}"
        mNominalValue.text = "Rp. ${data.dataPaket.nominal}"
//        mPajak.text = data.dataPaket.tambahanHari.toString()
        mTotal.text = "Rp. ${data.dataPaket.harga.toInt()}"
    }

    companion object {
        const val TAG = "BottomSheetDialog"
    }
}