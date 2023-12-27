package com.citiasia.inidesakubeta.ui.produk_unggulan.detail

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.data.remote.model.ResponseProdukUnggulan
import com.citiasia.inidesakubeta.databinding.ActivityDetailProdukUnggulanBinding

class DetailProdukUnggulanActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailProdukUnggulanBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailProdukUnggulanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showDetail()
        binding.topAppBar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    private fun showDetail() {
        val produkData = intent.getParcelableExtra<ResponseProdukUnggulan>(EXTRA_DETAIL)
        binding.apply {
            tvJudulProdukUnggulan.text = produkData?.title
            tvAdmin.text = produkData?.admin
            tvTime.text = produkData?.time
            tvView.text = produkData?.view.toString()
            tvDesc.text = produkData?.about
            Glide.with(this@DetailProdukUnggulanActivity)
                .load(produkData?.imageCover)
                .into(ivImageCover)

            btnCall.setOnClickListener {
                produkData?.phone?.takeIf { it.isNotBlank() }?.let { phoneNumber ->
                    val dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                    startActivity(dialIntent)
                }
            }

            btnWa.setOnClickListener {
                produkData?.phone?.takeIf { it.isNotBlank() }?.let { phoneNumber ->
                    val whatsappIntent = Intent(Intent.ACTION_VIEW).apply {
                        val url = "https://api.whatsapp.com/send?phone=$phoneNumber"
                        data = Uri.parse(url)
                    }
                    startActivity(whatsappIntent)
                }
            }
        }
    }

    companion object {
        const val EXTRA_DETAIL = "extra_detail"
    }
}