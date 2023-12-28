package com.citiasia.inidesakubeta.ui.pilihWilayah

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.data.database.User
import com.citiasia.inidesakubeta.databinding.ActivityOtpBinding
import com.citiasia.inidesakubeta.databinding.ActivityPilihWilayahBinding
import com.citiasia.inidesakubeta.ui.HomeActivity
import kotlin.properties.Delegates

class PilihWilayahActivity : AppCompatActivity() {

    private var _binding: ActivityPilihWilayahBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityPilihWilayahBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding.btnNext.setOnClickListener {
            val intent = Intent(this@PilihWilayahActivity, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}