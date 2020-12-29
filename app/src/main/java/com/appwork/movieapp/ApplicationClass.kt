package com.appwork.movieapp

import android.app.Application
import com.appwork.movieapp.database.AppDatabase
import com.appwork.movieapp.database.repository.MoviesRepo
import com.appwork.movieapp.network.ApiRequestClient
import com.appwork.movieapp.viewmodel.MovieVMFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

/**
 * Created by Vivek Kumar belongs to APP WORK  on 24-12-2020.
 */

class ApplicationClass : Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidXModule(this@ApplicationClass))
        bind() from singleton { AppDatabase(instance()) }
        bind() from singleton { ApiRequestClient() }
        bind() from singleton { MoviesRepo(instance()) }
        bind() from provider { MovieVMFactory(instance()) }
    }
}