package com.citiasia.inidesakubeta.ui.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.databinding.ActivityCompleteProfileBinding
import com.citiasia.inidesakubeta.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private var _binding: ActivityProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        binding.topAppBar.setNavigationIcon(R.drawable.baseline_arrow_back_24)
        binding.topAppBar.setNavigationIconTint(resources.getColor(R.color.white))

        binding.topAppBar.setOnClickListener{
            onBackPressed()
        }
    }
}