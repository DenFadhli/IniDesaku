package com.citiasia.inidesakubeta.ui.profilDesa

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.databinding.FragmentProfilDesaBinding
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel

class ProfilDesaFragment : Fragment() {

    private var _binding: FragmentProfilDesaBinding? = null
    private val binding get() = _binding !!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentProfilDesaBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    val imageList = ArrayList<SlideModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageList.add(SlideModel(R.drawable.carousel_1, "Title"))
        imageList.add(SlideModel(R.drawable.carousel_2, "Title"))
        imageList.add(SlideModel(R.drawable.carousel_3, "Title"))
        imageList.add(SlideModel(R.drawable.carousel_4, "Title"))
        imageList.add(SlideModel(R.drawable.carousel_5, "Title"))

        val imageSlider = view.findViewById<ImageSlider>(R.id.imageSlider2)
        imageSlider.setImageList(imageList)

    }
}