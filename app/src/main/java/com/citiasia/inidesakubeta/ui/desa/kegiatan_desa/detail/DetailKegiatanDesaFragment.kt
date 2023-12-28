package com.citiasia.inidesakubeta.ui.desa.kegiatan_desa.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.data.remote.model.ResponseKegiatanDesa
import com.citiasia.inidesakubeta.data.remote.model.ResponsePelayananDesa
import com.citiasia.inidesakubeta.data.remote.model.ResponseProdukUnggulan
import com.citiasia.inidesakubeta.databinding.FragmentDetailKegiatanDesaBinding
import com.citiasia.inidesakubeta.ui.ViewModelFactory
import com.citiasia.inidesakubeta.ui.adapter.KegiatanDesaAdapter
import com.citiasia.inidesakubeta.ui.desa.kegiatan_desa.list.KegiatanDesaViewModel
import com.citiasia.inidesakubeta.ui.produk_unggulan.detail.DetailProdukUnggulanActivity

class DetailKegiatanDesaFragment : Fragment() {
    private var _binding: FragmentDetailKegiatanDesaBinding? = null
    private val binding get() = _binding!!
    private var data: ResponseKegiatanDesa? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailKegiatanDesaBinding.inflate(layoutInflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        data = arguments?.getParcelable(EXTRA_DETAIL)
        data?.let {
            showDetail(it)
        }

        binding.topAppBar.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }

    }

    private fun showDetail(data: ResponseKegiatanDesa) {
        binding.apply {
            tvDescManfaat.text = data.manfaat
            tvDescPersyaratan.text = data.persyaratan
            tvDescRincian.text = data.rincian
            tvTempat.text = data.place
            tvWaktu.text = data.time
            tvTitleKegiatan.text = data.title
            Glide.with(requireContext())
                .load(data?.imageCover)
                .into(ivCoverKegiatan)
        }
    }

    companion object {
        const val EXTRA_DETAIL = "extra_detail"
        fun newInstance(data: ResponseKegiatanDesa): DetailKegiatanDesaFragment {
            val fragment = DetailKegiatanDesaFragment()
            val args = Bundle()
            args.putParcelable(EXTRA_DETAIL, data)
            fragment.arguments = args
            return fragment
        }
    }
}