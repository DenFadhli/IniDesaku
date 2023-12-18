package com.citiasia.inidesakubeta

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.viewpager2.widget.ViewPager2
import com.citiasia.inidesakubeta.databinding.ActivityPesonaDesaBinding
import com.citiasia.inidesakubeta.ui.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class PesonaDesaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPesonaDesaBinding
    private lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPesonaDesaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

        with(binding){
            viewPager.adapter = viewPagerAdapter

            TabLayoutMediator(tabLayout, viewPager){ tab, position ->
                when(position){
                    0 -> tab.text = "Berita Desa"
                    1 -> tab.text = "Potensi Desa"
                    2 -> tab.text = "Budaya Lokal"
                    3 -> tab.text = "Wisata Desa"
                }
            }.attach()
        }

    }
}