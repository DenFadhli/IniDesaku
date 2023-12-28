package com.citiasia.inidesakubeta.ui.pesona

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
import com.citiasia.inidesakubeta.databinding.FragmentBeritaBinding
import com.citiasia.inidesakubeta.ui.ViewModelFactory
import com.citiasia.inidesakubeta.ui.adapter.ListBeritaAdapter

class BeritaFragment : Fragment() {

    private var _binding: FragmentBeritaBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: ListBeritaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBeritaBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val vmFactory = ViewModelFactory(requireContext())
        viewModel = ViewModelProvider(
            requireActivity(),
            vmFactory
        ).get(ListBeritaViewModel::class.java)

        setDataListAdapter("Semua")
        searchInput()

    }

    private fun setDataListAdapter(text: String) {
        val data: List<Berita> = viewModel.getBeritaData()

        val tempList = arrayListOf<Berita>()

        var listAdapter = ListBeritaAdapter(tempList)

        if (text.equals("Semua")) {
            listAdapter = ListBeritaAdapter(data)
        }

        with(binding) {
            rvListBerita.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            rvListBerita.adapter = listAdapter

            listAdapter.setOnItemClickCallback(object : ListBeritaAdapter.OnItemClickCallback{
                override fun onItemClicked(data: Berita) {
                    val intent = Intent(requireActivity(), DetailBeritaActivity::class.java)
                    intent.putExtra("berita", data)
                    startActivity(intent)
                }
            })
        }
    }

    private fun searchInput() {
        binding.svCariBerita.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                searchData(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {
//                if (s.isNullOrEmpty()) {
//                    binding.frameLayout.visibility = View.GONE
//                    binding.scrollHorizontal.visibility = View.VISIBLE
//                } else {
//                    binding.frameLayout.visibility = View.VISIBLE
//                    binding.scrollHorizontal.visibility = View.GONE
//                }
            }

        })
    }

    private fun searchData(query: String) {
        val listData = viewModel.getBeritaData()

        val filteredList: List<Berita> = listData.filter { berita ->
            berita.title.contains(query, ignoreCase = true)
        }

//        if (filteredList.isEmpty()){
//            binding.layoutSearchNotFound.visibility = View.VISIBLE
//        }else {
//            binding.layoutSearchNotFound.visibility = View.GONE
//        }

        val adapter = ListBeritaAdapter(filteredList)

        with(binding){
            rvListBerita.layoutManager = LinearLayoutManager(requireContext())
            rvListBerita.adapter = adapter

            adapter.setOnItemClickCallback(object : ListBeritaAdapter.OnItemClickCallback{
                override fun onItemClicked(data: Berita) {
                    val intent = Intent(requireActivity(), DetailBeritaActivity::class.java)
                    intent.putExtra("berita", data)
                    startActivity(intent)
                }
            })
        }
    }

}