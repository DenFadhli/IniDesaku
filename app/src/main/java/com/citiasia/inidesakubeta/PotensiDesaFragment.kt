package com.citiasia.inidesakubeta

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.citiasia.inidesakubeta.databinding.FragmentBeritaBinding
import com.citiasia.inidesakubeta.databinding.FragmentPotensiDesaBinding

class PotensiDesaFragment : Fragment() {

    private var _binding: FragmentPotensiDesaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPotensiDesaBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnFisik.setOnClickListener{
            replaceFragment(PotensiFisikFragment())
        }
        binding.btnNonFisik.setOnClickListener{
            replaceFragment(PotensiNonfisikFragment())
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = parentFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container,fragment)
        fragmentTransaction.commit()
    }

}