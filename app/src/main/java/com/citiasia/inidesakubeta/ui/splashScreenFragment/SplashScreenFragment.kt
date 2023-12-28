package com.citiasia.inidesakubeta.ui.splashScreenFragment

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.data.remote.model.LoginData
import com.citiasia.inidesakubeta.utils.LoginPreference


class SplashScreenFragment : Fragment() {

    private lateinit var pref: LoginPreference
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pref = LoginPreference(requireContext())
        val savedData = pref.getData()

        Handler().postDelayed({
            lifecycleScope.launchWhenCreated {
                if (savedData.token?.isNotEmpty() == true && savedData.username?.isNotEmpty() == true) {
                    redirectUserToHomeScreen(savedData)
                } else {
                    redirectToLoginScreen()
                }
            }
        }, MILISECON.toLong())
    }

    private fun redirectUserToHomeScreen(savedData: LoginData) {
        val bundle = Bundle().apply {savedData}
        findNavController().navigate(
            R.id.action_splashScreenFragment_to_homeActivity,
            bundle
        )
        requireActivity().finish()
    }

    private fun redirectToLoginScreen() {
        lifecycleScope.launchWhenCreated {
            findNavController().navigate(R.id.action_splashScreenFragment_to_onBoardingFragment)
        }
    }

    companion object{
        const val TAG = "SplashScreenFragment"
        const val MILISECON = 3000.0
    }

}