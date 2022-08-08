package com.example.ejerciciotcnicorappi.movies.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.ejerciciotcnicorappi.App
import com.example.ejerciciotcnicorappi.R
import com.example.ejerciciotcnicorappi.databinding.LayoutMovieDetailFragmentBinding
import com.example.ejerciciotcnicorappi.movies.view.StateData
import com.example.ejerciciotcnicorappi.movies.view.extensions.formatStringList
import com.example.ejerciciotcnicorappi.movies.view.extensions.hide
import com.example.ejerciciotcnicorappi.movies.view.extensions.show
import com.example.ejerciciotcnicorappi.movies.view.extensions.splitDate
import com.example.ejerciciotcnicorappi.movies.view.models.MovieDetailUI
import com.example.ejerciciotcnicorappi.movies.view.viewModel.MovieDetailViewModel
import com.google.android.material.snackbar.Snackbar
import javax.inject.Inject

class MovieDetailFragment: Fragment(R.layout.layout_movie_detail_fragment) {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject lateinit var movieDetailViewModel: MovieDetailViewModel

    lateinit var binding: LayoutMovieDetailFragmentBinding
    var idMovie = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependency()
        initObservers()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = LayoutMovieDetailFragmentBinding.inflate(inflater, container, false)
        movieDetailViewModel.getMovieDetail(idMovie)
        return binding.root
    }

    fun injectDependency(){
        App.instance.component.inject(this)
    }

    private fun initObservers(){
        movieDetailViewModel =
            ViewModelProvider(this, viewModelFactory)[MovieDetailViewModel::class.java]
        movieDetailViewModel.movieDetail.observe(this, {handleGetDetail(it)})

    }

    private fun handleGetDetail(stateData: StateData){
        when (stateData){
            is StateData.Success -> {
                val response = stateData.responseTo<MovieDetailUI>()
                setMovieDetailData(response)
                binding.progressBar.hide()
            }
            is StateData.Error -> {
                binding.progressBar.hide()
                Snackbar.make(binding.root, R.string.generic_error, Snackbar.LENGTH_SHORT).show()
            }
            is StateData.Loading -> {
                binding.progressBar.show()
            }
        }
    }

    private fun setMovieDetailData(movieDetailUI: MovieDetailUI){
        binding.titleTextview.text = movieDetailUI.title
        binding.yearTextview.text = movieDetailUI.dateRelease?.splitDate()
        binding.ratingTextView.text = movieDetailUI.popularity.toString()
        binding.genereTextview.text = movieDetailUI.generes?.formatStringList()
        binding.moviePlot.text = movieDetailUI.overview
    }

    companion object {
        fun newInstance() = MovieDetailFragment()
    }
}