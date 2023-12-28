package com.citiasia.inidesakubeta

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.citiasia.inidesakubeta.data.database.Berita
import com.citiasia.inidesakubeta.data.database.Budaya
import com.citiasia.inidesakubeta.data.database.Wisata
import com.citiasia.inidesakubeta.databinding.FragmentBudayaBinding
import com.citiasia.inidesakubeta.databinding.FragmentWisataBinding
import com.citiasia.inidesakubeta.ui.ViewModelFactory
import com.citiasia.inidesakubeta.ui.adapter.BigListBudayaAdapter
import com.citiasia.inidesakubeta.ui.adapter.BigListWisataAdapter
import com.citiasia.inidesakubeta.ui.adapter.ListBeritaAdapter
import com.citiasia.inidesakubeta.ui.adapter.SmallListBudayaAdapter
import com.citiasia.inidesakubeta.ui.adapter.SmallListWisataAdapter

class BudayaFragment : Fragment() {
    private var _binding: FragmentBudayaBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: ListBudayaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBudayaBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val vmFactory = ViewModelFactory(requireContext())
        viewModel = ViewModelProvider(
            requireActivity(),
            vmFactory
        ).get(ListBudayaViewModel::class.java)

        setDataRekomListAdapter("Rekomendasi")
        setDataSekitarListAdapter("Sekitar")
        setDataDicariListAdapter("Dicari")
        searchInput()

    }

    private fun setDataRekomListAdapter(text: String) {
        val data: List<Budaya> = viewModel.getBudayaData()

        val tempList = arrayListOf<Budaya>()

        var listAdapter = BigListBudayaAdapter(tempList)

        if (text.equals("Rekomendasi")) {
            listAdapter = BigListBudayaAdapter(data)
        }

        with(binding) {
            rvRekomBudaya.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            rvRekomBudaya.adapter = listAdapter

            listAdapter.setOnItemClickCallback(object : BigListBudayaAdapter.OnItemClickCallback{
                override fun onItemClicked(data: Budaya) {
                    val intent = Intent(requireActivity(), DetailBudayaActivity::class.java)
                    intent.putExtra("rekomendasi", data)
                    startActivity(intent)
                }
            })
        }
    }

    private fun setDataSekitarListAdapter(text: String) {
        val data: List<Budaya> = viewModel.getBudayaData()

        val tempList = arrayListOf<Budaya>()

        var listAdapter = SmallListBudayaAdapter(tempList)

        if (text.equals("Sekitar")) {
            listAdapter = SmallListBudayaAdapter(data)
        }

        with(binding) {
            rvBudayaSekitar.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            rvBudayaSekitar.adapter = listAdapter

            listAdapter.setOnItemClickCallback(object : SmallListBudayaAdapter.OnItemClickCallback{
                override fun onItemClicked(data: Budaya) {
                    val intent = Intent(requireActivity(), DetailBudayaActivity::class.java)
                    intent.putExtra("sekitar", data)
                    startActivity(intent)
                }
            })
        }
    }

    private fun setDataDicariListAdapter(text: String) {
        val data: List<Budaya> = viewModel.getBudayaData()

        val tempList = arrayListOf<Budaya>()

        var listAdapter = SmallListBudayaAdapter(tempList)

        if (text.equals("Dicari")) {
            listAdapter = SmallListBudayaAdapter(data)
        }

        with(binding) {
            rvBudayaBanyakDicari.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            rvBudayaBanyakDicari.adapter = listAdapter

            listAdapter.setOnItemClickCallback(object : SmallListBudayaAdapter.OnItemClickCallback{
                override fun onItemClicked(data: Budaya) {
                    val intent = Intent(requireActivity(), DetailBudayaActivity::class.java)
                    intent.putExtra("dicari", data)
                    startActivity(intent)
                }
            })
        }
    }

    private fun searchInput() {
        binding.svCariBudaya.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                searchData(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {
                if (s.isNullOrEmpty()) {
                    binding.textView14.visibility = View.VISIBLE
                    binding.textView15.visibility = View.VISIBLE
                    binding.layout1.visibility = View.VISIBLE
                    binding.textView16.visibility = View.VISIBLE
                    binding.layout2.visibility = View.VISIBLE
                } else {
                    binding.textView14.visibility = View.GONE
                    binding.textView15.visibility = View.GONE
                    binding.layout1.visibility = View.GONE
                    binding.textView16.visibility = View.GONE
                    binding.layout2.visibility = View.GONE
                }
            }

        })
    }

    private fun searchData(query: String) {
        val listData = viewModel.getBudayaData()

        val filteredList: List<Budaya> = listData.filter { budaya ->
            budaya.title.contains(query, ignoreCase = true)
        }

//        if (filteredList.isEmpty()){
//            binding.layoutSearchNotFound.visibility = View.VISIBLE
//        }else {
//            binding.layoutSearchNotFound.visibility = View.GONE
//        }

        val adapter = BigListBudayaAdapter(filteredList)

        with(binding){
            rvRekomBudaya.layoutManager = LinearLayoutManager(requireContext())
            rvRekomBudaya.adapter = adapter

            adapter.setOnItemClickCallback(object : BigListBudayaAdapter.OnItemClickCallback{
                override fun onItemClicked(data: Budaya) {
                    val intent = Intent(requireActivity(), DetailBudayaActivity::class.java)
                    intent.putExtra("rekomendasi", data)
                    startActivity(intent)
                }
            })
        }
    }

}