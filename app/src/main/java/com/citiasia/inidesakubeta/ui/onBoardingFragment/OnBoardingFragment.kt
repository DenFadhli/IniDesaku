package com.citiasia.inidesakubeta.ui.onBoardingFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.databinding.FragmentOnBoardingBinding
import com.google.android.material.tabs.TabLayoutMediator

class OnBoardingFragment : Fragment() {

    private var _binding: FragmentOnBoardingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOnBoardingBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonClick()


        binding.viewPager.adapter = OnBoardingFragmentAdapter(requireActivity(), requireContext())
        TabLayoutMediator(binding.pageIndicator, binding.viewPager) { _, _ ->}.attach()
        binding.viewPager.offscreenPageLimit = 1
    }

    private fun buttonClick() {
        binding.btnMasuk.setOnClickListener {
            findNavController().navigate(R.id.action_onBoardingFragment_to_loginFragment)
        }

        binding.btnDaftar.setOnClickListener {
            findNavController().navigate(R.id.action_onBoardingFragment_to_signUpFragment)
        }
        binding.btnTamu.setOnClickListener {
            findNavController().navigate(R.id.action_onBoardingFragment_to_pilihWilayahFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        _binding = null
    }

}