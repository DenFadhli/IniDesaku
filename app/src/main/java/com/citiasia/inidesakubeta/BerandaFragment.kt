package com.citiasia.inidesakubeta

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.citiasia.inidesakubeta.databinding.FragmentBerandaBinding
import com.citiasia.inidesakubeta.ui.tvcc.TvccActivity
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel

class BerandaFragment : Fragment() {

    private var _binding: FragmentBerandaBinding? = null
    private val binding get() = _binding !!

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

        iconClick()
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
        }
    }

}