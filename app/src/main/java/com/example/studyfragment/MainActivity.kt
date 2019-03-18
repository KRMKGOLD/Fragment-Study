package com.example.studyfragment

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {
        val fragmentManager = supportFragmentManager
        val mainfragment = fragmentManager.beginTransaction()

        when (it.itemId) {
            R.id.menu_home -> {
                mainfragment.replace(R.id.mainFragment, HomeFragment()).commitAllowingStateLoss()
            }
            R.id.menu_cart -> {
                mainfragment.replace(R.id.mainFragment, CartFragment()).commitAllowingStateLoss()
            }
            R.id.menu_anno -> {
                mainfragment.replace(R.id.mainFragment, AnnoFragment()).commitAllowingStateLoss()
            }
            R.id.menu_account -> {
                mainfragment.replace(R.id.mainFragment, AccountFragment()).commitAllowingStateLoss()
            }
        }
        return@OnNavigationItemSelectedListener true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

    }
}