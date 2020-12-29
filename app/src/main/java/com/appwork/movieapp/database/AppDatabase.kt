package com.appwork.movieapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.appwork.movieapp.database.dao.MovieDao
import com.appwork.movieapp.model.Movie

/**
 * Created by Vivek Kumar belongs to APP WORK  on 24-12-2020.
 */
@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getMovieDao(): MovieDao

    companion object {
        const val DB_NAME = "movies_db"

        @Volatile
        private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDb(context).also {
                instance = it
            }
        }

        private fun createDb(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                DB_NAME
            )
                .build()


    }
}