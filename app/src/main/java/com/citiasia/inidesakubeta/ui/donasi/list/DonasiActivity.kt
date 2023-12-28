package com.citiasia.inidesakubeta.ui.donasi.list

import android.content.Intent
import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.TypedValue
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.data.remote.dummyObject.Donasi
import com.citiasia.inidesakubeta.data.remote.model.ResponseDonasi
import com.citiasia.inidesakubeta.data.remote.model.ResponseProdukUnggulan
import com.citiasia.inidesakubeta.databinding.ActivityDonasiBinding
import com.citiasia.inidesakubeta.ui.ViewModelFactory
import com.citiasia.inidesakubeta.ui.adapter.DonasiAdapter
import com.citiasia.inidesakubeta.ui.adapter.ProdukUnggulanAdapter
import com.citiasia.inidesakubeta.ui.donasi.detail.DetailDonasiActivity
import com.citiasia.inidesakubeta.ui.produk_unggulan.detail.DetailProdukUnggulanActivity
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipDrawable

class DonasiActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDonasiBinding
    private lateinit var viewModel: DonasiViewModel
    private val categoryList = Donasi.getCategory()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDonasiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModelFactory = ViewModelFactory(this)
        viewModel = ViewModelProvider(this, viewModelFactory)[DonasiViewModel::class.java]

        showList("Semua")
        searchInput()
        setChipButton(categoryList)
        setChipBySelected()

        binding.topAppBar.setNavigationOnClickListener {
            onBackPressed()
        }
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
                chip.setTextColor(colorPrimary.data)
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
        val listData = viewModel.getDonasiList()

        val filteredList: List<ResponseDonasi> = listData.filter { donasi ->
            donasi.title.contains(query, ignoreCase = true)
        }

        if (filteredList.isEmpty()){
            binding.layoutSearchNotFound.visibility = View.VISIBLE
        }else {
            binding.layoutSearchNotFound.visibility = View.GONE
        }

        val adapter = DonasiAdapter(filteredList)

        with(binding){
            rvListContentDonasi.layoutManager = LinearLayoutManager(this@DonasiActivity)
            rvListContentDonasi.adapter = adapter

            adapter.setOnItemClickCallback(object : DonasiAdapter.OnItemClickCallback{
                override fun onItemClicked(data: ResponseDonasi) {
                    val detail = Intent(this@DonasiActivity, DetailDonasiActivity::class.java)
                    detail.putExtra(DetailDonasiActivity.EXTRA_DETAIL, data)
                    startActivity(detail)
                }
            })
        }
    }

    private fun showList(text: String) {
        val data: List<ResponseDonasi> = viewModel.getDonasiList()

        val tempList = arrayListOf<ResponseDonasi>()
        for (i in data.indices){
            for (j in data[i].category.indices){
                val filterData = ResponseDonasi(
                    title = data[i].title,
                    time = data[i].time,
                    category = data[i].category,
                    admin = data[i].admin,
                    imageCover = data[i].imageCover,
                    about = data[i].about,
                    donasiEnd = data[i].donasiEnd,
                    donasiStart = data[i].donasiStart,
                    collect = data[i].collect,
                    target = data[i].target,
                    phone = data[i].phone
                )
                if (data[i].category[j] == text){
                    tempList.add(filterData)
                }
            }
        }
        var listAdapter = DonasiAdapter(tempList)

        if (text.equals("Semua")){
            listAdapter = DonasiAdapter(data)
        }

        with(binding){
            rvListContentDonasi.layoutManager = LinearLayoutManager(this@DonasiActivity)
            rvListContentDonasi.adapter = listAdapter

            listAdapter.setOnItemClickCallback(object : DonasiAdapter.OnItemClickCallback{
                override fun onItemClicked(data: ResponseDonasi) {
                    val detail = Intent(this@DonasiActivity, DetailDonasiActivity::class.java)
                    detail.putExtra(DetailDonasiActivity.EXTRA_DETAIL, data)
                    startActivity(detail)
                }
            })
        }
    }
}