package com.citiasia.inidesakubeta.ui.profile.profileFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.databinding.ActivityDetailProdukBinding
import com.citiasia.inidesakubeta.databinding.FragmentProfileBinding
import com.citiasia.inidesakubeta.databinding.FragmentSignUpBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.bantuanBtn.setOnClickListener {
            findNavController().navigate(R.id.action_profilFragment_to_bantuanListActivity)
            requireActivity().finish()
        }

    }


}