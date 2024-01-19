package com.citiasia.inidesakubeta.ui.geografi.geospasial

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.databinding.FragmentGeospasialBinding
import com.citiasia.inidesakubeta.ui.bantuan.BantuanFormFragment
import com.citiasia.inidesakubeta.ui.geografi.geotagging.GeotaggingFragment
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment

class GeospasialFragment : Fragment(), OnMapReadyCallback {

    private var _binding: FragmentGeospasialBinding? = null
    private val binding get() = _binding !!

    private lateinit var mMap: GoogleMap

    private var selectedLocation: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentGeospasialBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mapFragment = childFragmentManager.findFragmentById(R.id.map_container) as SupportMapFragment
        mapFragment.getMapAsync(this)

        val locationItems = resources.getStringArray(R.array.geospasial)
        val adapterLocation = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, locationItems)
        binding.spinLocation.setAdapter(adapterLocation)

        binding.spinLocation.setOnItemClickListener { _, _, position, _ ->
            selectedLocation = locationItems[position]
        }

        binding.btnGeotagging.setOnClickListener {
            val fragment = GeotaggingFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_layout, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.uiSettings.isZoomControlsEnabled = true
        mMap.uiSettings.isIndoorLevelPickerEnabled = true
        mMap.uiSettings.isCompassEnabled = true
        mMap.uiSettings.isMapToolbarEnabled = true
        mMap.uiSettings.isZoomControlsEnabled = false
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_layout, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}