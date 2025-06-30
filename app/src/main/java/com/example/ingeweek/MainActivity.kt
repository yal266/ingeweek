package com.example.ingeweek

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.ingeweek.fragments.AgendaFragment
import com.example.ingeweek.fragments.CompetenciasFragment
import com.example.ingeweek.fragments.UbicacionesFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViews()
        setupViewPager()
        setupBottomNavigation()
    }

    private fun setupViews() {
        viewPager = findViewById(R.id.viewPager)
        bottomNav = findViewById(R.id.bottomNavigation)

        setSupportActionBar(findViewById(R.id.toolbar))
    }

    private fun setupViewPager() {
        val adapter = ViewPagerAdapter(this)
        viewPager.adapter = adapter

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                bottomNav.menu.getItem(position).isChecked = true
            }
        })
    }

    private fun setupBottomNavigation() {
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_agenda -> {
                    viewPager.currentItem = 0
                    true
                }
                R.id.nav_competencias -> {
                    viewPager.currentItem = 1
                    true
                }
                R.id.nav_ubicaciones -> {
                    viewPager.currentItem = 2
                    true
                }
                else -> false
            }
        }
    }

    private inner class ViewPagerAdapter(activity: AppCompatActivity) :
        FragmentStateAdapter(activity) {

        override fun getItemCount(): Int = 3

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> AgendaFragment()
                1 -> CompetenciasFragment()
                2 -> UbicacionesFragment()
                else -> AgendaFragment()
            }
        }
    }
}