package com.appwork.movieapp.network

import com.appwork.movieapp.database.responses.MovieResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Vivek Kumar belongs to APP WORK  on 24-12-2020.
 */
interface ApiRequestClient {

    @GET("movies/get-now-playing")
    fun movieListCall(
        @Query("apikey") apiKey: String
    ): Call<MovieResponse>


    companion object {
        private const val BASE_URL = "https://developers.themoviedb.org/3/"
        operator fun invoke(): ApiRequestClient {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiRequestClient::class.java)
        }
    }
}