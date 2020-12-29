package com.appwork.movieapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Vivek Kumar belongs to APP WORK  on 24-12-2020.
 */
class Dates(
    @SerializedName("minimum")
    @Expose
    val minimun: String,
    @SerializedName("maximum")
    @Expose
    val maximum: String,
)