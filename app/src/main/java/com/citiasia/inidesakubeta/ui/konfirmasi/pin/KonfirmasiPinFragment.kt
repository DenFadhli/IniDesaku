package com.citiasia.inidesakubeta.ui.konfirmasi.pin

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.marginTop
import androidx.navigation.fragment.findNavController
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.databinding.FragmentKonfirmasiPinBinding
import com.citiasia.inidesakubeta.utils.DataJenisPembayaranPreference
import `in`.aabhasjindal.otptextview.OTPListener


class KonfirmasiPinFragment : Fragment() {

//    private val binding by viewBinding(FragmentKonfirmasiPinBinding::bind)
    private var _binding: FragmentKonfirmasiPinBinding? = null
    private val binding get() = _binding!!

    private lateinit var pref: DataJenisPembayaranPreference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentKonfirmasiPinBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pref = DataJenisPembayaranPreference(requireContext())

        binding.topAppBar.setNavigationOnClickListener {
            onBackPressed()
        }

        onVerifyPin()
//        onClickButton()
    }

    private fun onVerifyPin() = with(binding) {
        pinView.otpListener = object: OTPListener {

            override fun onInteractionListener() {
                btnBayar.isEnabled = false
                tvErrorCaption.visibility = View.INVISIBLE
            }

            override fun onOTPComplete(otp: String?) {
                btnBayar.isEnabled = true
                onClickButton(otp!!)
            }

        }
    }

    private fun verifyPin(data: String) = with(binding) {
        if (data == "000000") {
            pinView.showSuccess()
            if (pref.getData()[0].equals("token")) {
                findNavController().navigate(R.id.action_konfirmasiPinFragment_to_konfirmasiBerhasilTokenFragment)
            } else {
                findNavController().navigate(R.id.action_konfirmasiPinFragment_to_konfrimasiBerhasilFragment)
            }
        } else {
            tvErrorCaption.visibility = View.VISIBLE
            pinView.showError()
        }
    }

    private fun onClickButton(data: String) = with(binding) {
        btnBayar.setOnClickListener {
            verifyPin(data)
        }
    }

    private fun onBackPressed() {
        requireActivity().onBackPressed()
    }


}