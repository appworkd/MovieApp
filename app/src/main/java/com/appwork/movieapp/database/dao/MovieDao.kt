package com.appwork.movieapp.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.appwork.movieapp.model.Movie

/**
 * Created by Vivek Kumar belongs to APP WORK  on 24-12-2020.
 */
@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie: Movie)

    @Query("SELECT * FROM MOVIE_TABLE")
    fun getAllMovies(): LiveData<List<Movie>>
}