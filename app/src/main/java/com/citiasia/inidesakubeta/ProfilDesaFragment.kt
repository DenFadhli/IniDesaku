package com.citiasia.inidesakubeta

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel

class ProfilDesaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profil_desa, container, false)
    }

    val imageList = ArrayList<SlideModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageList.add(SlideModel(R.drawable.carousel_1, "Description"))
        imageList.add(SlideModel(R.drawable.carousel_2, "Description"))
        imageList.add(SlideModel(R.drawable.carousel_3, "Description"))
        imageList.add(SlideModel(R.drawable.carousel_4, "Description"))
        imageList.add(SlideModel(R.drawable.carousel_5, "Description"))

        val imageSlider = view.findViewById<ImageSlider>(R.id.imageSlider2)
        imageSlider.setImageList(imageList)

    }
}