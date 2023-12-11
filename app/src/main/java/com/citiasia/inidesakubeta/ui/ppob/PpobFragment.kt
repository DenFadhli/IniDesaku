package com.citiasia.inidesakubeta.ui.ppob

import android.content.Intent
import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.data.remote.dummyObject.Tvcc
import com.citiasia.inidesakubeta.data.remote.model.ResponseTvcc
import com.citiasia.inidesakubeta.databinding.FragmentPpobBinding
import com.citiasia.inidesakubeta.ui.adapter.BannerSliderAdapter
import com.citiasia.inidesakubeta.ui.ppob.bpjs.BpjsActivity
import com.citiasia.inidesakubeta.ui.ppob.listrikAir.ListrikAirActivity
import com.citiasia.inidesakubeta.ui.ppob.pulsa.PulsaActivity
import com.citiasia.inidesakubeta.ui.tvcc.TvccActivity

class PpobFragment : Fragment() {

    private var _binding: FragmentPpobBinding? = null
    private val binding get() = _binding !!

    //get dummy data for image banner
    private val dummyData = Tvcc.getImageData()
    private lateinit var dots: ArrayList<TextView>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPpobBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dots = ArrayList()

        binding.btnTopUp.icon.setTintList(null)

        iconClick()
        setBannerSlider()
    }

    private fun setBannerSlider() {
        val adapter = BannerSliderAdapter(dummyData)
        binding.viewPager.adapter = adapter

        setIndicator()

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                selectedDot(position)
                super.onPageSelected(position)
            }
        })

    }

    private fun selectedDot(position: Int) {
        val color = ContextCompat.getColor(requireContext(), R.color.primary500)
        val color1 = ContextCompat.getColor(requireContext(), R.color.grey)
        for(i in 0 until dummyData.size) {
            if(i == position) {
                dots[i].setTextColor(color)
            } else {
                dots[i].setTextColor(color1)
            }
        }
    }

    private fun setIndicator() {
        for (i in 0 until dummyData.size) {
            dots.add(TextView(requireContext()))
            dots[i].text = Html.fromHtml("&#9679", Html.FROM_HTML_MODE_LEGACY).toString()

            dots[i].textSize = 18f
            binding.dotsIndicator.addView(dots[i])
        }
    }

    private fun iconClick() {
        with(binding) {
            btnPrabayar.setOnClickListener {
                toPulsaActivity()
            }
            btnPascabayar.setOnClickListener {
                toPulsaActivity()
            }
            btnPaketData.setOnClickListener {
                toPulsaActivity()
            }
            btnTelkom.setOnClickListener {
                toPulsaActivity()
            }

            btnTagihanPln.setOnClickListener {
                toListrikAirActivity()
            }

            btnKesehatan.setOnClickListener {
                toBpjsActivity()
            }

            btnTopUp.setOnClickListener {
                startActivity(Intent(requireActivity(), TvccActivity::class.java))
            }
        }
    }

    private fun toBpjsActivity() {
        val intent = Intent(requireActivity(), BpjsActivity::class.java)
        startActivity(intent)
    }


    private fun toPulsaActivity() {
        val intent = Intent(requireActivity(), PulsaActivity::class.java)
        startActivity(intent)
    }

    private fun toListrikAirActivity() {
        val intent = Intent(requireActivity(), ListrikAirActivity::class.java)
        startActivity(intent)
    }


}