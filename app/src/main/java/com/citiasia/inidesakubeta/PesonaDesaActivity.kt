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
import com.citiasia.inidesakubeta.ui.main.SectionsPagerAdapter
import com.citiasia.inidesakubeta.databinding.ActivityPesonaDesaBinding

class PesonaDesaActivity : AppCompatActivity() {

private lateinit var binding: ActivityPesonaDesaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

     binding = ActivityPesonaDesaBinding.inflate(layoutInflater)
     setContentView(binding.root)

    }
}