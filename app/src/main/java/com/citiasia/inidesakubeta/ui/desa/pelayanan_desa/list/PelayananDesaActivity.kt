package com.citiasia.inidesakubeta.ui.desa.pelayanan_desa.list

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
import com.citiasia.inidesakubeta.data.remote.dummyObject.PelayananDesa
import com.citiasia.inidesakubeta.data.remote.model.ResponsePelayananDesa
import com.citiasia.inidesakubeta.databinding.ActivityPelayananDesaBinding
import com.citiasia.inidesakubeta.ui.ViewModelFactory
import com.citiasia.inidesakubeta.ui.adapter.PelayananDesaAdapter
import com.citiasia.inidesakubeta.ui.desa.pelayanan_desa.detail.DetailPelayananDesaActivity
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipDrawable

class PelayananDesaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPelayananDesaBinding
    private lateinit var viewModel: PelayananDesaViewModel
    private val categoryList = PelayananDesa.getCategory()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPelayananDesaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModelFactory = ViewModelFactory(this)
        viewModel = ViewModelProvider(this, viewModelFactory)[PelayananDesaViewModel::class.java]

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
        val listData = viewModel.getPelayanan()

        val filteredList: List<ResponsePelayananDesa> = listData.filter { pelayanan ->
            pelayanan.title.contains(query, ignoreCase = true)
        }

        if (filteredList.isEmpty()){
            binding.layoutSearchNotFound.visibility = View.VISIBLE
        }else {
            binding.layoutSearchNotFound.visibility = View.GONE
        }

        val adapter = PelayananDesaAdapter(filteredList)

        with(binding){
            rvListContentPelayanan.layoutManager = LinearLayoutManager(this@PelayananDesaActivity)
            rvListContentPelayanan.adapter = adapter

            adapter.setOnItemClickCallback(object : PelayananDesaAdapter.OnItemClickCallback{
                override fun onItemClicked(data: ResponsePelayananDesa) {
                    val detail = Intent(this@PelayananDesaActivity, DetailPelayananDesaActivity::class.java)
                    detail.putExtra(DetailPelayananDesaActivity.EXTRA_DETAIL, data)
                    startActivity(detail)
                }
            })
        }
    }

    private fun showList(text: String) {
        val data: List<ResponsePelayananDesa> = viewModel.getPelayanan()

        val tempList = arrayListOf<ResponsePelayananDesa>()
        for (i in data.indices){
            for (j in data[i].category.indices){
                val filterData = ResponsePelayananDesa(
                    title = data[i].title,
                    time = data[i].time,
                    category = data[i].category,
                    place = data[i].place,
                    persyaratan = data[i].persyaratan,
                    rincian = data[i].rincian,
                    manfaat = data[i].manfaat
                )
                if (data[i].category[j] == text){
                    tempList.add(filterData)
                }
            }
        }
        var listAdapter = PelayananDesaAdapter(tempList)

        if (text == "Semua"){
            listAdapter = PelayananDesaAdapter(data)
        }

        with(binding){
            rvListContentPelayanan.layoutManager = LinearLayoutManager(this@PelayananDesaActivity)
            rvListContentPelayanan.adapter = listAdapter

            listAdapter.setOnItemClickCallback(object : PelayananDesaAdapter.OnItemClickCallback{
                override fun onItemClicked(data: ResponsePelayananDesa) {
                    val detail = Intent(this@PelayananDesaActivity, DetailPelayananDesaActivity::class.java)
                    detail.putExtra(DetailPelayananDesaActivity.EXTRA_DETAIL, data)
                    startActivity(detail)
                }
            })
        }
    }
}