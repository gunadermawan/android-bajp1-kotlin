package com.gunder.film.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gunder.film.R
import com.synnapps.carouselview.ImageListener
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        carausel_view.pageCount = carauselImg.size
        carausel_view.setImageListener(imgListener)
        setSupportActionBar(toolBar)
        supportActionBar?.apply {
            title = ""
            elevation = 0f
        }
        val sectionPageAdapter = SectionPageAdapter(this, supportFragmentManager)
        view_pager.adapter = sectionPageAdapter
        tab_layout.setupWithViewPager(view_pager)
    }

    val carauselImg = intArrayOf(
        R.drawable.latar_a_star,
        R.drawable.latar_alita,
        R.drawable.latar_family_guy,
        R.drawable.latar_hanna,
        R.drawable.latar_flash,
        R.drawable.poster_alita,
        R.drawable.poster_flash
    )
    val imgListener = ImageListener { position, imageView ->
        imageView.setImageResource(carauselImg[position])
    }
}