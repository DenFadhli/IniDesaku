package com.citiasia.inidesakubeta.ui.ppob

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.databinding.FragmentPpobBinding
import com.citiasia.inidesakubeta.ui.ppob.bpjs.BpjsActivity
import com.citiasia.inidesakubeta.ui.ppob.listrikAir.ListrikAirActivity
import com.citiasia.inidesakubeta.ui.ppob.pulsa.PulsaActivity

class PpobFragment : Fragment() {

    private var _binding: FragmentPpobBinding? = null
    private val binding get() = _binding !!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPpobBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        iconClick()
    }

    private fun iconClick() {
        with(binding) {
            btnPulsaPra.setOnClickListener {
                toPulsaActivity()
            }
            btnPulsaPasca.setOnClickListener {
                toPulsaActivity()
            }
            btnPaket.setOnClickListener {
                toPulsaActivity()
            }
            btnTelkom.setOnClickListener {
                toPulsaActivity()
            }

            btnPln.setOnClickListener {
                toListrikAirActivity()
            }

            btnPbjsKesehatan.setOnClickListener {
                toBpjsActivity()
            }
        }
    }

    private fun toBpjsActivity() {
        val intent = Intent(requireActivity(), BpjsActivity::class.java)
        startActivity(intent)
    }


    private fun toPulsaActivity() {
        val intent = Intent(requireActivity(), PulsaActivity::class.java)
        startActivity(intent)
    }

    private fun toListrikAirActivity() {
        val intent = Intent(requireActivity(), ListrikAirActivity::class.java)
        startActivity(intent)
    }


}