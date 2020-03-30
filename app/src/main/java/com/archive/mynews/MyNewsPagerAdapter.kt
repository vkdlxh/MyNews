package com.archive.mynews

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MyNewsPagerAdapter (fm : FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0-> {
                // 플래그먼트 생성
                TopHeadingFragment()
            }
            1-> EverythingFragment()
            else-> {
                return SourceFragment()
            }
        }
    }

    override fun getCount(): Int {
       return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0-> "TopHeading"
            1-> "Everything"
            else-> {
                return "Source"
            }
        }
    }
}