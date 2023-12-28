package com.citiasia.inidesakubeta.ui.pesona

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.citiasia.inidesakubeta.data.database.Wisata
import com.citiasia.inidesakubeta.databinding.ActivityDetailWisataBinding
import com.citiasia.inidesakubeta.ui.ViewModelFactory

class DetailWisataActivity : AppCompatActivity() {
    private var _binding: ActivityDetailWisataBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: ListWisataViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailWisataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val vmFactory = ViewModelFactory(this)
        viewModel = ViewModelProvider(
            this,
            vmFactory
        ).get(ListWisataViewModel::class.java)

        getRekomListData()
        getSekitarListData()
        getDicariListData()
        iconClick()
    }

    private fun getRekomListData(){
        val data = intent.getParcelableExtra<Wisata>("rekomendasi")
        binding.apply {
            if (data != null) {
                judulCardWisataDetail.text = data.title
                Glide.with(this@DetailWisataActivity)
                    .load(data.image)
                    .into(gambarDetailWisata)
                lokasiWisata.text = data.lokasi
                waktuWisata.text = data.time
                batasUmur.text = data.age
                descWisata.text = data.desc
            }
        }
    }

    private fun getSekitarListData(){
        val data = intent.getParcelableExtra<Wisata>("sekitar")
        binding.apply {
            if (data != null) {
                judulCardWisataDetail.text = data.title
                Glide.with(this@DetailWisataActivity)
                    .load(data.image)
                    .into(gambarDetailWisata)
                lokasiWisata.text = data.lokasi
                waktuWisata.text = data.time
                batasUmur.text = data.age
                descWisata.text = data.desc
            }
        }
    }

    private fun getDicariListData(){
        val data = intent.getParcelableExtra<Wisata>("dicari")
        binding.apply {
            if (data != null) {
                judulCardWisataDetail.text = data.title
                Glide.with(this@DetailWisataActivity)
                    .load(data.image)
                    .into(gambarDetailWisata)
                lokasiWisata.text = data.lokasi
                waktuWisata.text = data.time
                batasUmur.text = data.age
                descWisata.text = data.desc
            }
        }
    }

    private fun iconClick(){
        binding.topAppBar.setNavigationOnClickListener {
            super.onBackPressed()
        }
    }
}