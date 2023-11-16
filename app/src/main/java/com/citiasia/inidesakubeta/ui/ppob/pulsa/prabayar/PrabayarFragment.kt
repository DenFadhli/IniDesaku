package com.citiasia.inidesakubeta.ui.ppob.pulsa.prabayar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.databinding.FragmentPrabayarBinding
import com.citiasia.inidesakubeta.model.PriceListDummy
import com.citiasia.inidesakubeta.ui.adapter.PulsaListAdapter
import com.citiasia.inidesakubeta.utils.PulsaPreference

class PrabayarFragment : Fragment() {

    private var _binding: FragmentPrabayarBinding? = null
    private val binding get() = _binding!!

    private var priceList = mutableListOf<PriceListDummy>()
    private lateinit var prefNumber: PulsaPreference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPrabayarBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        priceList = ArrayList()
        prefNumber = PulsaPreference(requireContext())
        prepareDataList()
        setUpAdapter()

    }

    private fun setUpAdapter() {
        var adapter = PulsaListAdapter(priceList)
        binding.apply {
            rvPulsa.layoutManager = GridLayoutManager(requireActivity(), 2)
            rvPulsa.adapter = adapter
        }

        adapter.setOnItemClickCallback(object : PulsaListAdapter.OnItemClickCallback{
            override fun onItemClicked(data: PriceListDummy) {
                val dataInputNumber = prefNumber.getData()
                Toast.makeText(requireContext(), "${data.nominal} ${dataInputNumber.number}", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun prepareDataList() {
        var list = PriceListDummy("15.000", 12, 17000.0)
        priceList.add(list)
        list = PriceListDummy("20.000", 20, 22000.0)
        priceList.add(list)
        list = PriceListDummy("25.000", 22, 27000.0)
        priceList.add(list)
        list = PriceListDummy("15.000", 12, 17000.0)
        priceList.add(list)
        list = PriceListDummy("20.000", 20, 22000.0)
        priceList.add(list)
        list = PriceListDummy("25.000", 22, 27000.0)
        priceList.add(list)
        list = PriceListDummy("15.000", 12, 17000.0)
        priceList.add(list)
        list = PriceListDummy("20.000", 20, 22000.0)
        priceList.add(list)
        list = PriceListDummy("25.000", 22, 27000.0)
        priceList.add(list)
        list = PriceListDummy("20.000", 20, 22000.0)
        priceList.add(list)
        list = PriceListDummy("25.000", 22, 27000.0)
        priceList.add(list)
        list = PriceListDummy("20.000", 20, 22000.0)
        priceList.add(list)
        list = PriceListDummy("25.000", 22, 27000.0)
        priceList.add(list)

    }

}