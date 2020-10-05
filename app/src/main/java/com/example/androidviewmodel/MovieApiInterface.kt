package com.example.androidviewmodel

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApiInterface {
    @GET("/3/movie/{category}")
    fun getMovies(
            @Path("category") category: String?,
            @Query("api_key") apiKey: String?,
            @Query("language") language: String?,
            @Query("page") page: Int
    ): Call<MovieResults?>?

    companion object {
        const val Movie_BASE_URL = "https://api.themoviedb.org"
        const val BASE_URL_IMG_BACKGROUND = "https://image.tmdb.org/t/p/w185"
        const val API_KEY = "3e8b96217b510aca7ddd3f42f88ef8a2"
        const val LANGUAGE = "en-US"
        const val CATEGORY = "popular"
        const val PAGE = 1
    }
}