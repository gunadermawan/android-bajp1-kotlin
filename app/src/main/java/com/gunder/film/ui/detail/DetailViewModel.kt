package com.gunder.film.ui.detail

import androidx.lifecycle.ViewModel
import com.gunder.film.model.DataEntity
import com.gunder.film.utils.DataDummy

class DetailViewModel : ViewModel() {
    private lateinit var movieId: String
    private lateinit var tvId: String

    private fun getListMovie(): ArrayList<DataEntity> =
        DataDummy.getDummyMovie() as ArrayList<DataEntity>

    private fun getListTv(): ArrayList<DataEntity> = DataDummy.getdummyTv() as ArrayList<DataEntity>

    fun setMovieId(movieId: String) {
        this.movieId = movieId
    }

    fun setTvId(tvId: String) {
        this.tvId = tvId
    }

    fun getDetailMovieById(): DataEntity {
        lateinit var result: DataEntity
        val listMovie = getListMovie()
        for (movie in listMovie) {
            if (movie.id == movieId) {
                result = movie
                break
            }
        }
        return result
    }

    fun getTvDetailById(): DataEntity {
        lateinit var result: DataEntity
        val listTv = getListTv()
        for (tv in listTv) {
            if (tv.id == tvId) {
                result = tv
                break
            }
        }
        return result
    }
}