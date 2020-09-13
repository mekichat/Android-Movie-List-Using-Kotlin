package com.example.androidviewmodel

import com.google.gson.annotations.SerializedName

data class MovieResults(
    val page: Int,
    val results: List<Movies>)

data class Movies(
        @SerializedName("poster_path") val posterPath: String,
        @SerializedName("backdrop_path") val backdropPath: String,
        @SerializedName("original_language") val originalLanguage: String,
        @SerializedName("original_title") val originalTitle: String,
        val title: String,
        val overview: String,
        @SerializedName("release_date") val releaseDate: String)