package com.citiasia.inidesakubeta.ui.pesona

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.citiasia.inidesakubeta.data.database.PotensiNonFisik
import com.citiasia.inidesakubeta.databinding.FragmentPotensiNonfisikBinding
import com.citiasia.inidesakubeta.ui.ViewModelFactory
import com.citiasia.inidesakubeta.ui.adapter.ListPotensiNonFisikAdapter

class PotensiNonfisikFragment : Fragment() {
    private var _binding: FragmentPotensiNonfisikBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: ListPotensiNonFisikViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPotensiNonfisikBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val vmFactory = ViewModelFactory(requireContext())
        viewModel = ViewModelProvider(
            requireActivity(),
            vmFactory
        ).get(ListPotensiNonFisikViewModel::class.java)

        setDataListAdapter("Semua")

    }

    private fun setDataListAdapter(text: String) {
        val data: List<PotensiNonFisik> = viewModel.getPotensiNonFisikData()

        val tempList = arrayListOf<PotensiNonFisik>()

        var listAdapter = ListPotensiNonFisikAdapter(tempList)

        if (text.equals("Semua")) {
            listAdapter = ListPotensiNonFisikAdapter(data)
        }

        with(binding) {
            rvListPotensiNonfisik.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            rvListPotensiNonfisik.adapter = listAdapter

//            listAdapter.setOnItemClickCallback(object : ListPotensiNonFisikAdapter.OnItemClickCallback{
//                override fun onItemClicked(data: PotensiNonFisik) {
//                    val intent = Intent(requireActivity(), DetailPotensiFisikActivity::class.java)
//                    intent.putExtra("potensi", data)
//                    startActivity(intent)
//                }
//            })
        }
    }

}