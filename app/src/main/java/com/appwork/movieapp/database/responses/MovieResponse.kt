package com.appwork.movieapp.database.responses

import com.appwork.movieapp.model.Movie
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * Created by Vivek Kumar belongs to APP WORK  on 24-12-2020.
 */
class MovieResponse(
    @SerializedName("page")
    @Expose
    val page: Int,
    @SerializedName("results")
    @Expose
    val movies: List<Movie>,
    @SerializedName("dates")
    @Expose
    val dates: Date,
    @SerializedName("total_pages")
    @Expose
    val totalPage: Int,
    @SerializedName("total_results")
    @Expose
    val totalResult: Int,
)