package com.example.listingmovie.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

//mapping data dari API nya duls

@Parcelize
data class Movie(
    @SerializedName("id")
    val id : String ?,

    @SerializedName("title")
    val title : String ?,

    @SerializedName("poster_path")
    val poster : String ?,

    @SerializedName("release_date")
    val release : String ?,

): Parcelable{
    constructor(): this("", "", "", "")
}


