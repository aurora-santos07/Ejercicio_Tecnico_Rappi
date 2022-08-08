package com.example.ejerciciotcnicorappi.movies.view.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ejerciciotcnicorappi.movies.data.Genres
import com.example.ejerciciotcnicorappi.movies.data.MovieDetailResponse
import com.example.ejerciciotcnicorappi.movies.domain.GetMovieDetailUseCase
import com.example.ejerciciotcnicorappi.movies.view.StateData
import com.example.ejerciciotcnicorappi.movies.view.models.MovieDetailUI
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class MovieDetailViewModel @Inject constructor(
    private val movieDetailUseCase: GetMovieDetailUseCase): ViewModel() {

    private val compositeDisposable by lazy { CompositeDisposable() }
    private val _movieDetail = MutableLiveData<StateData>()
    val movieDetail: LiveData<StateData>
    get() = _movieDetail

    fun getMovieDetail(idMovie: Int){
        val compose = movieDetailUseCase.getMovieDetailUseCase(idMovie)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .map { detailToMovieDetailUi(it) }
            .subscribe({
                getMovieDetailSuccess(it)
            },{
                getMovieDetailError(it)
            })
        compositeDisposable.add(compose)
    }

    private fun getMovieDetailSuccess(detail: MovieDetailUI){
        _movieDetail.value = StateData.Success(detail)
    }

    private fun getMovieDetailError(throwable: Throwable){
        _movieDetail.value = StateData.Error(throwable)
    }

    private fun detailToMovieDetailUi(detailResponse: MovieDetailResponse): MovieDetailUI = MovieDetailUI(
            detailResponse.title,
            detailResponse.releaseDate,
            detailResponse.originalLanguage,
            detailResponse.popularity,
            generesToStringLis(detailResponse.genres),
            detailResponse.posterPath,
            detailResponse.overview)

    private fun generesToStringLis(genres: ArrayList<Genres>): ArrayList<String>{
        val genreString = ArrayList<String>()
        for (genre: Genres in genres){
            genre.name?.let { genreString.add(it) }
        }
        return genreString
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}