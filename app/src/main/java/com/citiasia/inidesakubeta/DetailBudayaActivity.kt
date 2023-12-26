package com.citiasia.inidesakubeta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.citiasia.inidesakubeta.data.database.Budaya
import com.citiasia.inidesakubeta.data.database.PicBudaya
import com.citiasia.inidesakubeta.data.database.Wisata
import com.citiasia.inidesakubeta.databinding.ActivityDetailBudayaBinding
import com.citiasia.inidesakubeta.databinding.ActivityDetailWisataBinding
import com.citiasia.inidesakubeta.ui.ViewModelFactory
import com.citiasia.inidesakubeta.ui.adapter.BigListBudayaAdapter
import com.citiasia.inidesakubeta.ui.adapter.ListPicBudayaAdapter

class DetailBudayaActivity : AppCompatActivity() {
    private var _binding: ActivityDetailBudayaBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: ListBudayaViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailBudayaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val vmFactory = ViewModelFactory(this)
        viewModel = ViewModelProvider(
            this,
            vmFactory
        ).get(ListBudayaViewModel::class.java)

        getRekomListData()
        getSekitarListData()
        getDicariListData()
        setDataPicGaleri("Picture")
        iconClick()
    }

    private fun getRekomListData(){
        val data = intent.getParcelableExtra<Budaya>("rekomendasi")
        binding.apply {
            if (data != null) {
                judulCardBudayaDetail.text = data.title
                Glide.with(this@DetailBudayaActivity)
                    .load(data.image)
                    .into(gambarDetailBudaya)
                adminDesa.text = data.admin
                tglBudaya.text = data.time
                pelihatBudaya.text = data.viewer
                galeriBudaya.text = data.galeri
                descBudaya.text = data.desc
            }
        }
    }

    private fun getSekitarListData(){
        val data = intent.getParcelableExtra<Budaya>("sekitar")
        binding.apply {
            if (data != null) {
                judulCardBudayaDetail.text = data.title
                Glide.with(this@DetailBudayaActivity)
                    .load(data.image)
                    .into(gambarDetailBudaya)
                adminDesa.text = data.admin
                tglBudaya.text = data.time
                pelihatBudaya.text = data.viewer
                galeriBudaya.text = data.galeri
                descBudaya.text = data.desc
            }
        }
    }

    private fun getDicariListData(){
        val data = intent.getParcelableExtra<Budaya>("dicari")
        binding.apply {
            if (data != null) {
                judulCardBudayaDetail.text = data.title
                Glide.with(this@DetailBudayaActivity)
                    .load(data.image)
                    .into(gambarDetailBudaya)
                adminDesa.text = data.admin
                tglBudaya.text = data.time
                pelihatBudaya.text = data.viewer
                galeriBudaya.text = data.galeri
                descBudaya.text = data.desc
            }
        }
    }

    private fun setDataPicGaleri(text: String) {
        val data: List<PicBudaya> = viewModel.getPicData()

        val tempList = arrayListOf<PicBudaya>()

        var listAdapter = ListPicBudayaAdapter(tempList)

        if (text.equals("Picture")) {
            listAdapter = ListPicBudayaAdapter(data)
        }

        with(binding) {
            rvGaleriBudaya.layoutManager = GridLayoutManager(this@DetailBudayaActivity, 4)
            rvGaleriBudaya.adapter = listAdapter

//            listAdapter.setOnItemClickCallback(object : BigListBudayaAdapter.OnItemClickCallback{
//                override fun onItemClicked(data: Budaya) {
//                    val intent = Intent(requireActivity(), DetailBudayaActivity::class.java)
//                    intent.putExtra("rekomendasi", data)
//                    startActivity(intent)
//                }
//            })
        }
    }

    private fun iconClick(){
        binding.topAppBar.setNavigationOnClickListener {
            super.onBackPressed()
        }
    }
}