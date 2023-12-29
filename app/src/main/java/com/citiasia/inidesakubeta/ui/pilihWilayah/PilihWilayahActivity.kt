package com.citiasia.inidesakubeta.ui.pilihWilayah

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.databinding.ActivityPilihWilayahBinding
import com.citiasia.inidesakubeta.ui.HomeActivity
import com.citiasia.inidesakubeta.utils.PilihWilayahPreference

class PilihWilayahActivity : AppCompatActivity() {

    private var _binding: ActivityPilihWilayahBinding? = null
    private val binding get() = _binding!!

    private lateinit var pref: PilihWilayahPreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityPilihWilayahBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        pref = PilihWilayahPreference(this)

        val provinsiItems = resources.getStringArray(R.array.provinsi_items)
        val kotaMap = mapOf(
            "DKI Jakarta" to resources.getStringArray(R.array.kota_kabupaten_jakarta_items),
            "Jawa Barat" to resources.getStringArray(R.array.kota_kabupaten_jawabarat_items),
            "Jawa Tengah" to resources.getStringArray(R.array.kota_kabupaten_jawatengah_items),
            "Jawa Timur" to resources.getStringArray(R.array.kota_kabupaten_jawatimur_items),
        )

        val adapterProvinsi = ArrayAdapter(this, android.R.layout.simple_list_item_1, provinsiItems)
        binding.spinProvinsi.setAdapter(adapterProvinsi)

        binding.spinProvinsi.setOnItemClickListener { _, _, position, _ ->
            val selectedProvinsi = provinsiItems[position]
            val kotaItems = kotaMap[selectedProvinsi]

            if (kotaItems != null) {
                val adapterKota = ArrayAdapter(this, android.R.layout.simple_list_item_1, kotaItems)
                binding.spinKota.setAdapter(adapterKota)
            } else {
                binding.spinKota.setText("")
                binding.spinKota.setAdapter(null)
            }
        }

        binding.btnNext.setOnClickListener {
            val intent = Intent(this@PilihWilayahActivity, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}