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
import com.citiasia.inidesakubeta.data.database.DetailPotensiFisik
import com.citiasia.inidesakubeta.data.database.PotensiFisik
import com.citiasia.inidesakubeta.databinding.FragmentBeritaBinding
import com.citiasia.inidesakubeta.databinding.FragmentPotensiFisikBinding
import com.citiasia.inidesakubeta.ui.ViewModelFactory
import com.citiasia.inidesakubeta.ui.adapter.BigListPotensiFisikAdapter
import com.citiasia.inidesakubeta.ui.adapter.ListBeritaAdapter

class PotensiFisikFragment : Fragment() {
    private var _binding: FragmentPotensiFisikBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: ListPotensiFisikViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPotensiFisikBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val vmFactory = ViewModelFactory(requireContext())
        viewModel = ViewModelProvider(
            requireActivity(),
            vmFactory
        ).get(ListPotensiFisikViewModel::class.java)

        setDataListAdapter("Semua")

    }

    private fun setDataListAdapter(text: String) {
        val data: List<PotensiFisik> = viewModel.getPotensiFisikData()

        val tempList = arrayListOf<PotensiFisik>()

        var listAdapter = BigListPotensiFisikAdapter(tempList)

        if (text.equals("Semua")) {
            listAdapter = BigListPotensiFisikAdapter(data)
        }

        with(binding) {
            rvListPotensiFisik.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            rvListPotensiFisik.adapter = listAdapter

            listAdapter.setOnItemClickCallback(object : BigListPotensiFisikAdapter.OnItemClickCallback{
                override fun onItemClicked(data: PotensiFisik) {
                    val intent = Intent(requireActivity(), DetailPotensiFisikActivity::class.java)
                    intent.putExtra("potensi", data)
                    startActivity(intent)
                }
            })
        }
    }

}