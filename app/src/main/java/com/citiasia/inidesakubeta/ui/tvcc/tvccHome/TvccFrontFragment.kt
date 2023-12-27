package com.citiasia.inidesakubeta.ui.tvcc.tvccHome

import android.content.Context
import android.content.res.ColorStateList
import android.opengl.Visibility
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.data.remote.dummyObject.Tvcc
import com.citiasia.inidesakubeta.data.remote.model.ResponseTvcc
import com.citiasia.inidesakubeta.databinding.FragmentTvccFrontBinding
import com.citiasia.inidesakubeta.ui.ViewModelFactory
import com.citiasia.inidesakubeta.ui.adapter.BulanTahunAdapter
import com.citiasia.inidesakubeta.ui.adapter.TvccBannerAdapter
import com.citiasia.inidesakubeta.ui.adapter.TvccListAdapter
import com.citiasia.inidesakubeta.ui.adapter.TvccListSearchAdapter
import com.citiasia.inidesakubeta.ui.ppob.bpjs.bpjsDialog.BottomSheetBpjs
import com.citiasia.inidesakubeta.ui.sign.login.LoginViewModel
import com.citiasia.inidesakubeta.ui.tvcc.tvccDetail.TvccDetailFragment
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipDrawable


class TvccFrontFragment : Fragment() {

    private var _binding: FragmentTvccFrontBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: TvccFrontViewModel

    private val listKategori = Tvcc.getKategori()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTvccFrontBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val vmFactory = ViewModelFactory(requireContext())
        viewModel = ViewModelProvider(
            requireActivity(),
            vmFactory
        ).get(TvccFrontViewModel::class.java)

        val data = viewModel.getTvccData()

        setChipButtonText(listKategori)
        setPreviousPage()
        setDataBannerAdapter(data)
        setDataListAdapter("Semua")
        setByChipSelected()
        searchInputAction()
    }

    private fun searchInputAction() {
        binding.textSearch.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                setSearchAdapter(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {
                if (s.isNullOrEmpty()) {
                    binding.frameLayout.visibility = View.GONE
                } else {
                    binding.frameLayout.visibility = View.VISIBLE
                }
            }

        })
    }

    private fun setSearchAdapter(text: String) {
        val listData = viewModel.getTvccData()

        val filteredList: List<ResponseTvcc> = listData.filter { tvcc ->
            tvcc.title.contains(text, ignoreCase = true)
        }

        if (filteredList.size == 0) {
            binding.layoutSearchNotFound.visibility = View.VISIBLE
        } else {
            binding.layoutSearchNotFound.visibility = View.GONE
        }

        val adapter = TvccListSearchAdapter(filteredList)

        binding.rvSearch.layoutManager = LinearLayoutManager(requireContext())
        binding.rvSearch.adapter = adapter

        adapter.setOnItemClickCallback(object : TvccListSearchAdapter.OnItemClickCallback{
            override fun onItemClicked(data: ResponseTvcc) {

                val action = TvccFrontFragmentDirections.actionTvccFrontFragmentToTvccDetailFragment(data)
                findNavController().navigate(action)

            }

        })
    }

    private fun setChipButtonText(listKategori: List<String>) {
        for (i in listKategori) {
            addChip(i)
        }

    }

    private fun setDataBannerAdapter(data: List<ResponseTvcc>) {
        Log.e("jumlah data tvcc fragment", data.size.toString())

        val bannerAdapter = TvccBannerAdapter(data)

        with(binding) {
            rvBannerLive.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            rvBannerLive.adapter = bannerAdapter

            bannerAdapter.setOnItemClickCallback(object : TvccBannerAdapter.OnItemClickCallback{
                override fun onItemClicked(data: ResponseTvcc) {

                    val action = TvccFrontFragmentDirections.actionTvccFrontFragmentToTvccDetailFragment(data)
                    val navController = findNavController()
                    navController.navigate(action)
                }

            })
        }
    }

    private fun setDataListAdapter(text: String) {
        val data: List<ResponseTvcc> = viewModel.getTvccData()

        val tempList = arrayListOf<ResponseTvcc>()
        for (i in data.indices) {
            for (j in data[i].kategori.indices) {
                val filterData = ResponseTvcc(
                    title = data[i].title,
                    kategori = data[i].kategori,
                    jamMulai = data[i].jamMulai,
                    jamSelesai = data[i].jamSelesai,
                    thumnailGambar = data[i].thumnailGambar,
                    urlVideo = data[i].urlVideo,
                )

                if (data[i].kategori[j].equals(text)) {
                    tempList.add(filterData)
                }
            }
        }
        var listAdapter = TvccListAdapter(tempList)

        if (text.equals("Semua")) {
            listAdapter = TvccListAdapter(data)
        }

        with(binding) {
            rvListContent.layoutManager = GridLayoutManager(requireContext(), 2)
            rvListContent.adapter = listAdapter

            listAdapter.setOnItemClickCallback(object : TvccListAdapter.OnItemClickCallback{
                override fun onItemClicked(data: ResponseTvcc) {
                    val action = TvccFrontFragmentDirections.actionTvccFrontFragmentToTvccDetailFragment(data)
                    findNavController().navigate(action)

                }

            })
        }
    }

    private fun setByChipSelected() {
        binding.chipGroup.setOnCheckedChangeListener { group, checkedId ->
            val chip: Chip? = group.findViewById(checkedId)
            if (chip != null) {
                val selectedChipText: String = chip.text.toString()
                //set to adapter
                setDataListAdapter(selectedChipText)
            }
        }
    }

    private fun addChip(text: String) {
        val chip = Chip(requireContext())

        val chipDrawable = ChipDrawable.createFromAttributes(
            requireContext(),
            null,
            0,
            R.style.Theme_IniDesakuBeta_ChipButton_
        )

        with(chipDrawable) {
            setText(text)
//            setTextColor(ContextCompat.getColorStateList(requireContext(), R.color.black))
            chipStrokeColor = ContextCompat.getColorStateList(requireContext(), R.color.primary500)
//            chipBackgroundColor = ContextCompat.getColorStateList(requireContext(), R.color.white)

        }

        chip.setChipDrawable(chipDrawable)


        binding.chipGroup.addView(chip)

        binding.chipGroup.isSelected
    }



    private fun setPreviousPage() {
        binding.topAppBar.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }
    }

}