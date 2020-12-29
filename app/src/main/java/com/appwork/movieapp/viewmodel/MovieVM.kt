package com.appwork.movieapp.viewmodel

import android.view.View
import androidx.databinding.ObservableInt
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appwork.movieapp.database.repository.MoviesRepo
import com.appwork.movieapp.model.Movie
import com.appwork.movieapp.utils.DataInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

import kotlinx.coroutines.CoroutineScope

/**
 * Created by Vivek Kumar belongs to APP WORK  on 25-12-2020.
 */
class MovieVM(private val movieRepo: MoviesRepo) : ViewModel() {
    var listener: DataInterface? = null
    val showProcess = ObservableInt(View.GONE)
    val showList = ObservableInt(View.VISIBLE)

    fun getDataList() =
        movieRepo.getDummyMovies()


    fun insertDummyData() {
        CoroutineScope(Dispatchers.IO).launch {
            movieRepo.insertDummyMovies()
            movieRepo.getDummyMovies()
        }
    }
}