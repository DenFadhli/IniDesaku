package com.citiasia.inidesakubeta.ui.bantuan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.data.BantuanData
import com.citiasia.inidesakubeta.databinding.FragmentListBantuanBinding
import com.citiasia.inidesakubeta.ui.adapter.BantuanAdapter

class BantuanListFragment : Fragment() {

    private var _binding: FragmentListBantuanBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: BantuanAdapter
    private var mList = ArrayList<BantuanData>()
    private lateinit var rvListBantuan: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        _binding = FragmentListBantuanBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvListBantuan = binding.rvListBantuan

        rvListBantuan?.setHasFixedSize(true)
        rvListBantuan?.layoutManager = LinearLayoutManager(requireContext())
        addDataToList()
        adapter = BantuanAdapter(mList)
        rvListBantuan?.adapter = adapter

        binding.bantuanButton.setOnClickListener {
            val fragment = BantuanFormFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_layout, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}