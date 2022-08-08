package com.example.ejerciciotcnicorappi.movies.view.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.ejerciciotcnicorappi.App
import com.example.ejerciciotcnicorappi.R
import com.example.ejerciciotcnicorappi.databinding.LayoutMovieDetailFragmentBinding
import com.example.ejerciciotcnicorappi.movies.view.StateData
import com.example.ejerciciotcnicorappi.movies.view.URL_IMAGES
import com.example.ejerciciotcnicorappi.movies.view.extensions.*
import com.example.ejerciciotcnicorappi.movies.view.models.MovieDetailUI
import com.example.ejerciciotcnicorappi.movies.view.models.MovieVideosUI
import com.example.ejerciciotcnicorappi.movies.view.viewModel.MovieDetailViewModel
import com.google.android.material.snackbar.Snackbar
import javax.inject.Inject

class MovieDetailFragment: Fragment(R.layout.layout_movie_detail_fragment) {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject lateinit var movieDetailViewModel: MovieDetailViewModel

    lateinit var binding: LayoutMovieDetailFragmentBinding
    var idMovie = 0
    val args: MovieDetailFragmentArgs by navArgs()

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
        idMovie = args.idMovie
        movieDetailViewModel.getMovieDetail(idMovie)
        binding.trailerButton.setOnClickListener { movieDetailViewModel.getMovieVideos(idMovie) }
        return binding.root
    }

    fun injectDependency(){
        App.instance.component.inject(this)
    }

    private fun initObservers(){
        movieDetailViewModel =
            ViewModelProvider(this, viewModelFactory)[MovieDetailViewModel::class.java]
        movieDetailViewModel.movieDetail.observe(this, {handleGetDetail(it)})
        movieDetailViewModel.movieVideos.observe(this, {handleMovieVideos(it)})

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

    private fun handleMovieVideos(stateData: StateData){
        when(stateData){
            is StateData.Success ->{
                val response = stateData.responseTo<MovieVideosUI>()
                binding.progressBar.hide()
                playVideo(response)
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
        binding.imageView.setImageByUrl("$URL_IMAGES${movieDetailUI.posterPath}")
    }

    private fun playVideo(movieVideosUI: MovieVideosUI){
        if (movieVideosUI.idVideo.isNullOrBlank().not()) {
            var intent = Intent()
            if (movieVideosUI.site == "YouTube"){
                intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.youtube.com/watch?v=${movieVideosUI.idVideo}")
                )
            }else{
                intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://vimeo.com/${movieVideosUI.idVideo}")
                )
            }
            startActivity(intent)
        }else {
            Snackbar.make(binding.root, R.string.without_trailer, Snackbar.LENGTH_SHORT).show()
        }
    }

    companion object {
        fun newInstance() = MovieDetailFragment()
    }
}