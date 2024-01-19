package com.citiasia.inidesakubeta.ui.geografi.geotagging

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.databinding.FragmentGeospasialBinding
import com.citiasia.inidesakubeta.databinding.FragmentGeotaggingBinding


class GeotaggingFragment : Fragment() {

    private var _binding: FragmentGeotaggingBinding? = null
    private val binding get() = _binding !!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentGeotaggingBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_layout, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}