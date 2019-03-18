package com.example.studyfragment

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

class MainViewPagerAdapter(fm : FragmentManager) : FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment? {
        return when(position){
            0 -> HomeFragment()
            1 -> CartFragment()
            2 -> AnnoFragment()
            3 -> AccountFragment()
            else -> null
        }
    }

    override fun getCount(): Int = 4
}