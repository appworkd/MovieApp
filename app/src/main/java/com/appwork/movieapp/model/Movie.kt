package com.appwork.movieapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Vivek Kumar belongs to APP WORK  on 24-12-2020.
 */
@Entity(tableName = "movie_table")
data class Movie(

    @SerializedName("poster_path")
    @Expose
    val posterPath: String = "",
    @SerializedName("adult")
    @Expose
    val adult: String = "",
    @SerializedName("overview")
    @Expose
    val overView: String = "",
    @SerializedName("release_date")
    @Expose
    val releaseDate: String = "",
    /*  @SerializedName("genre_ids")
      val genreIds: List<Int>,*/
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("original_title")
    @Expose
    val originalTitle: String,
    @SerializedName("original_language")
    @Expose
    val originalLanguage: String,
    @SerializedName("title")
    @Expose
    val title: String,
    @SerializedName("backdrop_path")
    @Expose
    val backdropPath: String,
    @SerializedName("popularity")
    @Expose
    val popularity: Double,
    @SerializedName("vote_count")
    @Expose
    val voteCount: Int,
    @SerializedName("video")
    @Expose
    val video: Boolean,
    @SerializedName("vote_average")
    @Expose
    val voteAverage: Double
) {
    @PrimaryKey(autoGenerate = true)
    var movieId: Int = 0

    fun doubleToString() {
        popularity.toString()
    }
}