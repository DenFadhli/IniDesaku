package com.citiasia.inidesakubeta.ui.produk_unggulan.list

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.TypedValue
import android.view.View
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.data.remote.dummyObject.ProdukUnggulan
import com.citiasia.inidesakubeta.data.remote.model.ResponseProdukUnggulan
import com.citiasia.inidesakubeta.databinding.ActivityProdukUnggulanBinding
import com.citiasia.inidesakubeta.ui.ViewModelFactory
import com.citiasia.inidesakubeta.ui.adapter.ProdukUnggulanAdapter
import com.citiasia.inidesakubeta.ui.produk_unggulan.detail.DetailProdukUnggulanActivity
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipDrawable
import java.util.Locale

class ProdukUnggulanActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProdukUnggulanBinding
    private lateinit var viewModel: ProdukUnggulanViewModel
    private val categoryList = ProdukUnggulan.getCategory()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProdukUnggulanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModelFactory = ViewModelFactory(this)
        viewModel = ViewModelProvider(this, viewModelFactory)[ProdukUnggulanViewModel::class.java]

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
        val listData = viewModel.getProdukUnggulanData()

        val filteredList: List<ResponseProdukUnggulan> = listData.filter { produk ->
            produk.title.contains(query, ignoreCase = true)
        }

        if (filteredList.isEmpty()){
            binding.layoutSearchNotFound.visibility = View.VISIBLE
        }else {
            binding.layoutSearchNotFound.visibility = View.GONE
        }

        val adapter = ProdukUnggulanAdapter(filteredList)

        with(binding){
            rvListContentProdukUnggulan.layoutManager = LinearLayoutManager(this@ProdukUnggulanActivity)
            rvListContentProdukUnggulan.adapter = adapter

            adapter.setOnItemClickCallback(object : ProdukUnggulanAdapter.OnItemClickCallback{
                override fun onItemClicked(data: ResponseProdukUnggulan) {
                    val detail = Intent(this@ProdukUnggulanActivity, DetailProdukUnggulanActivity::class.java)
                    detail.putExtra(DetailProdukUnggulanActivity.EXTRA_DETAIL, data)
                    startActivity(detail)
                }
            })
        }
    }


    private fun showList(text: String) {
        val data: List<ResponseProdukUnggulan> = viewModel.getProdukUnggulanData()

        val tempList = arrayListOf<ResponseProdukUnggulan>()
        for (i in data.indices){
            for (j in data[i].category.indices){
                val filterData = ResponseProdukUnggulan(
                    title = data[i].title,
                    time = data[i].time,
                    category = data[i].category,
                    admin = data[i].admin,
                    view = data[i].view,
                    imageCover = data[i].imageCover,
                    phone = data[i].phone,
                    about = data[i].about
                )
                if (data[i].category[j].equals(text)){
                    tempList.add(filterData)
                }
            }
        }
        var listAdapter = ProdukUnggulanAdapter(tempList)

        if (text.equals("Semua")){
            listAdapter = ProdukUnggulanAdapter(data)
        }

        with(binding){
            rvListContentProdukUnggulan.layoutManager = LinearLayoutManager(this@ProdukUnggulanActivity)
            rvListContentProdukUnggulan.adapter = listAdapter

            listAdapter.setOnItemClickCallback(object : ProdukUnggulanAdapter.OnItemClickCallback{
                override fun onItemClicked(data: ResponseProdukUnggulan) {
                    val detail = Intent(this@ProdukUnggulanActivity, DetailProdukUnggulanActivity::class.java)
                    detail.putExtra(DetailProdukUnggulanActivity.EXTRA_DETAIL, data)
                    startActivity(detail)
                }
            })
        }
    }
}