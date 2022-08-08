package com.example.ejerciciotcnicorappi.movies.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.ejerciciotcnicorappi.App
import com.example.ejerciciotcnicorappi.R
import com.example.ejerciciotcnicorappi.databinding.LayoutHomeFragmentBinding
import com.example.ejerciciotcnicorappi.movies.view.StateData
import com.example.ejerciciotcnicorappi.movies.view.extensions.hide
import com.example.ejerciciotcnicorappi.movies.view.extensions.show
import com.example.ejerciciotcnicorappi.movies.view.models.MovieUI
import com.example.ejerciciotcnicorappi.movies.view.viewModel.HomeViewModel
import com.example.ejerciciotcnicorappi.movies.view.widgets.MoviessCarousel
import com.google.android.material.snackbar.Snackbar
import javax.inject.Inject

class HomeFragment: Fragment(R.layout.layout_home_fragment) {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject lateinit var homeViewModel: HomeViewModel

    lateinit var binding: LayoutHomeFragmentBinding

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
        binding = LayoutHomeFragmentBinding.inflate(inflater, container, false)
        homeViewModel.getUpcomingMovies()
        homeViewModel.getTopRatedMovies()
        return binding.root
    }

    fun injectDependency(){
        App.instance.component.inject(this)
    }

    private fun initObservers(){
        homeViewModel = ViewModelProvider(this, viewModelFactory)[HomeViewModel::class.java]
        homeViewModel.upcomingMoviesList.observe(this, Observer { handleUpcomingList(it)})
        homeViewModel.topRatedMoviesList.observe(this, { handleTopRatedList(it)})
        homeViewModel.recomendedMoviesList.observe(this, {handleRecomendedList(it)})
    }

    fun handleUpcomingList(stateData: StateData){
        when (stateData){
            is StateData.Success ->{
                val response = stateData.responseTo<MutableList<MovieUI>>()
                initUpcomingCarousel(response)
                binding.progressBar2.hide()
            }
            is StateData.Error ->{
                Snackbar.make(binding.root, R.string.generic_error, Snackbar.LENGTH_SHORT).show()
                binding.progressBar2.hide()
            }
            is StateData.Loading ->{
                binding.progressBar2.show()
            }
        }
    }

    fun handleTopRatedList(stateData: StateData){
        when (stateData){
            is StateData.Success ->{
                val response = stateData.responseTo<MutableList<MovieUI>>()
                initTopRatedCarousel(response)
                binding.progressBar2.hide()
            }
            is StateData.Error ->{
                binding.progressBar2.hide()
                Snackbar.make(binding.root, R.string.generic_error, Snackbar.LENGTH_SHORT).show()
            }
            is StateData.Loading ->{
                binding.progressBar2.show()
            }
        }
    }

    fun handleRecomendedList(stateData: StateData){
        when (stateData){
            is StateData.Success ->{
                val response = stateData.responseTo<MutableList<MovieUI>>()
                initRecomendedCarousel(response)
                binding.progressBar2.hide()
            }
            is StateData.Error ->{
                binding.progressBar2.hide()
                Snackbar.make(binding.root, R.string.generic_error, Snackbar.LENGTH_SHORT).show()
            }
            is StateData.Loading ->{
                binding.progressBar2.show()
            }
        }
    }

    fun initUpcomingCarousel(mutableList: MutableList<MovieUI>) = binding.run{
        upcomingCarousel.initRecyclerView()
        upcomingCarousel.setMoviesList(mutableList, {goToDetail(0)})
        upcomingCarousel.setTitle(getString(R.string.upcoming_title))
    }

    fun initTopRatedCarousel(mutableList: MutableList<MovieUI>) = binding.run{
        topRatedCarousel.initRecyclerView()
        topRatedCarousel.setMoviesList(mutableList, {goToDetail(0)})
        topRatedCarousel.setTitle(getString(R.string.top_rated_title))
    }

    fun initRecomendedCarousel(mutableList: MutableList<MovieUI>) = binding.run {
        recomendedCarousel.viewType = MoviessCarousel.TYPE_LAYOUT_GRID
        recomendedCarousel.initRecyclerView()
        recomendedCarousel.setMoviesList(mutableList, {goToDetail(0)})
        recomendedCarousel.setTitle(getString(R.string.recommended_title))
    }

    fun goToDetail(idMovie: Int){
        //val action = HomeFragmentDirections.actionHomeFragmentToMovieDetailFragment()
        //view?.findNavController()?.navigate(action)
    }

    companion object{
        fun newInstance() = HomeFragment()
    }
}