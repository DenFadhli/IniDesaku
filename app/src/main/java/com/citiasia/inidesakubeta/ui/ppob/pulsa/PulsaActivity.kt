package com.citiasia.inidesakubeta.ui.ppob.pulsa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.annotation.StringRes
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.databinding.ActivityPulsaBinding
import com.citiasia.inidesakubeta.model.PulsaDataInput
import com.citiasia.inidesakubeta.ui.adapter.PulsaTabAdapter
import com.citiasia.inidesakubeta.utils.PulsaPreference
import com.google.android.material.tabs.TabLayoutMediator

class PulsaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPulsaBinding
    private lateinit var pref: PulsaPreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPulsaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pref = PulsaPreference(this)
        pref.removeData()
        setTabAdapter()
        onClick()
    }

    private fun onClick() {

        binding.textNumberPhone.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                val data = PulsaDataInput(s.toString(), "")
                pref.saveData(data)
            }

        })

        binding.topAppBar.setNavigationOnClickListener {
            onBackPressed()
        }

    }

    private fun setTabAdapter() {
        val sectionsPagerAdapter = PulsaTabAdapter(this as AppCompatActivity)
        with(binding) {
            viewPager.adapter = sectionsPagerAdapter
            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                tab.text = resources.getString(TAB_TITLES[position])
            }.attach()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }


    companion object{
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.tab_pulsa_1,
            R.string.tab_pulsa_2,
            R.string.tab_pulsa_3
        )
    }
}