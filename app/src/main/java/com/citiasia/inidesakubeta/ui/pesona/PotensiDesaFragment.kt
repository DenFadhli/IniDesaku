package com.citiasia.inidesakubeta.ui.pesona

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.citiasia.inidesakubeta.R
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

        binding.toggleButtonGroup.addOnButtonCheckedListener{toggleButtonGroup, checkedId, isCheked ->
            if (isCheked) {
                when (checkedId) {
                    R.id.btn_fisik -> replaceFragment(PotensiFisikFragment())
                    R.id.btn_non_fisik -> replaceFragment(PotensiNonfisikFragment())
                }
            } else {
                if (toggleButtonGroup.checkedButtonId == View.NO_ID) {
                    Toast.makeText(requireContext(), "LIST SHOW", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = parentFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container,fragment)
        fragmentTransaction.commit()
    }

}