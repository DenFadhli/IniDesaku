package com.citiasia.inidesakubeta.ui.ppob.pulsa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.annotation.StringRes
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.databinding.ActivityPulsaBinding
import com.citiasia.inidesakubeta.data.remote.model.PulsaDataInput
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

    private fun isValidPhoneNumber(phoneNumber: String): Boolean {
        // Format nomor telepon Indonesia: +62 atau 8 diikuti dengan 8-15 digit
        val regex = Regex("^\\+62|8[0-9]{8,15}\$")

        return regex.matches(phoneNumber)
    }

    private fun onClick() {

        binding.apply {
            layoutNomor.isHelperTextEnabled = false
            var errorEnable = false


            textNumberPhone.addTextChangedListener(object : TextWatcher{
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    with(layoutNomor) {
                        errorEnable = !(isValidPhoneNumber(s.toString()))
                        isHelperTextEnabled = errorEnable
                        helperText = "*nomor yang Anda masukan tidak valid"

                        Log.e("Test errorEnable", errorEnable.toString())
                    }
                }

                override fun afterTextChanged(s: Editable?) {
                    layoutNomor.isHelperTextEnabled = errorEnable
                    if (!errorEnable) {
                        val data = PulsaDataInput(s.toString(), "")
                        pref.saveData(data)
                    }
                }

            })
        }


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