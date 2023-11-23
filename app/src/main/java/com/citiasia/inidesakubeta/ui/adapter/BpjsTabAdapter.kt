package com.citiasia.inidesakubeta.ui.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.citiasia.inidesakubeta.ui.ppob.bpjs.kesehatan.BpjsKesehatanFragment
import com.citiasia.inidesakubeta.ui.ppob.listrikAir.tagihan.TagihanFragment

class BpjsTabAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = BpjsKesehatanFragment()
            1 -> fragment = BpjsKesehatanFragment()
        }
        return fragment as Fragment
    }

    override fun getItemCount(): Int {
        return 2
    }
}