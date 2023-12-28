package com.citiasia.inidesakubeta.ui.ppob.bpjs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.StringRes
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.databinding.ActivityBpjsBinding
import com.citiasia.inidesakubeta.databinding.ActivityPulsaBinding
import com.citiasia.inidesakubeta.ui.adapter.BpjsTabAdapter
import com.citiasia.inidesakubeta.ui.adapter.ListrikAirTabAdapter
import com.citiasia.inidesakubeta.ui.ppob.listrikAir.ListrikAirActivity
import com.google.android.material.tabs.TabLayoutMediator

class BpjsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBpjsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBpjsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setTabAdapter()
        buttonClick()
    }

    private fun setTabAdapter() {
        val sectionsPagerAdapter = BpjsTabAdapter(this as AppCompatActivity)
        with(binding) {
            viewPager.adapter = sectionsPagerAdapter
            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                tab.text = resources.getString(TAB_TITLES[position])
            }.attach()
        }
    }

    private fun buttonClick() = with(binding) {
        topAppBar.setNavigationOnClickListener {
            onBackPressed()
        }

    }

    companion object{
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.tab_bpjs_1,
            R.string.tab_bpjs_2
        )
    }
}