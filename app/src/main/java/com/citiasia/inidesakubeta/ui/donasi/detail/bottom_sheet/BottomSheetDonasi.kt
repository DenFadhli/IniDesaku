package com.citiasia.inidesakubeta.ui.donasi.detail.bottom_sheet

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.data.remote.model.DonasiInput
import com.citiasia.inidesakubeta.ui.customView.CustomInputEditText
import com.citiasia.inidesakubeta.ui.donasi.detail.DonasiSelesaiActivity
import com.citiasia.inidesakubeta.utils.DonasiPreference
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.textview.MaterialTextView

class BottomSheetDonasi : BottomSheetDialogFragment() {
    private lateinit var btnDonasi: Button
    private lateinit var iconClose: ImageView
    private lateinit var inputName: CustomInputEditText
    private lateinit var inputTotal : CustomInputEditText
    private lateinit var donasiPreference: DonasiPreference
    private val dialog = BottomSheetRincian()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.bottom_sheet_donasi, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnDonasi = view.findViewById(R.id.btn_donasi_sheet)
        iconClose = view.findViewById(R.id.ic_close)
        inputName = view.findViewById(R.id.tv_nama_donasi)
        inputTotal = view.findViewById(R.id.text_nominal_donasi)

        checkInput()

        btnDonasi.setOnClickListener {
            showDialog()
        }

        iconClose.setOnClickListener {
            this.dismiss()
        }
    }

    private fun checkInput() {


        inputName.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                checkEnabledButton()
            }
        })

        inputTotal.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                val totalText = p0.toString().trim()

                if (totalText.isEmpty()) {
                    Toast.makeText(requireContext(), "Masukkan jumlah donasi Anda", Toast.LENGTH_SHORT).show()
                } else {
                    val totalAmount = totalText.toIntOrNull() ?: 0

                    if (totalAmount < 5000) {
                        Toast.makeText(requireContext(), "Jumlah donasi minimal Rp 5000", Toast.LENGTH_SHORT).show()
                    } else {
                        checkEnabledButton()
                    }
                }
            }

        })
    }

    private fun checkEnabledButton() {
        val isNameFilled = inputName.text.toString().isNotBlank()
        val isTotalFilled = inputTotal.text.toString().isNotBlank()

        btnDonasi.isEnabled = isNameFilled && isTotalFilled
    }

    private fun saveData(){
        donasiPreference = DonasiPreference(requireContext())
        val total = inputTotal.text.toString()
        val input = DonasiInput(total = total)
        donasiPreference.saveData(input)
    }

    private fun showDialog() {
        saveData()
        dialog.show(parentFragmentManager, BottomSheetRincian.TAG)
        this.dismiss()
    }

    companion object {
        const val TAG = "BottomSheetDialog"
    }
}
