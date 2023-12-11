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
import com.citiasia.inidesakubeta.data.remote.model.DataPulsaUser
import com.citiasia.inidesakubeta.data.remote.model.PriceListDummy
import com.citiasia.inidesakubeta.data.remote.model.PulsaDataInput
import com.citiasia.inidesakubeta.ui.adapter.PulsaListAdapter
import com.citiasia.inidesakubeta.ui.ppob.pulsa.pulsaDialog.BottomSheetPulsa
import com.citiasia.inidesakubeta.utils.PulsaPreference

class PrabayarFragment : Fragment() {

    private var _binding: FragmentPrabayarBinding? = null
    private val binding get() = _binding!!

    private var priceList = mutableListOf<PriceListDummy>()
    private lateinit var prefNumber: PulsaPreference
    private val dialog = BottomSheetPulsa()

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
//        setUpParamDialog()

    }

    private fun setUpParamDialog() {

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

                var dataParam = DataPulsaUser(
                    PriceListDummy(
                        data.nominal,
                        data.tambahanHari,
                        data.harga
                    ), PulsaDataInput(
                        dataInputNumber.number,
                        dataInputNumber.provider
                        )
                )

                if(dataInputNumber.number.equals("")) {
                    Toast.makeText(requireContext(), "Nomor Anda tidak valid!", Toast.LENGTH_SHORT).show()
                } else {
                    showDialog(dataParam)
                }

            }
        })
    }

    private fun showDialog(dataParam: DataPulsaUser) {
        val bundle = Bundle()
        bundle.putParcelable(BottomSheetPulsa.TAG ,dataParam)
        dialog.arguments = bundle
        dialog.show(parentFragmentManager, BottomSheetPulsa.TAG)
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