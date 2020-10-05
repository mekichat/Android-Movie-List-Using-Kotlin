package com.example.androidviewmodel

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidviewmodel.adapter.MovieAdapter

class MovieListFragment : Fragment() {
    lateinit var recyclerView: RecyclerView
    var adapter: MovieAdapter? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerview)
        recyclerView.setHasFixedSize(true)
        recyclerView.setLayoutManager(LinearLayoutManager(this.context))
        val model = ViewModelProviders.of(this).get(MovieViewModel::class.java)
        val observer = Observer<MovieResults?> {
            if (it != null){
                adapter = MovieAdapter(this.context,it)
                recyclerView.setAdapter(adapter)
            }

        }
        model.movies.observe(this,observer)

        /*model.movies.observe(this, Observer { movieResults: MovieResults? ->
               if (movieResults != null){
                    adapter = MovieAdapter(movieResults)
                    recyclerView.setAdapter(adapter)
               }
        })*/
    }
}