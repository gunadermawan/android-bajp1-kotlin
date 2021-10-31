package com.gunder.film.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.gunder.film.R
import com.gunder.film.model.DataEntity
import com.gunder.film.utils.Helpers.TYPE_MOVIE
import com.gunder.film.utils.Helpers.TYPE_TV
import com.gunder.film.utils.Helpers.setGlideImage
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.list_item.*

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_DATA = "extra_data"
        const val EXTRA_TYPE = "extra_type"
    }

    private lateinit var result: DataEntity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val viewModel = ViewModelProvider(
            this@DetailActivity,
            ViewModelProvider.NewInstanceFactory()
        )[DetailViewModel::class.java]

        supportActionBar?.title = "Detail Film"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val id = intent.getStringExtra(EXTRA_DATA)
        val type = intent.getStringExtra(EXTRA_TYPE)

        if (type.equals(TYPE_MOVIE, ignoreCase = true)) {
            id?.let {
                viewModel.setMovieId(it)
            }
            result = viewModel.getDetailMovieById()
        } else if (type.equals(TYPE_TV, ignoreCase = true)) {
            id?.let {
                viewModel.setTvId(it)
            }
            result = viewModel.getTvDetailById()
        }
        tv_title_detail.text = result.title
        tv_description_detail.text = result.description
        tv_release_date_detail.text = result.releaseYear
        tv_genre_detail.text = result.genre
        setGlideImage(this@DetailActivity, result.imgPoster, iv_item_photo_detail)
        setGlideImage(this@DetailActivity, result.imgBakground, iv_cover_detail)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}