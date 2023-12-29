package com.citiasia.inidesakubeta.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.citiasia.inidesakubeta.ui.beranda.BerandaFragment
import com.citiasia.inidesakubeta.ui.profilDesa.ProfilDesaFragment
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.databinding.ActivityHomeBinding
import com.citiasia.inidesakubeta.ui.geografi.geospasial.GeospasialActivity
import com.citiasia.inidesakubeta.ui.ppob.PpobFragment
import com.citiasia.inidesakubeta.ui.profile.profileFragment.ProfileFragment

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(BerandaFragment())
        iconBarClick()

    }

    private fun iconBarClick() {
        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.beranda -> {
                    replaceFragment(BerandaFragment())
                    binding.topAppBar.setTitle("IniDesaku")
                }
                R.id.geo -> {
//                    replaceFragment(GeospasialActivity())
                    binding.topAppBar.setTitle("Geospacial")
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