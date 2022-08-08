package com.example.ejerciciotcnicorappi.movies.view.models

data class MovieDetailUI(
    val title: String?,
    var dateRelease: String?,
    val originalLanguage: String?,
    val popularity: Double?,
    val generes: ArrayList<String>?,
    val posterPath: String?,
    val overview: String?) {
}
