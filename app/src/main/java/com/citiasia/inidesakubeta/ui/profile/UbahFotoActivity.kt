package com.citiasia.inidesakubeta.ui.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.databinding.ActivityProfileBinding
import com.citiasia.inidesakubeta.databinding.ActivityUbahFotoBinding

class UbahFotoActivity : AppCompatActivity() {

    private var _binding: ActivityUbahFotoBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ubah_foto)

        binding.topAppBar.setOnClickListener{
            onBackPressed()
        }
    }
}