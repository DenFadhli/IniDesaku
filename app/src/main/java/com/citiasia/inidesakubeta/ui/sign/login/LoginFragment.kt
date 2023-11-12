package com.citiasia.inidesakubeta.ui.sign.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonCLick()
    }

    private fun buttonCLick() {
        binding.btnLogin.setOnClickListener {
            Toast.makeText(requireContext(), "Belom bisa bang!", Toast.LENGTH_SHORT).show()
        }
    }

}