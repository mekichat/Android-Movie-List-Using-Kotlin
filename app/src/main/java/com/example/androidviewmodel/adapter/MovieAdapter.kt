package com.example.androidviewmodel.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.androidviewmodel.MovieResults

class MovieAdapter(context: Context?, movieResults: MovieResults) : RecyclerView.Adapter<MovieViewHolder>() {

    private val context: Context?
    private val movieResults: MovieResults

    init {
        this.context = context
        this.movieResults = movieResults
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MovieViewHolder(parent)

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movieResults.results[position])
        //holder.bindClick(context, movieResults.results[position])
        holder.bindAdapterClick(context, movieResults.results[position])
    }

    override fun getItemCount() = movieResults.results.size
}

