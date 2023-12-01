package com.citiasia.inidesakubeta.ui.splashScreenFragment

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.citiasia.inidesakubeta.R


class SplashScreenFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Handler().postDelayed({
            lifecycleScope.launchWhenCreated {
                findNavController().navigate(R.id.action_splashScreenFragment_to_homeActivity)
//                findNavController().navigate(R.id.action_splashScreenFragment_to_onBoardingFragment)
            }
        }, MILISECON.toLong())
    }

    companion object{
        const val TAG = "SplashScreenFragment"
        const val MILISECON = 3000.0
    }

}