package com.example.belalkhan.androidviewmodel;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MovieListFragment extends Fragment {

    RecyclerView recyclerView;
    MovieAdapter adapter;

    MovieResults movieResults;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie_list, container, false);
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        MovieViewModel model = ViewModelProviders.of(this).get(MovieViewModel.class);

        model.getMovies().observe(this,  (movieResults) -> {
            adapter = new MovieAdapter(MovieListFragment.this.getContext(), movieResults);
            recyclerView.setAdapter(adapter);

        });




    }
}
