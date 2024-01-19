package com.citiasia.inidesakubeta.ui.profile.profileFragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.databinding.ActivityDetailProdukBinding
import com.citiasia.inidesakubeta.databinding.FragmentProfileBinding
import com.citiasia.inidesakubeta.databinding.FragmentSignUpBinding
import com.citiasia.inidesakubeta.ui.bantuan.BantuanActivity
import com.citiasia.inidesakubeta.ui.produk_unggulan.list.ProdukUnggulanActivity
import com.citiasia.inidesakubeta.utils.LoginPreference
import com.citiasia.inidesakubeta.utils.PilihWilayahPreference

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    private lateinit var pref: LoginPreference
    private lateinit var prefWilayah: PilihWilayahPreference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.bantuanBtn.setOnClickListener {
            startActivity(Intent(requireActivity(), BantuanActivity::class.java))
        }

        binding.btnKeluar.setOnClickListener {
            requireActivity().finishAffinity()
            System.exit(0)
        }

        pref = LoginPreference(requireContext())
        prefWilayah = PilihWilayahPreference(requireContext())
        binding.tvNama.text = if (pref.getData().nama.isNullOrEmpty()) "Tamu" else pref.getData().nama
        binding.tvEmailProfile.text = if (pref.getData().email.isNullOrEmpty()) "Tamu" else pref.getData().email
        binding.tvEmailValue.text = if (pref.getData().email.isNullOrEmpty()) "Tamu" else pref.getData().email
        binding.tvNomorTeleponValue.text = if (pref.getData().phoneNumber.isNullOrEmpty()) "Tamu" else pref.getData().phoneNumber
        binding.tvAlamatValue.text = "${prefWilayah.getData().desaKelurahan}, ${prefWilayah.getData().kecamatan}, ${prefWilayah.getData().kotaKabupaten}, ${prefWilayah.getData().provinsi}"
    }
}