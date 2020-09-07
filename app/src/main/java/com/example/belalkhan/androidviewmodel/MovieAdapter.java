package com.example.belalkhan.androidviewmodel;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    Context mCtx;
    MovieResults movieResults;

    public MovieAdapter(Context mCtx, MovieResults movieResults) {
        this.mCtx = mCtx;
        this.movieResults = movieResults;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_layout, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        //Hero hero = heroList.get(position);

        List<MovieResults.ResultsBean> listOfMovies = movieResults.getResults();
        MovieResults.ResultsBean movies = listOfMovies.get(position);

        Glide.with(mCtx)
                .load(MovieApiInterface.BASE_URL_IMG_BACKGROUND + movies.getPoster_path())
                .into(holder.imageView);

        holder.movieTitle.setText("Movie Title : " + movies.getTitle());
        holder.movieOverview.setText(movies.getOverview());
        holder.movieRelaseDate.setText("Relase Date : " + movies.getRelease_date());

    }

    @Override
    public int getItemCount() {

        return movieResults.getResults().size();

    }

    class MovieViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView movieTitle;
        TextView movieOverview;
        TextView movieRelaseDate;

        public MovieViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            movieTitle = itemView.findViewById(R.id.textViewTitle);
            movieOverview = itemView.findViewById(R.id.textViewOverview);
            movieRelaseDate = itemView.findViewById(R.id.textViewRelease);
        }
    }
}
