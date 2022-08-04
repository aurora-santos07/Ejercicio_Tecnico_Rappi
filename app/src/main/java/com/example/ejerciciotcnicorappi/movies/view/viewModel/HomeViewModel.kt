package com.example.ejerciciotcnicorappi.movies.view.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ejerciciotcnicorappi.movies.data.MoviesResponse
import com.example.ejerciciotcnicorappi.movies.data.Results
import com.example.ejerciciotcnicorappi.movies.domain.GetRecomendedMoviesUseCase
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
    private val getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase,
    private val getRecomendedMoviesUseCase: GetRecomendedMoviesUseCase): ViewModel(){

    val compositeDisposable by lazy { CompositeDisposable() }

    private val _upcomingMoviesList = MutableLiveData<StateData>()
    val upcomingMoviesList: LiveData<StateData>
    get() = _upcomingMoviesList

    private val _topRatedMoviesList = MutableLiveData<StateData>()
    val topRatedMoviesList: LiveData<StateData>
    get() = _topRatedMoviesList

    private val _recomendedMoviesList = MutableLiveData<StateData>()
    val recomendedMoviesList: LiveData<StateData>
    get() = _recomendedMoviesList

    fun getUpcomingMovies(){
        val composite = getUpcomingMoviesUseCase.getUpcomingMoviesList()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .map { mapResponseToMovieUI(it) }
            .subscribe( {
                getUpcomingListSuccess(it)
            },
            {
                getUpcomingListError(it)
                it.printStackTrace()
            })
        compositeDisposable.add(composite)
    }

    fun getTopRatedMovies(){
        val composite = getTopRatedMoviesUseCase.getTopRatedMoviesList()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .map { mapResponseToMovieUI(it) }
            .doOnSuccess { it[0].idMovieUi?.let {getRecomendedMovies(it)} }
            .subscribe( {
                getTopRatedListSuccess(it)
            },
                {
                    getTopRatedListError(it)
                    it.printStackTrace()
                })
        compositeDisposable.add(composite)
    }

    fun getRecomendedMovies(movieID: Int){
            val composite = getRecomendedMoviesUseCase.getRecomendedMoviesUseCase(movieID)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map { mapResponseToMovieUI(it) }
                .subscribe( {
                    getRecomendedListSuccess(it.subList(0,6))
                },
                    {
                        getRecomendedListError(it)
                        it.printStackTrace()
                    })
        compositeDisposable.add(composite)
    }

    fun mapResponseToMovieUI(movieResponse: MoviesResponse): MutableList<MovieUI>{
        val movieTopUIList= mutableListOf<MovieUI>()
        movieResponse.results.forEach {
            var movieUI = MovieUI(it.id, it.posterPath)
            movieTopUIList.add(movieUI)
        }
        return movieTopUIList
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

    fun getRecomendedListSuccess(mutableList: MutableList<MovieUI>){
        _recomendedMoviesList.value = StateData.Success(mutableList)
    }

    fun getRecomendedListError(throwable: Throwable){
        _recomendedMoviesList.value = StateData.Error(throwable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}
