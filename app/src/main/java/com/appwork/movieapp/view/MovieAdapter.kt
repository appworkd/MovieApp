package com.appwork.movieapp.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.appwork.movieapp.R
import com.appwork.movieapp.databinding.ItemViewMovieBinding
import com.appwork.movieapp.model.Movie

/**
 * Created by Vivek Kumar belongs to APP WORK  on 25-12-2020.
 */
class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieVH>() {
    private var movieList: List<Movie>? = null

    inner class MovieVH(private val itemViewMovieBinding: ItemViewMovieBinding) :
        RecyclerView.ViewHolder(itemViewMovieBinding.root) {
        fun setData(model: Movie) {
            itemViewMovieBinding.itemMoveVM = model
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieVH {
        val view = DataBindingUtil.inflate<ItemViewMovieBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_view_movie,
            parent,
            false
        )
        return MovieVH((view))
    }

    override fun onBindViewHolder(holder: MovieVH, position: Int) {
        movieList?.let {
            holder.setData(it[position])
        }
    }

    override fun getItemCount(): Int {
        return if (movieList == null) 0 else movieList!!.size
    }

    fun setData(list: List<Movie>) {
        this.movieList = list
        notifyDataSetChanged()
    }
}