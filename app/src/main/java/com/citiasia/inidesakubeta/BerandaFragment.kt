package com.citiasia.inidesakubeta

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.citiasia.inidesakubeta.databinding.FragmentBerandaBinding
import com.citiasia.inidesakubeta.databinding.FragmentPpobBinding
import com.citiasia.inidesakubeta.ui.ppob.bpjs.BpjsActivity
import com.citiasia.inidesakubeta.ui.ppob.listrikAir.ListrikAirActivity
import com.citiasia.inidesakubeta.ui.ppob.pulsa.PulsaActivity
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BerandaFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BerandaFragment : Fragment() {

    private var _binding: FragmentBerandaBinding? = null
    private val binding get() = _binding !!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

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
            btnPesonaDesa.setOnClickListener {
                toPesonaDesa()
            }
        }
    }

    private fun toPesonaDesa() {
        val intent = Intent(requireActivity(), PesonaDesaActivity::class.java)
        startActivity(intent)
    }

}