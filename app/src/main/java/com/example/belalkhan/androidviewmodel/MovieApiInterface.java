package com.example.belalkhan.androidviewmodel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieApiInterface {

    String Movie_BASE_URL = "https://api.themoviedb.org";
    String BASE_URL_IMG_BACKGROUND = "https://image.tmdb.org/t/p/w185";
    String API_KEY = "3e8b96217b510aca7ddd3f42f88ef8a2";
    String LANGUAGE = "en-US";
    String CATEGORY = "popular";
    int PAGE = 1;

    @GET("/3/movie/{category}")
    Call<MovieResults> getMovies (
            @Path("category") String category,
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") int page
    );
}
