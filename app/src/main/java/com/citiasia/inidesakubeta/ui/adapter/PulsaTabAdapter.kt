package com.citiasia.inidesakubeta.ui.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.citiasia.inidesakubeta.ui.ppob.PpobFragment
import com.citiasia.inidesakubeta.ui.ppob.pulsa.prabayar.PrabayarFragment

class PulsaTabAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = PrabayarFragment()
            1 -> fragment = PrabayarFragment()
            2 -> fragment = PrabayarFragment()
        }
        return fragment as Fragment
    }

    override fun getItemCount(): Int {
        return 3
    }
}