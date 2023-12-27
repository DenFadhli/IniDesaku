package com.citiasia.inidesakubeta.ui.desa.kegiatan_desa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.databinding.ActivityKegiatanBinding
import com.citiasia.inidesakubeta.ui.adapter.KegiatanDesaTabAdapter
import com.google.android.material.tabs.TabLayoutMediator

class KegiatanActivity : AppCompatActivity() {
    private lateinit var binding: ActivityKegiatanBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKegiatanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setTabAdapter()

        binding.topAppBar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    private fun setTabAdapter() {
        val sectionPageAdapter = KegiatanDesaTabAdapter(this)
        with(binding){
            viewPager.adapter = sectionPageAdapter
            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                tab.text = resources.getString(TAB_TITLES[position])
            }.attach()
        }
    }

    companion object{
        private val TAB_TITLES = intArrayOf(
            R.string.tab_kegiatan_1,
            R.string.tab_kegiatan_2,
            R.string.tab_kegiatan_3
        )
    }
}