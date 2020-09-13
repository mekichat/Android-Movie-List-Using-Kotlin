package com.example.androidviewmodel

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import com.example.androidviewmodel.adapter.MovieAdapter
import com.example.androidviewmodel.R

class MainActivity : AppCompatActivity() {
    var recyclerView: RecyclerView? = null
    var adapter: MovieAdapter? = null
    var movieResults: MovieResults? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, MovieListFragment()).commit()

    }
}