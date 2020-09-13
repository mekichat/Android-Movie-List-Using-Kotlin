package com.example.androidviewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.androidviewmodel.MovieApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieViewModel : ViewModel() {
    //this is the data that we will fetch asynchronously
    private var movieResults: MutableLiveData<MovieResults?>? = null//we will load it asynchronously from server in this method

    //finally we will return the movie result
//if the list is null

    //we will call this method to get the data
    val movies: LiveData<MovieResults?>
        get() {
            //if the list is null
            if (movieResults == null) {
                movieResults = MutableLiveData()
                //we will load it asynchronously from server in this method
                loadMovies()
            }

            //finally we will return the movie result
            return movieResults!!
        }

    //This method is using Retrofit to get the JSON data from URL
    private fun loadMovies() {
        val retrofit = Retrofit.Builder()
                .baseUrl(MovieApiInterface.Movie_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val movieApi = retrofit.create(MovieApiInterface::class.java)
        val call = movieApi.getMovies(MovieApiInterface.CATEGORY, MovieApiInterface.API_KEY, MovieApiInterface.LANGUAGE, MovieApiInterface.PAGE)
        call?.enqueue(object : Callback<MovieResults?> {
            override fun onResponse(call: Call<MovieResults?>, response: Response<MovieResults?>) {

                //finally we are setting the list to our MutableLiveData
                movieResults?.value = response.body()
            }

            override fun onFailure(call: Call<MovieResults?>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
}