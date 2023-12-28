package com.citiasia.inidesakubeta.ui.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.citiasia.inidesakubeta.ui.desa.kegiatan_desa.list.KegiatanDesaFragment
import com.citiasia.inidesakubeta.ui.desa.pelatihan_desa.list.PelatihanDesaFragment
import com.citiasia.inidesakubeta.ui.desa.penyuluhan_desa.list.PenyuluhanDesaFragment

class KegiatanDesaTabAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when(position){
            0 -> fragment = KegiatanDesaFragment()
            1 -> fragment = PelatihanDesaFragment()
            2 -> fragment = PenyuluhanDesaFragment()
        }
        return fragment as Fragment
    }

    override fun getItemCount(): Int {
        return 3
    }
}