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
import com.example.ejerciciotcnicorappi.movies.view.models.MovieUI
import com.example.ejerciciotcnicorappi.movies.view.viewModel.HomeViewModel
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
    }

    fun handleUpcomingList(stateData: StateData){
        when (stateData){
            is StateData.Success ->{
                val response = stateData.responseTo<MutableList<MovieUI>>()
                initUpcomingCarousel(response)
            }
            is StateData.Error ->{
                Snackbar.make(binding.root, R.string.generic_error, Snackbar.LENGTH_SHORT).show()
            }
            is StateData.Loading ->{

            }
        }
    }

    fun handleTopRatedList(stateData: StateData){
        when (stateData){
            is StateData.Success ->{
                val response = stateData.responseTo<MutableList<MovieUI>>()
                initTopRatedCarousel(response)
            }
            is StateData.Error ->{
                Snackbar.make(binding.root, R.string.generic_error, Snackbar.LENGTH_SHORT).show()
            }
            is StateData.Loading ->{

            }
        }
    }

    fun initUpcomingCarousel(mutableList: MutableList<MovieUI>){
        binding.upcomingCarousel.setMoviesList(mutableList, {})
        binding.upcomingCarousel.setTitle(getString(R.string.upcoming_title))
    }

    fun initTopRatedCarousel(mutableList: MutableList<MovieUI>){
        binding.topRatedCarousel.setMoviesList(mutableList, {})
        binding.topRatedCarousel.setTitle(getString(R.string.top_rated_title))
    }

    companion object{
        fun newInstance() = HomeFragment()
    }
}