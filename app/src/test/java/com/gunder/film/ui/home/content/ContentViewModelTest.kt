package com.gunder.film.ui.home.content

import com.gunder.film.ui.detail.DetailViewModel
import com.gunder.film.utils.DataDummy
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class ContentViewModelTest {
    private lateinit var detailViewModel: DetailViewModel
    private val dummyMovie = DataDummy.getDummyMovie()[0]
    private val dummyTv = DataDummy.getdummyTv()[0]
    private val movieId = dummyMovie.id
    private val tvId = dummyTv.id

    @Before
    fun setUp() {
        detailViewModel = DetailViewModel()
        detailViewModel.setMovieId(movieId)
        detailViewModel.setTvId(tvId)
    }

    @Test
    fun getDetailMovie() {
        val movie = detailViewModel.getDetailMovieById()
        assertNotNull(movie)
        assertEquals(dummyMovie.title, movie.title)
        assertEquals(dummyMovie.description, movie.description)
        assertEquals(dummyMovie.genre, movie.genre)
        assertEquals(dummyMovie.releaseYear, movie.releaseYear)
        assertEquals(dummyMovie.imgPoster, movie.imgPoster)
        assertEquals(dummyMovie.imgBakground, movie.imgBakground)
    }
    @Test
    fun getDetailTv() {
        val tv = detailViewModel.getTvDetailById()
        assertNotNull(tv)
        assertEquals(dummyTv.title, tv.title)
        assertEquals(dummyTv.description, tv.description)
        assertEquals(dummyTv.genre, tv.genre)
        assertEquals(dummyTv.releaseYear, tv.releaseYear)
        assertEquals(dummyTv.imgPoster, tv.imgPoster)
        assertEquals(dummyTv.imgBakground, tv.imgBakground)
    }
}