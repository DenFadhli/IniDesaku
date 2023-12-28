package com.citiasia.inidesakubeta.ui.ppob.listrikAir.tagihan

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.databinding.FragmentTagihanBinding
import com.citiasia.inidesakubeta.ui.ppob.listrikAir.ListrikAirDialog.BottomSheetListrikAirDialog
import com.citiasia.inidesakubeta.ui.ppob.pulsa.pulsaDialog.BottomSheetPulsa

class TagihanFragment : Fragment() {

    private var _binding: FragmentTagihanBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTagihanBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpView()
        onclickButton()
    }

    private fun setUpView() = with(binding) {
        textId.addTextChangedListener(object : TextWatcher{
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

    private fun onclickButton() {
        with(binding) {
            btnNext.setOnClickListener {
                val dialog = BottomSheetListrikAirDialog.newInstance(textId.text.toString())

                dialog.show(parentFragmentManager, BottomSheetListrikAirDialog.TAG)
            }
        }
    }

}