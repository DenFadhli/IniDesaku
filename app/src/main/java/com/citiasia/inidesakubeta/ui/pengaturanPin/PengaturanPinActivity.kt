package com.citiasia.inidesakubeta.ui.pengaturanPin

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.databinding.ActivityPengaturanPinBinding

class PengaturanPinActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPengaturanPinBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPengaturanPinBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

}