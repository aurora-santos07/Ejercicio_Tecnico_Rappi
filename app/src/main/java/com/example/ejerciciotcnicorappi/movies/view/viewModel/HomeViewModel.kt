package com.example.ejerciciotcnicorappi.movies.view.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ejerciciotcnicorappi.movies.data.Results
import com.example.ejerciciotcnicorappi.movies.domain.GetTopRatedMoviesUseCase
import com.example.ejerciciotcnicorappi.movies.domain.GetUpcomingMoviesUseCase
import com.example.ejerciciotcnicorappi.movies.view.StateData
import com.example.ejerciciotcnicorappi.movies.view.models.MovieUI
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val getUpcomingMoviesUseCase: GetUpcomingMoviesUseCase,
    private val getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase): ViewModel(){

    val compositeDisposable by lazy { CompositeDisposable() }
    private val _upcomingMoviesList = MutableLiveData<StateData>()
    val upcomingMoviesList: LiveData<StateData>
    get() = _upcomingMoviesList
    private val _topRatedMoviesList = MutableLiveData<StateData>()
    val topRatedMoviesList: LiveData<StateData>
    get() = _topRatedMoviesList

    fun getUpcomingMovies(){
        val composite = getUpcomingMoviesUseCase.getUpcomingMoviesList()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe( {
                val movieUIList= mutableListOf<MovieUI>()
                 it.results.forEach {
                     var movieUI = MovieUI(it.id, it.posterPath)
                     movieUIList.add(movieUI)
                 }
                getUpcomingListSuccess(movieUIList)
            },
            {
                getUpcomingListError(it)
                it.printStackTrace()
            })
    }

    fun getTopRatedMovies(){
        val composite = getTopRatedMoviesUseCase.getTopRatedMoviesList()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe( {
                val movieTopUIList= mutableListOf<MovieUI>()
                it.results.forEach {
                    var movieUI = MovieUI(it.id, it.posterPath)
                    movieTopUIList.add(movieUI)
                }
                getTopRatedListSuccess(movieTopUIList)
            },
                {
                    getTopRatedListError(it)
                    it.printStackTrace()
                })
    }


    fun getUpcomingListSuccess(mutableList: MutableList<MovieUI>){
        _upcomingMoviesList.value = StateData.Success(mutableList)
    }

    fun getUpcomingListError(throwable: Throwable){
        _upcomingMoviesList.value = StateData.Error(throwable)
    }

    fun getTopRatedListSuccess(mutableList: MutableList<MovieUI>){
        _topRatedMoviesList.value = StateData.Success(mutableList)
    }

    fun getTopRatedListError(throwable: Throwable){
        _topRatedMoviesList.value = StateData.Error(throwable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}
