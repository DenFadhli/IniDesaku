package com.citiasia.inidesakubeta.ui.ppob.listrikAir

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.StringRes
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.databinding.ActivityListrikAirBinding
import com.citiasia.inidesakubeta.ui.adapter.ListrikAirTabAdapter
import com.citiasia.inidesakubeta.ui.adapter.PulsaTabAdapter
import com.citiasia.inidesakubeta.ui.ppob.pulsa.PulsaActivity
import com.google.android.material.tabs.TabLayoutMediator

class ListrikAirActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListrikAirBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListrikAirBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setTabAdapter()
        iconClick()
    }

    private fun iconClick(){
        binding.topAppBar.setNavigationOnClickListener {
            super.onBackPressed()
        }
    }

    private fun setTabAdapter() {
        val sectionsPagerAdapter = ListrikAirTabAdapter(this as AppCompatActivity)
        with(binding) {
            viewPager.adapter = sectionsPagerAdapter
            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                tab.text = resources.getString(TAB_TITLES[position])
            }.attach()
        }
    }



    companion object{
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.tab_listrik_1,
            R.string.tab_listrik_2
        )
    }
}