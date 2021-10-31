package com.gunder.film.ui.home.content

import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class ContentViewModelTest {
    private lateinit var viewModel: ContentViewModel

    @Before
    fun setUpTest() {
        viewModel = ContentViewModel()
    }

    @Test
    fun getListMovie() {
        val movie = viewModel.getListMovie()
        assertNotNull(movie)
        assertEquals(10, movie.size)
    }

    @Test
    fun getListTv() {
        val tv = viewModel.getListTv()
        assertNotNull(tv)
        assertEquals(10, tv.size)
    }
}