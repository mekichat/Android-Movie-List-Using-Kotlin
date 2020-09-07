package com.example.belalkhan.androidviewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieViewModel extends ViewModel {

    //this is the data that we will fetch asynchronously
    private MutableLiveData<MovieResults> movieResults;

    //we will call this method to get the data
    public LiveData<MovieResults> getMovies() {
        //if the list is null
        if (movieResults == null) {
            movieResults = new MutableLiveData<MovieResults>();
            //we will load it asynchronously from server in this method
            loadMovies();
        }

        //finally we will return the movie result
        return movieResults;
    }

    //This method is using Retrofit to get the JSON data from URL
    private void loadMovies() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MovieApiInterface.Movie_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MovieApiInterface movieApi = retrofit.create(MovieApiInterface.class);
        Call<MovieResults> call = movieApi.getMovies(movieApi.CATEGORY, movieApi.API_KEY, movieApi.LANGUAGE, movieApi.PAGE);


        call.enqueue(new Callback<MovieResults>() {
            @Override
            public void onResponse(Call<MovieResults> call, Response<MovieResults> response) {

                //finally we are setting the list to our MutableLiveData
                movieResults.setValue(response.body());
            }

            @Override
            public void onFailure(Call<MovieResults> call, Throwable t) {
                t.printStackTrace();

            }
        });
    }
}
