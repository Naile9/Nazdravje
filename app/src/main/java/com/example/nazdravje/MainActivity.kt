package com.example.nazdravje

import android.os.Bundle
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.nazdravje.databinding.ActivityMainBinding
import com.example.nazdravje.ui.dashboard.AddFragment
import com.example.nazdravje.ui.home.HomeFragment
import com.example.nazdravje.ui.notifications.FavoritesFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupClickListener()
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
                    if (GlobalData.isAnonymous){
                        Toast.makeText(binding.root.context, "Anonymous users cant save data", Toast.LENGTH_SHORT)
                        HomeFragment()
                    }else {
                        FavoritesFragment()
                    }
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