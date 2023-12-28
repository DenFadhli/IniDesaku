package com.citiasia.inidesakubeta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.citiasia.inidesakubeta.data.database.Berita
import com.citiasia.inidesakubeta.data.database.PicBudaya
import com.citiasia.inidesakubeta.data.database.PotensiFisik
import com.citiasia.inidesakubeta.databinding.ActivityDetailBeritaBinding
import com.citiasia.inidesakubeta.databinding.ActivityDetailPotensiFisikBinding
import com.citiasia.inidesakubeta.ui.ViewModelFactory
import com.citiasia.inidesakubeta.ui.adapter.ListPicBudayaAdapter
import com.citiasia.inidesakubeta.ui.adapter.SmallListPotensiFisikAdapter

class DetailPotensiFisikActivity : AppCompatActivity() {
    private var _binding: ActivityDetailPotensiFisikBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: ListPotensiFisikViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailPotensiFisikBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val vmFactory = ViewModelFactory(this)
        viewModel = ViewModelProvider(
            this,
            vmFactory
        ).get(ListPotensiFisikViewModel::class.java)

        getListData()
        setSmallListPotensi("Potensi")
        getSmallListData()
        iconClick()
    }

    private fun getListData(){
        val data = intent.getParcelableExtra<PotensiFisik>("potensi")
        binding.apply {
            if (data != null) {
                judulCardPotensiDetail.text = data.title
                Glide.with(this@DetailPotensiFisikActivity)
                    .load(data.image)
                    .into(gambarDetailPotensi)
                adminDesa.text = data.admin
                tglPotensi.text = data.time
                pelihatPotensi.text = data.viewer
                descPotensi.text = data.desc
            }
        }
    }

    private fun setSmallListPotensi(text: String) {
        val data: List<PotensiFisik> = viewModel.getPotensiFisikData()

        val tempList = arrayListOf<PotensiFisik>()

        var listAdapter = SmallListPotensiFisikAdapter(tempList)

        if (text.equals("Potensi")) {
            listAdapter = SmallListPotensiFisikAdapter(data)
        }

        with(binding) {
            rvPotensiFisik.layoutManager = LinearLayoutManager(this@DetailPotensiFisikActivity, LinearLayoutManager.HORIZONTAL, false)
            rvPotensiFisik.adapter = listAdapter

            listAdapter.setOnItemClickCallback(object : SmallListPotensiFisikAdapter.OnItemClickCallback{
                override fun onItemClicked(data: PotensiFisik) {
                    val intent = Intent(this@DetailPotensiFisikActivity, DetailPotensiFisikActivity::class.java)
                    intent.putExtra("fisik", data)
                    startActivity(intent)
                }
            })
        }
    }

    private fun getSmallListData(){
        val data = intent.getParcelableExtra<PotensiFisik>("fisik")
        binding.apply {
            if (data != null) {
                judulCardPotensiDetail.text = data.title
                Glide.with(this@DetailPotensiFisikActivity)
                    .load(data.image)
                    .into(gambarDetailPotensi)
                adminDesa.text = data.admin
                tglPotensi.text = data.time
                pelihatPotensi.text = data.viewer
                descPotensi.text = data.desc
            }
        }
    }

    private fun iconClick(){
        binding.topAppBar.setNavigationOnClickListener {
            super.onBackPressed()
        }
    }

}