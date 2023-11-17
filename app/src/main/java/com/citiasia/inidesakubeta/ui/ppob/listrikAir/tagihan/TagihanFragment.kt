package com.citiasia.inidesakubeta.ui.ppob.listrikAir.tagihan

import android.os.Bundle
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

    private val dialog = BottomSheetListrikAirDialog()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTagihanBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onclickButton()
    }

    private fun onclickButton() {
        with(binding) {
            btnNext.setOnClickListener {
                dialog.show(parentFragmentManager, BottomSheetListrikAirDialog.TAG)
            }
        }
    }

}