package com.citiasia.inidesakubeta.ui.pesona

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.citiasia.inidesakubeta.data.database.Berita
import com.citiasia.inidesakubeta.databinding.ActivityDetailBeritaBinding
import com.citiasia.inidesakubeta.ui.ViewModelFactory

class DetailBeritaActivity : AppCompatActivity() {

    private var _binding: ActivityDetailBeritaBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: ListBeritaViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailBeritaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val vmFactory = ViewModelFactory(this)
        viewModel = ViewModelProvider(
            this,
            vmFactory
        ).get(ListBeritaViewModel::class.java)

        getListData()
        iconClick()
    }

    private fun getListData(){
        val data = intent.getParcelableExtra<Berita>("berita")
        binding.apply {
            if (data != null) {
                judulCardBeritaDetail.text = data.title
                Glide.with(this@DetailBeritaActivity)
                    .load(data.image)
                    .into(gambarDetailBerita)
                adminDesa.text = data.admin
                tglBerita.text = data.time
                pelihatBerita.text = data.viewer
                descBerita.text = data.desc
            }
        }
    }

    private fun iconClick(){
        binding.topAppBar.setNavigationOnClickListener {
            super.onBackPressed()
        }
    }

}