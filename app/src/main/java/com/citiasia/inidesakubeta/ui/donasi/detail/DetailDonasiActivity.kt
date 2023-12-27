package com.citiasia.inidesakubeta.ui.donasi.detail

import android.content.Intent
import android.content.res.ColorStateList
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.data.remote.model.ResponseDonasi
import com.citiasia.inidesakubeta.data.remote.model.ResponseProdukUnggulan
import com.citiasia.inidesakubeta.databinding.ActivityDetailDonasiBinding
import com.citiasia.inidesakubeta.ui.donasi.detail.bottom_sheet.BottomSheetDonasi
import com.citiasia.inidesakubeta.ui.ppob.pulsa.pulsaDialog.BottomSheetPulsa
import com.citiasia.inidesakubeta.ui.produk_unggulan.detail.DetailProdukUnggulanActivity
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.button.MaterialButton
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipDrawable

class DetailDonasiActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailDonasiBinding
    private val dialog = BottomSheetDonasi()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailDonasiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showDetail()
        binding.btnDonasi.setOnClickListener {
            showDialog()
        }
        binding.topAppBar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    private fun showDialog() {
        dialog.show(supportFragmentManager, BottomSheetDonasi.TAG)
    }

    private fun showDetail() {
        val donasiData = intent.getParcelableExtra<ResponseDonasi>(
            EXTRA_DETAIL
        )
        binding.apply {
            tvTitleDonasi.text = donasiData?.title
            tvSisa.text = "${donasiData?.donasiStart}"
            tvTotalHari.text = "/${donasiData?.donasiEnd}"
            tvUangTerkumpul.text = donasiData?.collect.toString()
            tvUangTarget.text = donasiData?.target.toString()
            tvTentangProgram.text = donasiData?.about
            Glide.with(this@DetailDonasiActivity)
                .load(donasiData?.imageCover)
                .into(ivCoverDonasi)

            donasiData?.category?.let { categories ->
                for (category in categories) {
                    val chip = Chip(this@DetailDonasiActivity)

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
                    chip.isClickable = false
                    chip.setChipDrawable(chipDrawable)

                    chip.text = category
                    chipGroup.addView(chip)
                }
            }


            donasiData?.let {
                pbDonasi.max = it.target
                pbDonasi.progress = it.collect
            }

            btnWhatsapp.setOnClickListener {
                donasiData?.phone?.takeIf { it.isNotBlank() }?.let { phoneNumber ->
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