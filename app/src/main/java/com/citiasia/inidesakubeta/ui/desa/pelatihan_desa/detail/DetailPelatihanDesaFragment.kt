package com.citiasia.inidesakubeta.ui.desa.pelatihan_desa.detail

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.data.remote.model.ResponseKegiatanDesa
import com.citiasia.inidesakubeta.data.remote.model.ResponsePelatihan
import com.citiasia.inidesakubeta.databinding.FragmentDetailPelatihanDesaBinding
import com.citiasia.inidesakubeta.ui.desa.kegiatan_desa.detail.DetailKegiatanDesaFragment

class DetailPelatihanDesaFragment : Fragment() {
    private var _binding: FragmentDetailPelatihanDesaBinding? = null
    private val binding get() = _binding!!
    private var data: ResponsePelatihan? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailPelatihanDesaBinding.inflate(layoutInflater, container, false)
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

    private fun showDetail(data: ResponsePelatihan) {
        binding.apply {
            tvDescManfaat.text = data.manfaat
            tvDescPersyaratan.text = data.persyaratan
            tvDescRincian.text = data.rincian
            tvTempat.text = data.place
            tvWaktu.text = data.time
            tvTitlePelatihan.text = data.title
            tvUang.text = data.fee
            Glide.with(requireContext())
                .load(data?.imageCover)
                .into(ivCoverPelatihan)

            if (data.videoPelatihan.isNotEmpty()) {
                val videoUri = Uri.parse(data.videoPelatihan)
                videoView.setVideoURI(videoUri)

                videoView.setOnPreparedListener { mediaPlayer ->
                    val videoWidth = mediaPlayer.videoWidth
                    val videoHeight = resources.getDimensionPixelSize(R.dimen.video_height)

                    val layoutParams = videoView.layoutParams
                    layoutParams.width = videoWidth
                    layoutParams.height = videoHeight
                    videoView.layoutParams = layoutParams

                    btnPlayVideo.setOnClickListener {
                        videoView.start()
                        btnPlayVideo.visibility = View.GONE
                    }

                    videoView.setOnCompletionListener {
                        btnPlayVideo.visibility = View.VISIBLE
                    }
                }
                videoView.visibility = View.VISIBLE
            } else {
                relativeVideo.visibility = View.GONE
                linearVideo.visibility = View.GONE
                tvVideo.visibility = View.GONE
            }
        }
    }

    companion object {
        const val EXTRA_DETAIL = "extra_detail"
        fun newInstance(data: ResponsePelatihan): DetailPelatihanDesaFragment {
            val fragment = DetailPelatihanDesaFragment()
            val args = Bundle()
            args.putParcelable(EXTRA_DETAIL, data)
            fragment.arguments = args
            return fragment
        }
    }
}