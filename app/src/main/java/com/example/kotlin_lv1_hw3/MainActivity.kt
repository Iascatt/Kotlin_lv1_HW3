package com.example.kotlin_lv1_hw3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.kotlin_lv1_hw3.ui.main.ContentFragment.Companion.newInstance
import com.example.kotlin_lv1_hw3.ui.main.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.home -> {
                    true
                }
                R.id.calendar -> {
                    true
                }
                R.id.content -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, newInstance())
                        .commitNow()
                    true
                }
                R.id.profile -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, ProfileFragment.newInstance())
                        .commitNow()
                    true
                }
                else -> false
            }
        }

    }


}