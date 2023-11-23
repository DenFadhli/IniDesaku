package com.citiasia.inidesakubeta.ui.ppob.bpjs.bpjsDialog


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.citiasia.inidesakubeta.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetBpjs: BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.bottom_sheet_bpjs, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    companion object {
        const val TAG = "BottomSheetBpjsDialog"
    }
}