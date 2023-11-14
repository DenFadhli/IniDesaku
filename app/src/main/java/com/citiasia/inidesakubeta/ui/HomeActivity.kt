package com.citiasia.inidesakubeta.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.databinding.ActivityHomeBinding
import com.citiasia.inidesakubeta.ui.ppob.PpobFragment

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(PpobFragment())
        iconBarClick()

    }

    private fun iconBarClick() {
        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.beranda -> {
                    binding.topAppBar.setTitle("IniDesaku")
                }
                R.id.geo -> {
                    binding.topAppBar.setTitle("Geospacial")
                }
                R.id.profileDesa -> {
                    binding.topAppBar.setTitle("Profile Desa")
                }
                R.id.ppob -> {
                    replaceFragment(PpobFragment())
                    binding.topAppBar.setTitle("PPOB")
                }
                R.id.profile -> {
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