package com.citiasia.inidesakubeta.ui.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.citiasia.inidesakubeta.ui.ppob.listrikAir.tagihan.TagihanFragment

class ListrikAirTabAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = TagihanFragment()
            1 -> fragment = TagihanFragment()
            2 -> fragment = TagihanFragment()
        }
        return fragment as Fragment
    }

    override fun getItemCount(): Int {
        return 3
    }
}