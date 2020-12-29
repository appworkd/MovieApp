package com.appwork.movieapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.appwork.movieapp.R
import com.appwork.movieapp.databinding.ActivityMovieBinding
import com.appwork.movieapp.model.Movie
import com.appwork.movieapp.network.ApiRequestClient
import com.appwork.movieapp.utils.DataInterface
import com.appwork.movieapp.viewmodel.MovieVM
import com.appwork.movieapp.viewmodel.MovieVMFactory
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class MovieActivity : AppCompatActivity(), KodeinAware, DataInterface {
    override val kodein by kodein()
    private val vmFactory: MovieVMFactory by instance()
    private val requestApi: ApiRequestClient by instance()
    private var mBinding: ActivityMovieBinding? = null
    private var mAdapter: MovieAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_movie)
        val vm = ViewModelProvider(this, vmFactory).get(MovieVM::class.java)
        mBinding?.let {
            it.lifecycleOwner = this
            it.movieVM = vm
        }
        vm.listener = this


        mAdapter = MovieAdapter()
        setUpRecyclerView()
        vm.getDataList().observe(this, {
            if (it.isEmpty()){
                vm.insertDummyData()
            }else{
                vm.getDataList()
                mAdapter?.setData(it)
            }
        })

    }
    fun abc(){
        /*if (movieList.isEmpty()) {
            showProcess.set(View.VISIBLE)
            showList.set(View.GONE)
        } else {
            showList.set(View.VISIBLE)
            showProcess.set(View.GONE)
        }*/
    }

    private fun setUpRecyclerView() {
        mBinding?.movieList?.also {
            it.layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
            it.adapter = mAdapter
        }
    }

    override fun getDataList(list: List<Movie>) {
        mAdapter?.setData(list)
    }

}