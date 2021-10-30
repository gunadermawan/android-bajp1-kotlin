package com.gunder.film.ui.home.content

import androidx.lifecycle.ViewModel
import com.gunder.film.model.DataEntity
import com.gunder.film.utils.DataDummy

class ContentViewModel : ViewModel() {
    fun getListMovie(): List<DataEntity> = DataDummy.getDummyMovie()
    fun getListTv(): List<DataEntity> = DataDummy.getdummyTv()
}