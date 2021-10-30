package com.gunder.film.ui.home

import android.content.Context
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.gunder.film.MovieFragment
import com.gunder.film.R
import com.gunder.film.TvFragment

class SectionPageAdapter(private val mContext: Context, fm: FragmentManager) : FragmentPagerAdapter(
    fm,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {
    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = MovieFragment()
            1 -> fragment = TvFragment()
        }
        return fragment as Fragment
    }

    private val tabTitle = intArrayOf(
        R.string.movie,
        R.string.tv
    )

    override fun getCount(): Int {
        return 2
    }

    @Nullable
    override fun getPageTitle(position: Int): CharSequence? {
        return mContext.getString(tabTitle[position])
    }


}