package com.citiasia.inidesakubeta.ui.bantuan

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.databinding.ActivityBantuanBinding
import com.citiasia.inidesakubeta.databinding.ActivityDetailProdukBinding
import com.citiasia.inidesakubeta.ui.beranda.BerandaFragment
import com.citiasia.inidesakubeta.ui.ppob.PpobFragment
import com.citiasia.inidesakubeta.ui.profilDesa.ProfilDesaFragment
import com.citiasia.inidesakubeta.ui.profile.profileFragment.ProfileFragment

class BantuanActivity : AppCompatActivity() {


    private var _binding: ActivityBantuanBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityBantuanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(BantuanListFragment())
        binding.topAppBar.setNavigationOnClickListener {
            onBackPressed()
        }
        iconBarClick()
    }

    private fun iconBarClick() {
        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.beranda -> {
                    replaceFragment(BerandaFragment())
                    binding.topAppBar.setTitle("INIDESAKU")
                }
                R.id.geo -> {
                    binding.topAppBar.setTitle("Geografi")
                }
                R.id.profileDesa -> {
                    replaceFragment(ProfilDesaFragment())
                    binding.topAppBar.setTitle("Profile Desa")
                }
                R.id.ppob -> {
                    replaceFragment(PpobFragment())
                    binding.topAppBar.setTitle("PPOB")
                }
                R.id.profile -> {
                    replaceFragment(ProfileFragment())
                    binding.topAppBar.setTitle("Profile")
                    binding.topAppBar.setNavigationIcon(R.drawable.baseline_arrow_back_24)
                    binding.topAppBar.setNavigationIconTint(resources.getColor(R.color.white))

                    binding.topAppBar.setOnClickListener{
                        onBackPressed()
                    }
                }
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
}