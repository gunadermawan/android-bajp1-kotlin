package com.gunder.film.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataEntity(
    var id: String,
    var title: String,
    var description: String,
    var genre: String,
    var releaseYear: String,
    var imgPoster: Int,
    var imgBakground: Int
) : Parcelable