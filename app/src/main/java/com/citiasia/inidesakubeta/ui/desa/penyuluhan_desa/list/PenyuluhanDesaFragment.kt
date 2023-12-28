package com.citiasia.inidesakubeta.ui.desa.penyuluhan_desa.list

import android.content.res.ColorStateList
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.TypedValue
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.data.remote.dummyObject.Penyuluhan
import com.citiasia.inidesakubeta.data.remote.model.ResponsePenyuluhan
import com.citiasia.inidesakubeta.databinding.FragmentPenyuluhanDesaBinding
import com.citiasia.inidesakubeta.ui.ViewModelFactory
import com.citiasia.inidesakubeta.ui.adapter.PenyuluhanDesaAdapter
import com.citiasia.inidesakubeta.ui.desa.pelatihan_desa.detail.DetailPelatihanDesaFragment
import com.citiasia.inidesakubeta.ui.desa.penyuluhan_desa.detail.DetailPenyuluhanDesaFragment
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipDrawable

class PenyuluhanDesaFragment : Fragment() {
    private var _binding: FragmentPenyuluhanDesaBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: PenyuluhanDesaViewModel
    private val categoryList = Penyuluhan.getCategory()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPenyuluhanDesaBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModelFactory = ViewModelFactory(requireContext())
        viewModel = ViewModelProvider(
            requireActivity(), viewModelFactory
        )[PenyuluhanDesaViewModel::class.java]

        showList("Semua")
        searchInput()
        setChipButton(categoryList)
        setChipBySelected()
    }

    private fun setChipBySelected() {
        binding.chipGroup.setOnCheckedChangeListener { group, checkedId ->
            val chip: Chip? = group.findViewById(checkedId)
            if (chip != null) {
                val selectedChip: String = chip.text.toString()
                showList(selectedChip)
            }
        }
    }

    private fun setChipButton(categoryList: List<String>) {
        val chipGroup = binding.chipGroup

        for (category in categoryList) {
            val chip = Chip(chipGroup.context)
            chip.text = category

            val chipDrawable = ChipDrawable.createFromAttributes(
                chipGroup.context,
                null,
                0,
                R.style.Theme_IniDesakuBeta_ChipButton_
            )

            with(chipDrawable) {
                val colorPrimary = TypedValue()
                chipGroup.context.theme.resolveAttribute(
                    androidx.appcompat.R.attr.colorPrimary,
                    colorPrimary,
                    true
                )
                chipStrokeColor = ColorStateList.valueOf(colorPrimary.data)
            }

            chip.setChipDrawable(chipDrawable)

            chip.setOnClickListener {
                chipGroup.check(chip.id)
            }

            chipGroup.addView(chip)
        }
    }

    private fun searchInput() {
        binding.textSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                searchData(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {
                if (s.isNullOrEmpty()) {
                    binding.frameLayout.visibility = View.GONE
                    binding.scrollHorizontal.visibility = View.VISIBLE
                } else {
                    binding.frameLayout.visibility = View.VISIBLE
                    binding.scrollHorizontal.visibility = View.GONE
                }
            }

        })
    }

    private fun searchData(query: String) {
        val listData = viewModel.getPenyuluhanList()

        val filteredList: List<ResponsePenyuluhan> = listData.filter { penyuluhan ->
            penyuluhan.title.contains(query, ignoreCase = true)
        }

        if (filteredList.isEmpty()){
            binding.layoutSearchNotFound.visibility = View.VISIBLE
        }else {
            binding.layoutSearchNotFound.visibility = View.GONE
        }

        val adapter = PenyuluhanDesaAdapter(filteredList)

        with(binding){
            rvListContentPenyuluhan.layoutManager = LinearLayoutManager(requireContext())
            rvListContentPenyuluhan.adapter = adapter

            adapter.setOnItemClickCallback(object : PenyuluhanDesaAdapter.OnItemClickCallback{
                override fun onItemClicked(data: ResponsePenyuluhan) {
                    val detailFragment = DetailPenyuluhanDesaFragment.newInstance(data)
                    val transaction = requireActivity().supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.kegiatan_desa, detailFragment)
                    transaction.addToBackStack(null)
                    transaction.commit()
                }
            })
        }
    }

    private fun showList(text: String) {
        val data: List<ResponsePenyuluhan> = viewModel.getPenyuluhanList()

        val tempList = arrayListOf<ResponsePenyuluhan>()
        for (i in data.indices){
            for (j in data[i].category.indices){
                val filterData = ResponsePenyuluhan(
                    title = data[i].title,
                    time = data[i].time,
                    category = data[i].category,
                    place = data[i].place,
                    imageCover = data[i].imageCover,
                    persyaratan = data[i].persyaratan,
                    manfaat = data[i].manfaat,
                    rincian = data[i].rincian,
                )
                if (data[i].category[j].equals(text)){
                    tempList.add(filterData)
                }
            }
        }
        var listAdapter = PenyuluhanDesaAdapter(tempList)

        if (text == "Semua"){
            listAdapter = PenyuluhanDesaAdapter(data)
        }

        with(binding){
            rvListContentPenyuluhan.layoutManager = LinearLayoutManager(requireContext())
            rvListContentPenyuluhan.adapter = listAdapter

            listAdapter.setOnItemClickCallback(object : PenyuluhanDesaAdapter.OnItemClickCallback {
                override fun onItemClicked(data: ResponsePenyuluhan) {
                    val detailFragment = DetailPenyuluhanDesaFragment.newInstance(data)
                    val transaction = requireActivity().supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.kegiatan_desa, detailFragment)
                    transaction.addToBackStack(null)
                    transaction.commit()
                }
            })
        }
    }
}