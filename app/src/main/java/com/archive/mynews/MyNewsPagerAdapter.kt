package com.archive.mynews

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MyNewsPagerAdapter (fm : FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0-> {
                // 플래그먼트 생성
                FragmentOne()
            }
            1-> FragmentTwo()
            else-> {
                return FragmentThree()
            }
        }
    }

    override fun getCount(): Int {
       return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0-> "One"
            1-> "Two"
            else-> {
                return "Three"
            }
        }
    }

}