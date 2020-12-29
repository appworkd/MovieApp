package com.appwork.movieapp.database.repository

import com.appwork.movieapp.database.AppDatabase
import com.appwork.movieapp.model.Movie

/**
 * Created by Vivek Kumar belongs to APP WORK  on 25-12-2020.
 */
class MoviesRepo(private val db: AppDatabase) {

     fun getDummyMovies() = db.getMovieDao().getAllMovies()


    suspend fun insertDummyMovies() {
        for (i in 1..10) {
            val movie = Movie(
                "https://i.imgur.com/xkUElXq.jpg",
                "18+",
                "Average",
                "Today",
                i,
                "",
                "English",
                "Movie",
                "",
                58.0,
                800,
                true,
                49.0
            )
            db.getMovieDao().insertMovie(movie)
        }
    }
}