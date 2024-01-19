package com.citiasia.inidesakubeta.ui.beranda

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.citiasia.inidesakubeta.ui.pesona.PesonaDesaActivity
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.databinding.FragmentBerandaBinding
import com.citiasia.inidesakubeta.ui.desa.kegiatan_desa.KegiatanActivity
import com.citiasia.inidesakubeta.ui.desa.pelayanan_desa.list.PelayananDesaActivity
import com.citiasia.inidesakubeta.ui.donasi.list.DonasiActivity
import com.citiasia.inidesakubeta.ui.pasar_desa.PasarDesaActivity
import com.citiasia.inidesakubeta.ui.produk_unggulan.list.ProdukUnggulanActivity
import com.citiasia.inidesakubeta.ui.tvcc.TvccActivity
import com.citiasia.inidesakubeta.utils.LoginPreference
import com.citiasia.inidesakubeta.utils.PilihWilayahPreference
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel

class BerandaFragment : Fragment() {

    private var _binding: FragmentBerandaBinding? = null
    private val binding get() = _binding !!

    private lateinit var pref: PilihWilayahPreference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBerandaBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    val imageList = ArrayList<SlideModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageList.add(SlideModel(R.drawable.carousel_1))
        imageList.add(SlideModel(R.drawable.carousel_2))
        imageList.add(SlideModel(R.drawable.carousel_3))
        imageList.add(SlideModel(R.drawable.carousel_4))
        imageList.add(SlideModel(R.drawable.carousel_5))

        val imageSlider = view.findViewById<ImageSlider>(R.id.imageSlider)
        imageSlider.setImageList(imageList)

        pref = PilihWilayahPreference(requireContext())

        iconClick()


        binding.alamatDesa.text = "${pref.getData().provinsi}, ${pref.getData().kotaKabupaten}, ${pref.getData().kecamatan}, ${pref.getData().desaKelurahan}"
    }

    private fun iconClick() {
        with(binding) {
            cariDesa.setOnClickListener {
                val intent = Intent(requireActivity(), CariDesaActivity::class.java)
                startActivity(intent)
            }
            btnPesonaDesa.setOnClickListener {
                val intent = Intent(requireActivity(), PesonaDesaActivity::class.java)
                startActivity(intent)
            }
            btnTvcc.setOnClickListener {
                startActivity(Intent(requireActivity(), TvccActivity::class.java))
            }
            btnDonasi.setOnClickListener {
                startActivity(Intent(requireActivity(), DonasiActivity::class.java))
            }
            btnKegiatanDesa.setOnClickListener {
                startActivity(Intent(requireActivity(), KegiatanActivity::class.java))
            }
            btnLayananDesa.setOnClickListener {
                startActivity(Intent(requireActivity(), PelayananDesaActivity::class.java))
            }
            btnProdukUnggulan.setOnClickListener {
                startActivity(Intent(requireActivity(), ProdukUnggulanActivity::class.java))
            }
            btnPasarDesa.setOnClickListener {
                val intent = Intent(requireActivity(), PasarDesaActivity::class.java)
                startActivity(intent)
            }
            btnKoperasi.setOnClickListener {}
        }
    }

}