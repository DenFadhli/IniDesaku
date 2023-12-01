package com.citiasia.inidesakubeta.ui.bantuan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.citiasia.inidesakubeta.data.BantuanData
import com.citiasia.inidesakubeta.databinding.ActivityInformasiBantuanBinding
import com.citiasia.inidesakubeta.ui.adapter.BantuanAdapter

class BantuanListActivity : AppCompatActivity() {

    private var _binding: ActivityInformasiBantuanBinding? = null
    private lateinit var adapter: BantuanAdapter
    private var mList = ArrayList<BantuanData>()
    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityInformasiBantuanBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        var rvListBantuan = binding?.rvListBantuan

        rvListBantuan?.setHasFixedSize(true)
        rvListBantuan?.layoutManager = LinearLayoutManager(this)
        addDataToList()
        adapter = BantuanAdapter(mList)
        rvListBantuan?.adapter = adapter

    }

    private fun addDataToList() {
        mList.add(
            BantuanData(
                "Bagaimana cara membuat akun di aplikasi ini?",
                "Anda dapat mengatur profil Anda dengan masuk ke menu pengaturan dan memilih opsi \"Profil.\""
            )
        )
        mList.add(
            BantuanData(
                "Bagaimana cara mengatur profil saya?",
                "..."
            )
        )
        mList.add(
            BantuanData(
                "Apakah data pribadi saya aman di dalam aplikasi ini?",
                "..."
            )
        )
        mList.add(
            BantuanData(
                "Apakah aplikasi ini memerlukan koneksi internet?",
                "..."
            )
        )
        mList.add(
            BantuanData(
                "Apakah aplikasi ini gratis digunakan?",
                "..."

            )
        )
        mList.add(
            BantuanData(
                "Apa yang harus saya lakukan jika lupa kata sandi akun saya?",
                "..."
            )
        )
    }
}