package com.citiasia.inidesakubeta.ui.ppob.lainnya.telkom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.databinding.ActivityTelkomBinding
import com.citiasia.inidesakubeta.ui.ppob.listrikAir.ListrikAirDialog.BottomSheetListrikAirDialog

class TelkomActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTelkomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelkomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpView()
        onclickButton()
    }

    private fun setUpView() = with(binding) {
        textId.addTextChangedListener(object : TextWatcher {
            val delay: Long = 1000
            val handler: Handler = Handler(Looper.getMainLooper())

            private val inputFinishChecker = Runnable {
                if (textId.text!!.length <= 14) {
                    layoutId.error = resources.getString(R.string.id_inpur_wrong)
                    btnNext.isEnabled = false
                } else {
                    layoutId.isErrorEnabled = false
                    btnNext.isEnabled = !textId.text.isNullOrBlank()
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                handler.removeCallbacks(inputFinishChecker)
            }

            override fun afterTextChanged(s: Editable?) {
                if (s.toString().isNotEmpty()) {
                    handler.postDelayed(inputFinishChecker, delay)
                }
//                btnNext.isEnabled = !textId.text.isNullOrBlank()
            }

        })
    }

    private fun onclickButton() = with(binding) {
        btnNext.setOnClickListener {
            val dialog = BottomSheetListrikAirDialog.newInstance(textId.text.toString())

            dialog.show(supportFragmentManager, BottomSheetListrikAirDialog.TAG)
        }

        topAppBar.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}