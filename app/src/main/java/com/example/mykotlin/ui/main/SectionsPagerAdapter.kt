package com.example.mykotlin.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mykotlin.R


class SectionsPagerAdapter(private val context: Context, fm: FragmentManager, lifecycle: Lifecycle) :FragmentStateAdapter  (fm, lifecycle) {

    val tabIcon: Array<Int> = arrayOf(R.drawable.ic_product, R.drawable.ic_stock)
    val tabText: Array<String> = arrayOf(*context.resources.getStringArray(R.array.tab_title))

    override fun getItemCount() = tabIcon.size
    override fun createFragment(position: Int): Fragment {
        return PlaceholderFragment.newInstance(position + 1)
    }
}
