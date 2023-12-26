package com.citiasia.inidesakubeta

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.citiasia.inidesakubeta.data.database.Berita
import com.citiasia.inidesakubeta.data.database.Wisata
import com.citiasia.inidesakubeta.databinding.FragmentBeritaBinding
import com.citiasia.inidesakubeta.databinding.FragmentWisataBinding
import com.citiasia.inidesakubeta.ui.ViewModelFactory
import com.citiasia.inidesakubeta.ui.adapter.BigListWisataAdapter
import com.citiasia.inidesakubeta.ui.adapter.ListBeritaAdapter
import com.citiasia.inidesakubeta.ui.adapter.SmallListWisataAdapter

class WisataFragment : Fragment() {

    private var _binding: FragmentWisataBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: ListWisataViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentWisataBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val vmFactory = ViewModelFactory(requireContext())
        viewModel = ViewModelProvider(
            requireActivity(),
            vmFactory
        ).get(ListWisataViewModel::class.java)

        setDataRekomListAdapter("Rekomendasi")
        setDataSekitarListAdapter("Sekitar")
        setDataDicariListAdapter("Dicari")

    }

    private fun setDataRekomListAdapter(text: String) {
        val data: List<Wisata> = viewModel.getWisataData()

        val tempList = arrayListOf<Wisata>()

        var listAdapter = BigListWisataAdapter(tempList)

        if (text.equals("Rekomendasi")) {
            listAdapter = BigListWisataAdapter(data)
        }

        with(binding) {
            rvRekomWisata.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            rvRekomWisata.adapter = listAdapter

            listAdapter.setOnItemClickCallback(object : BigListWisataAdapter.OnItemClickCallback{
                override fun onItemClicked(data: Wisata) {
                    val intent = Intent(requireActivity(), DetailWisataActivity::class.java)
                    intent.putExtra("rekomendasi", data)
                    startActivity(intent)
                }
            })
        }
    }

    private fun setDataSekitarListAdapter(text: String) {
        val data: List<Wisata> = viewModel.getWisataData()

        val tempList = arrayListOf<Wisata>()

        var listAdapter = SmallListWisataAdapter(tempList)

        if (text.equals("Sekitar")) {
            listAdapter = SmallListWisataAdapter(data)
        }

        with(binding) {
            rvWisataSekitar.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            rvWisataSekitar.adapter = listAdapter

            listAdapter.setOnItemClickCallback(object : SmallListWisataAdapter.OnItemClickCallback{
                override fun onItemClicked(data: Wisata) {
                    val intent = Intent(requireActivity(), DetailWisataActivity::class.java)
                    intent.putExtra("sekitar", data)
                    startActivity(intent)
                }
            })
        }
    }

    private fun setDataDicariListAdapter(text: String) {
        val data: List<Wisata> = viewModel.getWisataData()

        val tempList = arrayListOf<Wisata>()

        var listAdapter = SmallListWisataAdapter(tempList)

        if (text.equals("Dicari")) {
            listAdapter = SmallListWisataAdapter(data)
        }

        with(binding) {
            rvWisataBanyakDicari.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            rvWisataBanyakDicari.adapter = listAdapter

            listAdapter.setOnItemClickCallback(object : SmallListWisataAdapter.OnItemClickCallback{
                override fun onItemClicked(data: Wisata) {
                    val intent = Intent(requireActivity(), DetailWisataActivity::class.java)
                    intent.putExtra("dicari", data)
                    startActivity(intent)
                }
            })
        }
    }

}