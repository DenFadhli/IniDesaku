package com.citiasia.inidesakubeta.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.citiasia.inidesakubeta.ui.pesona.BeritaFragment
import com.citiasia.inidesakubeta.ui.pesona.BudayaFragment
import com.citiasia.inidesakubeta.ui.pesona.PotensiDesaFragment
import com.citiasia.inidesakubeta.ui.pesona.WisataFragment

class ViewPagerAdapter (fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle){
    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        var fragment = Fragment()
        when(position){
            0 -> fragment = BeritaFragment()
            1 -> fragment = PotensiDesaFragment()
            2 -> fragment = BudayaFragment()
            3 -> fragment = WisataFragment()
        }
        return fragment
    }
}