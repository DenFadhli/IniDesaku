package com.citiasia.inidesakubeta.ui.onBoardingFragment

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.ui.onBoardingFragment.content.OnBoardingContentFragment

class OnBoardingFragmentAdapter(
    fragmentActivity: FragmentActivity,
    private val context: Context
) :
    FragmentStateAdapter(fragmentActivity) {

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> OnBoardingContentFragment.newInstance(
                context.resources.getString(R.string.title_onboarding_1),
                context.resources.getString(R.string.description_onboarding_1),
                R.drawable.image_boarding_satu
            )
            1 -> OnBoardingContentFragment.newInstance(
                context.resources.getString(R.string.title_onboarding_2),
                context.resources.getString(R.string.description_onboarding_2),
                R.drawable.image_boarding_dua
            )
            else -> OnBoardingContentFragment.newInstance(
                context.resources.getString(R.string.title_onboarding_3),
                context.resources.getString(R.string.description_onboarding_3),
                R.drawable.image_boarding_tiga

            )
        }
    }

    override fun getItemCount(): Int {
        return 3
    }
}