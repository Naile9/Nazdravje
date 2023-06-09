package com.example.nazdravje

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.nazdravje.databinding.ActivityMainBinding
import com.example.nazdravje.ui.dashboard.AddFragment
import com.example.nazdravje.ui.home.HomeFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView
        setupClickListener()
//        loadFragment(HomeFragment())



    }


    private fun setupClickListener() {
        binding.navView.setOnItemSelectedListener {

            val fragment = when (it.itemId) {
                R.id.navigation_home -> {
                    HomeFragment()
                }
                R.id.navigation_add -> {
                    AddFragment()
                }
                else -> {
                    HomeFragment()
                }
            }
            loadFragment(fragment)
            true
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }

}