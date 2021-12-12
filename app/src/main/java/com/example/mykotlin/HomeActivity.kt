package com.example.mykotlin

import android.icu.lang.UCharacter
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.example.mykotlin.ui.main.SectionsPagerAdapter
import com.example.mykotlin.databinding.ActivityHomeBinding
import com.example.mykotlin.databinding.CustomTabMenuBinding
import com.google.android.material.tabs.TabLayoutMediator

class HomeActivity : AppCompatActivity() {

    private lateinit var sectionsPagerAdapter: SectionsPagerAdapter
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager , lifecycle)

        setupViewPager()
        setupWidget()
        setupTabs()





        }

    private fun setupTabs() {
        TabLayoutMediator(binding.tabs,binding.viewPager, TabLayoutMediator.TabConfigurationStrategy { tab, position ->

            val binding = CustomTabMenuBinding.inflate(layoutInflater)
            binding.iconTab.setImageResource(sectionsPagerAdapter.tabIcon[position])
            binding.textTab.text=sectionsPagerAdapter.tabText[position]

            tab.customView = binding.root
        }).attach()
    }

    private fun setupWidget() {

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
    }
}

    private fun setupViewPager() {
        binding.viewPager.apply {
            adapter = sectionsPagerAdapter
        } .also {
            it.setPageTransformer(HorizontalFlipTransformation())
            it.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    if (position == 0){
                        binding.fab.visibility = View.INVISIBLE
                    }else{
                        binding.fab.visibility = View.VISIBLE
                    }
                }
            })
        }
    }
}