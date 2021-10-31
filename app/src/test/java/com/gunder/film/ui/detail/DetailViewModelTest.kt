package com.gunder.film.ui.detail

import com.gunder.film.utils.DataDummy
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class DetailViewModelTest {
    private lateinit var detailViewModel: DetailViewModel
    private val dummyMovie = DataDummy.getDummyMovie()[0]
    private val dummtTv = DataDummy.getdummyTv()[0]
    private val movieId = dummyMovie.id
    private val tvId = dummtTv.id

    @Before
    fun setUpTest() {
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
        assertEquals(dummtTv.title, tv.title)
        assertEquals(dummtTv.description, tv.description)
        assertEquals(dummtTv.genre, tv.genre)
        assertEquals(dummtTv.releaseYear, tv.releaseYear)
        assertEquals(dummtTv.imgPoster, tv.imgPoster)
        assertEquals(dummtTv.imgBakground, tv.imgBakground)
    }
}