package com.example.androidviewmodel.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.androidviewmodel.MovieResults

class MovieAdapter(val movieResults: MovieResults) : RecyclerView.Adapter<MovieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MovieViewHolder(parent)

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) =
        holder.bind(movieResults.results[position])

    override fun getItemCount() = movieResults.results.size
}

