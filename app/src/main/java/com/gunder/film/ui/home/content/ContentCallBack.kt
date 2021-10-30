package com.gunder.film.ui.home.content

import com.gunder.film.model.DataEntity

interface ContentCallBack {
    fun onItemClicked(dataEntity: DataEntity)
}