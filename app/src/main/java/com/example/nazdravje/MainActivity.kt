package com.example.nazdravje

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.nazdravje.databinding.ActivityMainBinding
import com.example.nazdravje.ui.LoginActivity
import com.example.nazdravje.ui.dashboard.AddFragment
import com.example.nazdravje.ui.home.HomeFragment
import com.example.nazdravje.ui.notifications.FavoritesFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        setupClickListener()

        binding.logout.setOnClickListener{

            val sharedPreferences = getSharedPreferences("LoginCredentials", MODE_PRIVATE)
            val myEdit = sharedPreferences.edit()

            myEdit.putString("email", "")
            myEdit.putString("password", "")
            myEdit.apply()

            val intent: Intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            this.startActivity(intent)

        }
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