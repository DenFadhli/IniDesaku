package com.citiasia.inidesakubeta.ui.ppob.bpjs.kesehatan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.databinding.FragmentBpjsKesehatanBinding
import com.citiasia.inidesakubeta.ui.adapter.BulanTahunAdapter
import com.citiasia.inidesakubeta.ui.adapter.PulsaListAdapter
import com.citiasia.inidesakubeta.ui.ppob.bpjs.bpjsDialog.BottomSheetBpjs
import com.citiasia.inidesakubeta.ui.ppob.listrikAir.ListrikAirDialog.BottomSheetListrikAirDialog


class BpjsKesehatanFragment : Fragment() {

    private var _binding: FragmentBpjsKesehatanBinding? = null
    private val binding get() = _binding!!

    private val dialog = BottomSheetBpjs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBpjsKesehatanBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpAdapter()
    }

    private fun setUpAdapter() {
        var adapter = BulanTahunAdapter(resources.getStringArray(R.array.bulan_items))
        binding.apply {
            rvKesehatanPbjs.layoutManager = GridLayoutManager(requireActivity(), 2)
            rvKesehatanPbjs.adapter = adapter
        }

        adapter.setOnItemClickCallback(object : BulanTahunAdapter.OnItemClickCallback{
            override fun onItemClicked(data: String) {
                Toast.makeText(requireContext(), "Anda memilih $data", Toast.LENGTH_SHORT).show()

                dialog.show(parentFragmentManager, BottomSheetBpjs.TAG)
            }

        })
    }


}