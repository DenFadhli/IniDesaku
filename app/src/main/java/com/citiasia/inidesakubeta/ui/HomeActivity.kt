package com.citiasia.inidesakubeta.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.data.remote.model.LoginData
import com.citiasia.inidesakubeta.databinding.ActivityHomeBinding
import com.citiasia.inidesakubeta.ui.bantuan.BantuanListActivity
import com.citiasia.inidesakubeta.ui.pasar_desa.PasarDesaActivity
import com.citiasia.inidesakubeta.ui.ppob.PpobFragment
import com.citiasia.inidesakubeta.ui.tvcc.tvccHome.TvccFrontFragment
import com.citiasia.inidesakubeta.utils.LoginPreference

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var pref: LoginPreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val token = intent.getStringExtra("TOKEN")
        val username = intent.getStringExtra("USERNAME")
        val nama = intent.getStringExtra("NAMA")
        val email = intent.getStringExtra("EMAIL")
        Log.d("Home Activity", "cek data pref lewat intent.getString: $token, $username, $nama, $email")

        pref = LoginPreference(this)
//        val data = LoginData(token, username, nama, username)
        Log.d("Home Activity", "cek data pref lewat getData() preference: ${pref.getData()}")

        replaceFragment(PpobFragment())
        iconBarClick()

    }

    private fun iconBarClick() {
        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.beranda -> {
                    binding.topAppBar.title = "IniDesaku"
                }
                R.id.geo -> {
                    val intent = Intent(this, PasarDesaActivity::class.java)
                    startActivity(intent)
                    binding.topAppBar.title = "Geospacial"
                }
                R.id.profileDesa -> {
                    binding.topAppBar.title = "Profile Desa"
                }
                R.id.ppob -> {
                    replaceFragment(PpobFragment())
                    binding.topAppBar.title = "PPOB"
                }
                R.id.profile -> {
                    val intent = Intent(this, BantuanListActivity::class.java)
                    startActivity(intent)
                    binding.topAppBar.title = "Profile"
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