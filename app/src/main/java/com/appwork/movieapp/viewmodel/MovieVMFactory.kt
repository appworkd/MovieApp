package com.appwork.movieapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.appwork.movieapp.database.repository.MoviesRepo

/**
 * Created by Vivek Kumar belongs to APP WORK  on 25-12-2020.
 */
class MovieVMFactory(private val repo:MoviesRepo) : ViewModelProvider.NewInstanceFactory(){
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MovieVM(repo) as T
    }
}