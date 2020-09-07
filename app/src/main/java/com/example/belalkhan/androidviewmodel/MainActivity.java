package com.example.belalkhan.androidviewmodel;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MovieAdapter adapter;

    MovieResults movieResults;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MovieViewModel model = ViewModelProviders.of(this).get(MovieViewModel.class);

        model.getMovies().observe(this,  (movieResults) -> {
            adapter = new MovieAdapter(MainActivity.this, movieResults);
            recyclerView.setAdapter(adapter);

        });
    }
}
