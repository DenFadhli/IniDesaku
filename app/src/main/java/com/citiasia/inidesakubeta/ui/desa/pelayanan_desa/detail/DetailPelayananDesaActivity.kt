package com.citiasia.inidesakubeta.ui.desa.pelayanan_desa.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.data.remote.model.ResponsePelayananDesa
import com.citiasia.inidesakubeta.databinding.ActivityDetailPelayananDesaBinding

class DetailPelayananDesaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailPelayananDesaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailPelayananDesaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showDetail()
        binding.topAppBar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    private fun showDetail() {
        val pelayananDesa = intent.getParcelableExtra<ResponsePelayananDesa>(EXTRA_DETAIL)
        binding.apply {
            tvDescManfaat.text = pelayananDesa?.manfaat
            tvDescPersyaratan.text = pelayananDesa?.persyaratan
            tvDescRincian.text = pelayananDesa?.rincian
            tvTempat.text = pelayananDesa?.place
            tvWaktu.text = pelayananDesa?.time
            tvTitlePelayanan.text = pelayananDesa?.title
            ivCoverArticle.setImageResource(R.drawable.icon_pelayanan)
        }
    }

    companion object {
        const val EXTRA_DETAIL = "extra_detail"
    }
}