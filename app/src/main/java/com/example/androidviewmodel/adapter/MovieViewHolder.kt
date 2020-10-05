package com.example.androidviewmodel.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.androidviewmodel.DetailActivity
import com.example.androidviewmodel.MovieApiInterface
import com.example.androidviewmodel.Movies
import com.example.androidviewmodel.R
import com.example.androidviewmodel.extensions.inflate
import kotlinx.android.synthetic.main.recyclerview_layout.view.*


class MovieViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent.inflate(R.layout.recyclerview_layout)) {

    private val TAG = "MovieViewHolder"

    fun bind(movies: Movies) {
        itemView.image_view?.let {
            Glide.with(itemView.context)
                    .load(MovieApiInterface.BASE_URL_IMG_BACKGROUND + movies.posterPath)
                    .into(it)
        }
        itemView.text_view_title?.text = "Movie Title : " + movies.title
        itemView.text_view_overview?.text = movies.overview
        itemView.text_view_release?.text = "Release Date : " + movies.releaseDate
    }

    fun bindClick(context: Context?, movies: Movies){
        itemView.image_view.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra("movie_title",movies.title)
                intent.putExtra("poster_url",
                        MovieApiInterface.BASE_URL_IMG_BACKGROUND + movies.posterPath)
                intent.putExtra("movie_overview",movies.overview)
                intent.putExtra("movie_release_date","Release Date : " + movies.releaseDate)
                if (context != null)
                    context.startActivity(intent)
                else
                    Log.d(TAG, "Context is null in ${TAG} class")
            }
        })

    }
    fun bindAdapterClick(context: Context?, movies: Movies){
        itemView.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra("movie_title",movies.title)
                intent.putExtra("movie_originalTitle","Original_title : " + movies.originalTitle)
                intent.putExtra("movie_originalLang","Original_language : " + movies.originalLanguage)
                intent.putExtra("poster_url",
                        MovieApiInterface.BASE_URL_IMG_BACKGROUND + movies.posterPath)
                intent.putExtra("backdrop_url",
                        MovieApiInterface.BASE_URL_IMG_BACKGROUND + movies.backdropPath)
                intent.putExtra("movie_id","Movie_id : " + movies.movieID)
                intent.putExtra("movie_popularity","Popularity : " + movies.popularity)
                intent.putExtra("movie_overview",movies.overview)
                intent.putExtra("movie_voteCount","Vote_count : " + movies.voteCount)
                intent.putExtra("movie_voteAverage","Vote_average : " + movies.voteAverage)
                intent.putExtra("movie_release_date","Release_date : " + movies.releaseDate)
                if (context != null)
                    context.startActivity(intent)
                else
                    Log.d(TAG, "Context is null in ${TAG} class")
            }
        })
    }
}
