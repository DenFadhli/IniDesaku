package com.citiasia.inidesakubeta.ui.desa.penyuluhan_desa.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.citiasia.inidesakubeta.data.remote.model.ResponsePenyuluhan
import com.citiasia.inidesakubeta.databinding.FragmentDetailPenyuluhanDesaBinding
import com.citiasia.inidesakubeta.databinding.FragmentPenyuluhanDesaBinding

class DetailPenyuluhanDesaFragment : Fragment() {
    private var _binding: FragmentDetailPenyuluhanDesaBinding? = null
    private val binding get() = _binding!!
    private var data: ResponsePenyuluhan? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailPenyuluhanDesaBinding.inflate(layoutInflater, container, false)
        return binding.root
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

    private fun showDetail(data: ResponsePenyuluhan) {
        binding.apply {
            tvDescManfaat.text = data.manfaat
            tvDescPersyaratan.text = data.persyaratan
            tvDescRincian.text = data.rincian
            tvTempat.text = data.place
            tvWaktu.text = data.time
            tvTitlePenyuluhan.text = data.title
            Glide.with(requireContext())
                .load(data?.imageCover)
                .into(ivCoverPenyuluhan)
        }
    }

    companion object {
        const val EXTRA_DETAIL = "extra_detail"
        fun newInstance(data: ResponsePenyuluhan): DetailPenyuluhanDesaFragment {
            val fragment = DetailPenyuluhanDesaFragment()
            val args = Bundle()
            args.putParcelable(EXTRA_DETAIL, data)
            fragment.arguments = args
            return fragment
        }
    }
}