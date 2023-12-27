package com.citiasia.inidesakubeta.ui.ppob.listrikAir.token

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.citiasia.inidesakubeta.data.remote.dummyObject.PricePPOB
import com.citiasia.inidesakubeta.data.remote.model.PriceListDummy
import com.citiasia.inidesakubeta.databinding.FragmentTokenBinding
import com.citiasia.inidesakubeta.ui.adapter.TokenListAdapter
import com.citiasia.inidesakubeta.ui.ppob.listrikAir.token.bottomSheetToken.BottomSheetToken

class TokenFragment : Fragment() {

    private var _binding: FragmentTokenBinding? = null
    private val binding get() = _binding!!

    private val data = PricePPOB.getTokenList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTokenBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupData()
    }

    private fun setupData() = with(binding) {
        val adapter = TokenListAdapter(data)

        rvToken.layoutManager = GridLayoutManager(requireActivity(), 2)
        rvToken.adapter = adapter

        adapter.setOnItemClickCallback(object : TokenListAdapter.OnItemClickCallback {
            override fun onItemClicked(data: PriceListDummy) {
                val builder = StringBuilder()
                val harga = builder.append("Rp. ")
                    .append(data.nominal)
                    .append(",00")

                val builder2 = StringBuilder()
                val total = builder2.append("Rp. ")
                    .append(data.harga)
                    .append("0")

                val dialog = BottomSheetToken.newInstance(harga.toString(), total.toString())
                dialog.show(parentFragmentManager, BottomSheetToken.TAG)
            }

        })
    }

}