package com.example.ejerciciotcnicorappi.movies.view.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ejerciciotcnicorappi.movies.data.Genres
import com.example.ejerciciotcnicorappi.movies.data.MovieDetailResponse
import com.example.ejerciciotcnicorappi.movies.data.remote.MoviesVideoResponse
import com.example.ejerciciotcnicorappi.movies.domain.GetMovieDetailUseCase
import com.example.ejerciciotcnicorappi.movies.domain.GetMovieVideosUseCase
import com.example.ejerciciotcnicorappi.movies.view.StateData
import com.example.ejerciciotcnicorappi.movies.view.models.MovieDetailUI
import com.example.ejerciciotcnicorappi.movies.view.models.MovieVideosUI
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class MovieDetailViewModel @Inject constructor(
    private val movieDetailUseCase: GetMovieDetailUseCase,
    private val movieVideosUseCase: GetMovieVideosUseCase): ViewModel() {

    private val compositeDisposable by lazy { CompositeDisposable() }
    private val _movieDetail = MutableLiveData<StateData>()
    val movieDetail: LiveData<StateData>
    get() = _movieDetail
    private val _movieVideos = MutableLiveData<StateData>()
    val movieVideos: LiveData<StateData>
    get() = _movieVideos

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

    fun getMovieVideos(idMovie: Int){
        val compose = movieVideosUseCase.getMovieVideosUseCase(idMovie)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .map { videosToMovieVideosUi(it) }
            .subscribe({
                getMovieVideosSuccess(it)
            },{
                getMovieVideosError(it)
            })
        compositeDisposable.add(compose)
    }

    private fun getMovieDetailSuccess(detail: MovieDetailUI){
        _movieDetail.value = StateData.Success(detail)
    }

    private fun getMovieDetailError(throwable: Throwable){
        _movieDetail.value = StateData.Error(throwable)
        throwable.printStackTrace()
    }

    private fun getMovieVideosSuccess(videos: MovieVideosUI){
        _movieVideos.value = StateData.Success(videos)
    }

    private fun getMovieVideosError(throwable: Throwable){
        _movieVideos.value = StateData.Error(throwable)
        throwable.printStackTrace()
    }

    private fun detailToMovieDetailUi(detailResponse: MovieDetailResponse): MovieDetailUI = MovieDetailUI(
            detailResponse.title,
            detailResponse.releaseDate,
            detailResponse.originalLanguage,
            detailResponse.popularity,
            generesToStringLis(detailResponse.genres),
            detailResponse.posterPath,
            detailResponse.overview)

    private fun videosToMovieVideosUi(videosResponse: MoviesVideoResponse): MovieVideosUI =
        MovieVideosUI(
            videosResponse.results[0].site,
            videosResponse.results[0].key)


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