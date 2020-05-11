package com.archive.mynews.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MyNewsPagerAdapter (fm : FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                val fragment = TopHeadingFragment()
                TopHeadingFragment()
            }
            1 -> EverythingFragment()
            else -> SourceFragment()
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