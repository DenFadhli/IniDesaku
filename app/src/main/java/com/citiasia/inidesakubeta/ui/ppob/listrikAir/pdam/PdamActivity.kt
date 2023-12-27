package com.citiasia.inidesakubeta.ui.ppob.listrikAir.pdam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.databinding.ActivityPdamBinding
import com.citiasia.inidesakubeta.ui.ppob.listrikAir.ListrikAirDialog.BottomSheetListrikAirDialog

class PdamActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPdamBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPdamBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpdata()
    }

    private fun setUpdata() = with(binding){
        textId.addTextChangedListener(inputTextWatcher())
        spinWilayah.addTextChangedListener(inputTextWatcher())

        btnBayar.setOnClickListener {
            val dialog = BottomSheetPdam.newInstance(textId.text.toString())

            dialog.show(supportFragmentManager, BottomSheetPdam.TAG)
        }

        topAppBar.setNavigationOnClickListener {
            super.onBackPressed()
        }
    }

    private fun inputTextWatcher(): TextWatcher {
        return object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                // Pemeriksaan apakah teks di kedua view sudah terisi
                with(binding) {
                    val isTextIdFilled = !textId.text.isNullOrBlank()
                    val isSpinPeriodeFilled = spinWilayah.text.toString() != resources.getString(R.string.pilih_wilayah_anda)

                    btnBayar.isEnabled = isTextIdFilled && isSpinPeriodeFilled
                }

            }
        }
    }
}