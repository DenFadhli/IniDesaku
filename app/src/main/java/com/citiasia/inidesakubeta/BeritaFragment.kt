package com.citiasia.inidesakubeta

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.citiasia.inidesakubeta.data.database.Berita
import com.citiasia.inidesakubeta.data.remote.model.ResponseTvcc
import com.citiasia.inidesakubeta.databinding.FragmentBeritaBinding
import com.citiasia.inidesakubeta.databinding.FragmentPrabayarBinding
import com.citiasia.inidesakubeta.ui.ViewModelFactory
import com.citiasia.inidesakubeta.ui.adapter.ListBeritaAdapter
import com.citiasia.inidesakubeta.ui.adapter.TvccListAdapter
import com.citiasia.inidesakubeta.ui.tvcc.tvccHome.TvccFrontViewModel

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

}