package com.example.androidviewmodel


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide


class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        getIncomingIntent()

    }

    private fun getIncomingIntent(){
        if( intent.hasExtra("movie_title") && intent.hasExtra("poster_url") &&
                intent.hasExtra("movie_overview") && intent.hasExtra("movie_release_date") &&
                intent.hasExtra("movie_originalTitle") && intent.hasExtra("movie_originalLang") &&
                intent.hasExtra("backdrop_url") && intent.hasExtra("movie_id") &&
                intent.hasExtra("movie_popularity") && intent.hasExtra("movie_overview") &&
                intent.hasExtra("movie_voteCount") && intent.hasExtra("movie_voteAverage")){

            val title : String  = intent.getStringExtra("movie_title")
            val overview : String  = intent.getStringExtra("movie_overview")
            val posterImagePath : String  = intent.getStringExtra("poster_url")
            val release : String  = intent.getStringExtra("movie_release_date")

            val originalTitle : String  = intent.getStringExtra("movie_originalTitle")
            val originalLang : String  = intent.getStringExtra("movie_originalLang")
            val backdropImagePath : String  = intent.getStringExtra("backdrop_url")
            val popular : String  = intent.getStringExtra("movie_popularity")
            val id : String  = intent.getStringExtra("movie_id")
            //val id : Long  = intent.getLongExtra("movie_id",0L)
            val voteCount : String  = intent.getStringExtra("movie_voteCount")
            //val voteCount : Int  = intent.getIntExtra("movie_voteCount",0)
            val voteAverage : String  = intent.getStringExtra("movie_voteAverage")
            //val voteAverage : Float  = intent.getFloatExtra("movie_voteAverage",0.0f)



            //setMovieContent(posterImagePath, title, overview, release)
            setMovieContent(title, overview, release, originalTitle, originalLang,
                    backdropImagePath, popular,id, voteCount, voteAverage)

            /*val title : String  = intent.getStringExtra("movie_title")
            val overview : String  = intent.getStringExtra("movie_overview")
            val image_path : String  = intent.getStringExtra("poster_url")
            val release : String  = intent.getStringExtra("movie_release_date")*/
        }
    }

    private fun setMovieContent(title: String, overview: String, release: String,
                                originalTitle: String, originalLang: String,
                                backdropImageUrl: String, popularity: String,
                                id: String, voteCount: String, voteAverage: String) {
        //Log.d(TAG, "setImage: setting te image and name to widgets.")
        val movieImagePath: ImageView = findViewById(R.id.image_detail)
        Glide.with(this)
                .asBitmap()
                .load(backdropImageUrl)
                .into(movieImagePath)

        val movieTitle : TextView = findViewById(R.id.text_detail_title)
        movieTitle.text = title

        val movieOverview : TextView = findViewById(R.id.text_detail_overview)
        movieOverview.text = overview

        val movieRelease : TextView = findViewById(R.id.text_detail_release)
        movieRelease.text = release

        val moviePopularity : TextView = findViewById(R.id.text_popularity)
        moviePopularity.text = popularity

        val movieOriginalTitle : TextView = findViewById(R.id.text_original_title)
        movieOriginalTitle.text = originalTitle

        val movieOriginalLang : TextView = findViewById(R.id.text_original_language)
        movieOriginalLang.text = originalLang

        val movieId : TextView = findViewById(R.id.text_movie_id)
        movieId.text = id

        val movieVoteCount : TextView = findViewById(R.id.text_vote_count)
        movieVoteCount.text = voteCount

        val movieVoteAverage : TextView = findViewById(R.id.text_vote_average)
        movieVoteAverage.text = voteAverage


    }
}