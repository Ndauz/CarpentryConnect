package com.example.carpentryconnect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.carpentryconnect.databinding.ActivityMainBinding
import com.example.carpentryconnect.fragments.FragmentHome
import com.example.carpentryconnect.fragments.FragmentJobs
import com.example.carpentryconnect.fragments.FragmentProfile
import com.example.carpentryconnect.fragments.FragmentSearch
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val homeFragmentHome = FragmentHome()
        val searchFragmentHome = FragmentSearch()
        val jobsFragmentHome = FragmentJobs()
        val profileFragmentHome = FragmentProfile()

        binding.bottomNavigation.setOnClickListener {
            when(it.id) {
                R.id.home -> {
                    setCurrentFragment(homeFragmentHome)
                    Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
                }
                R.id.search -> {
                    setCurrentFragment(searchFragmentHome)
                    Toast.makeText(this, "Donations", Toast.LENGTH_SHORT).show()
                }
                R.id.jobs -> {
                    setCurrentFragment(jobsFragmentHome)
                    Toast.makeText(this, "Map", Toast.LENGTH_SHORT).show()
                }
                R.id.profile -> {
                    setCurrentFragment(profileFragmentHome)
                    Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show()
                }
            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .apply {
                replace(R.id.flFragment, fragment)
                commit()
            }
    }

}