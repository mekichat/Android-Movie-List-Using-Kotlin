package com.example.androidviewmodel.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.androidviewmodel.MovieApiInterface
import com.example.androidviewmodel.R
import com.example.androidviewmodel.Movies
import com.example.androidviewmodel.extensions.inflate
import kotlinx.android.synthetic.main.recyclerview_layout.view.*


class MovieViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent.inflate(R.layout.recyclerview_layout)) {

    fun bind(movies: Movies) {
        itemView.image_view?.let {
            Glide.with(itemView.context)
                    .load(MovieApiInterface.BASE_URL_IMG_BACKGROUND + movies.posterPath)
                    .into(it)
        }
        itemView.text_view_title?.text = "Movie Title : " + movies.title
        itemView.text_view_overview?.text = movies.overview
        itemView.text_view_release?.text = "Relase Date : " + movies.releaseDate
    }
}
