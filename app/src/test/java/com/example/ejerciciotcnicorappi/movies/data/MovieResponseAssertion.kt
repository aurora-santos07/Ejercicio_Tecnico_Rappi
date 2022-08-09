package com.example.ejerciciotcnicorappi.movies.data

import com.example.ejerciciotcnicorappi.movies.data.remote.MoviesVideoResponse
import com.example.ejerciciotcnicorappi.movies.data.remote.VideoResults
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert

fun assertUpcommingMoviesResponse(moviesResponse: MoviesResponse) = moviesResponse.run {
    MatcherAssert.assertThat(dates, CoreMatchers.equalTo(
        Dates("2022-09-03", "2022-08-07")))
    MatcherAssert.assertThat(page, CoreMatchers.equalTo(1))
    assertMovieResultResponse(listOf<Results>(
        Results(false,
            "/nmGWzTLMXy9x7mKd8NKPLmHtWGa.jpg",
            arrayListOf(10751,16,12,35,14),
            438148,
            "en",
            "Minions: The Rise of Gru",
            "A fanboy of a supervillain supergroup known as the Vicious 6, Gru hatches a plan to become evil enough to join them, with the backup of his followers, the Minions.",
            7369.381,
            "/wKiOkZTN9lUUUNZLmtnwubZYONg.jpg",
            "2022-06-29",
            "Minions: The Rise of Gru",
            false,
            7.8,
            1058
    )))
    MatcherAssert.assertThat(totalPages, CoreMatchers.equalTo(24))
    MatcherAssert.assertThat(totalResults, CoreMatchers.equalTo(473))
}

private fun assertMovieResultResponse(results: List<Results>) = results?.run {
    MatcherAssert.assertThat(first().adult, CoreMatchers.equalTo( false))
    MatcherAssert.assertThat(first().backdropPath,
        CoreMatchers.equalTo("/nmGWzTLMXy9x7mKd8NKPLmHtWGa.jpg"))
    MatcherAssert.assertThat(first().genreIds, CoreMatchers.equalTo(listOf(10751,16,12,35,14)))
    MatcherAssert.assertThat(first().id, CoreMatchers.equalTo(438148))
    MatcherAssert.assertThat(first().originalLanguage, CoreMatchers.equalTo("en"))
    MatcherAssert.assertThat(first().originalTitle,
        CoreMatchers.equalTo("Minions: The Rise of Gru"))
    MatcherAssert.assertThat(first().overview,
        CoreMatchers.equalTo(
            "A fanboy of a supervillain supergroup known as the Vicious 6, Gru hatches a plan to become evil enough to join them, with the backup of his followers, the Minions."))
    MatcherAssert.assertThat(first().popularity, CoreMatchers.equalTo(7369.381))
    MatcherAssert.assertThat(first().posterPath,
        CoreMatchers.equalTo("/wKiOkZTN9lUUUNZLmtnwubZYONg.jpg"))
    MatcherAssert.assertThat(first().releaseDate, CoreMatchers.equalTo("2022-06-29"))
    MatcherAssert.assertThat(first().title, CoreMatchers.equalTo("Minions: The Rise of Gru"))
    MatcherAssert.assertThat(first().video, CoreMatchers.equalTo(false))
    MatcherAssert.assertThat(first().voteAverage, CoreMatchers.equalTo( 7.8))
    MatcherAssert.assertThat(first().voteCount, CoreMatchers.equalTo(1058))
}


fun assertMovieDetailResponse(movieDetailResponse: MovieDetailResponse) = movieDetailResponse.run {
    MatcherAssert.assertThat(adult, CoreMatchers.equalTo( false))
    MatcherAssert.assertThat(backdropPath,
        CoreMatchers.equalTo("/nmGWzTLMXy9x7mKd8NKPLmHtWGa.jpg"))
    assertBelongToCollection(
        BelongsToCollection(544669,
            "Minions  - Colección",
            "/yG4ZgrIinuQJGuFQfXZc1fB2UHN.jpg",
            "/62Qe28oi9PaK3P2ljDYUDTGAyST.jpg"))
    MatcherAssert.assertThat(budget, CoreMatchers.equalTo(85000000))
    assertGenresList(arrayListOf(Genres(10751, "Familia")) )
    MatcherAssert.assertThat(homepage, CoreMatchers.equalTo(""))
    MatcherAssert.assertThat(id, CoreMatchers.equalTo(438148))
    MatcherAssert.assertThat(imdbId, CoreMatchers.equalTo("tt5113044"))
    MatcherAssert.assertThat(originalLanguage, CoreMatchers.equalTo("en"))
    MatcherAssert.assertThat(originalTitle,
        CoreMatchers.equalTo("Minions:The Rise of Gru"))
    MatcherAssert.assertThat(overview,
        CoreMatchers.equalTo(
            "Mucho antes de convertirse en un genio del mal, Gru no era más que un niño de " +
                    "12 años en plenos años 70 tratando de conquistar el mundo desde el sótano de su" +
                    " casa de un barrio residencial cualquiera. Y no le iba demasiado bien. Pero " +
                    "cuando Gru se cruza en su camino con Kevin, Stuart, Bob, y Otto —un nuevo Minion" +
                    " con aparato en los dientes y desesperado por sentirse aceptado—, esta " +
                    "inesperada familia unirá fuerzas para construir su primera guarida, diseñar sus " +
                    "primeras armas y llevar a cabo sus primeras misiones."))
    MatcherAssert.assertThat(popularity, CoreMatchers.equalTo(5730.974))
    MatcherAssert.assertThat(posterPath, CoreMatchers.equalTo("/zBk0guZ6NI2aHclb4sbrQdrrnOC.jpg"))
    assertProductionCompaniesList(arrayListOf(
        ProductionCompanies(
            33, "/8lvHyhjr8oUKOOy2dKXoALWKdp0.png", "Universal Pictures", "US")
    ))
    assertCountriesList(arrayListOf(ProductionCountries("US", "United States of America")))
    MatcherAssert.assertThat(releaseDate, CoreMatchers.equalTo("2022-06-29"))
    MatcherAssert.assertThat(revenue, CoreMatchers.equalTo(718000000))
    MatcherAssert.assertThat(runtime, CoreMatchers.equalTo(87))
    assertSpokenLanguagesList(arrayListOf(SpokenLanguages("English", "en", "English")))
    MatcherAssert.assertThat(status, CoreMatchers.equalTo("Released"))
    MatcherAssert.assertThat(tagline, CoreMatchers.equalTo("Prepárate"))
    MatcherAssert.assertThat(title, CoreMatchers.equalTo("Minions:Nace un villano"))
    MatcherAssert.assertThat(video, CoreMatchers.equalTo(false))
    MatcherAssert.assertThat(voteAverage, CoreMatchers.equalTo( 7.769))
    MatcherAssert.assertThat(voteCount, CoreMatchers.equalTo(1118))
}

fun assertBelongToCollection(belongsToCollection: BelongsToCollection) = belongsToCollection?.run {
    MatcherAssert.assertThat(id, CoreMatchers.equalTo(544669))
    MatcherAssert.assertThat(name, CoreMatchers.equalTo("Minions  - Colección"))
    MatcherAssert.assertThat(posterPath, CoreMatchers.equalTo("/yG4ZgrIinuQJGuFQfXZc1fB2UHN.jpg"))
    MatcherAssert.assertThat(backdropPath, CoreMatchers.equalTo("/62Qe28oi9PaK3P2ljDYUDTGAyST.jpg"))
}

fun assertGenresList(arrayGenres : ArrayList<Genres>) = arrayGenres?.run {
    MatcherAssert.assertThat(first().id, CoreMatchers.equalTo(10751))
    MatcherAssert.assertThat(first().name, CoreMatchers.equalTo("Familia"))
}

fun assertProductionCompaniesList(arrayCompanies : ArrayList<ProductionCompanies>) = arrayCompanies?.run {
    MatcherAssert.assertThat(first().id, CoreMatchers.equalTo(33))
    MatcherAssert.assertThat(first().name, CoreMatchers.equalTo("Universal Pictures"))
    MatcherAssert.assertThat(first().logoPath, CoreMatchers.equalTo("/8lvHyhjr8oUKOOy2dKXoALWKdp0.png"))
    MatcherAssert.assertThat(first().originCountry, CoreMatchers.equalTo("US"))
}

fun assertCountriesList(arrayCountries : ArrayList<ProductionCountries>) = arrayCountries?.run {
    MatcherAssert.assertThat(first().iso31661, CoreMatchers.equalTo("US"))
    MatcherAssert.assertThat(first().name, CoreMatchers.equalTo("United States of America"))
}

fun assertSpokenLanguagesList(arrayLanguages: ArrayList<SpokenLanguages>) = arrayLanguages?.run {
    MatcherAssert.assertThat(first().englishName, CoreMatchers.equalTo("English"))
    MatcherAssert.assertThat(first().iso6391, CoreMatchers.equalTo("en"))
    MatcherAssert.assertThat(first().name, CoreMatchers.equalTo("English"))
}

fun assertVideosMovieResponse(videoResponse: MoviesVideoResponse) = videoResponse?.run {
    MatcherAssert.assertThat(id, CoreMatchers.equalTo(19404))
    assertVideoResultList(
        arrayListOf(
            VideoResults(
        "es",
        "MX",
        "Amor contra viento y marea - Trailer",
        "OjATPq2UTtU",
        "YouTube",
        720,
        "Trailer",
        false,
        "2014-01-06T04:21:04.000Z",
        "5bcd82050e0a26016e01d68b"
    )))
}

fun assertVideoResultList(results: ArrayList<VideoResults>) = results?.run {
    MatcherAssert.assertThat(first().iso6391, CoreMatchers.equalTo("es"))
    MatcherAssert.assertThat(first().iso31661, CoreMatchers.equalTo("MX"))
    MatcherAssert.assertThat(first().name, CoreMatchers.equalTo("Amor contra viento y marea - Trailer"))
    MatcherAssert.assertThat(first().key, CoreMatchers.equalTo("OjATPq2UTtU"))
    MatcherAssert.assertThat(first().publishedAt, CoreMatchers.equalTo("2014-01-06T04:21:04.000Z"))
    MatcherAssert.assertThat(first().site, CoreMatchers.equalTo("YouTube"))
    MatcherAssert.assertThat(first().size, CoreMatchers.equalTo(720))
    MatcherAssert.assertThat(first().type, CoreMatchers.equalTo("Trailer"))
    MatcherAssert.assertThat(first().official, CoreMatchers.equalTo(false))
    MatcherAssert.assertThat(first().id, CoreMatchers.equalTo("5bcd82050e0a26016e01d68b"))
}
