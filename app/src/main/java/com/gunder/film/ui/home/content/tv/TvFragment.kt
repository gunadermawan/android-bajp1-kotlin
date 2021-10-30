package com.gunder.film.ui.home.content.tv

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.gunder.film.R
import com.gunder.film.model.DataEntity
import com.gunder.film.ui.detail.DetailActivity
import com.gunder.film.ui.home.content.ContentAdapter
import com.gunder.film.ui.home.content.ContentCallBack
import com.gunder.film.ui.home.content.ContentViewModel
import com.gunder.film.utils.Helpers.TYPE_TV
import kotlinx.android.synthetic.main.fragment_movie.*
import kotlinx.android.synthetic.main.fragment_tv.*

class TvFragment : Fragment(), ContentCallBack {
    private lateinit var viewModel: ContentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.let {
            viewModel = ViewModelProvider(it, ViewModelProvider.NewInstanceFactory())[ContentViewModel::class.java]
        }
        val listTv = viewModel.getListTv()
        setRecyceler(listTv)
    }

    private fun setRecyceler(data: List<DataEntity>) {
        rv_tv.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = ContentAdapter(this@TvFragment)
        }.also {
            it.adapter.let { adapter ->
                when(adapter){
                    is ContentAdapter -> {
                        adapter.setData(data)
                    }
                }
            }
        }

    }

    override fun onItemClicked(dataEntity: DataEntity) {
        startActivity(
            Intent(context, DetailActivity::class.java)
                .putExtra(DetailActivity.EXTRA_DATA, dataEntity.id)
                .putExtra(DetailActivity.EXTRA_TYPE, TYPE_TV)
        )
    }

}