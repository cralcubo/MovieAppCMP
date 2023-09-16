package com.croman.movieapp.business

import com.croman.movieapp.business.api.MovieApi
import com.croman.movieapp.model.Movie

class MovieService(private val movieApi: MovieApi) {

    suspend fun retrieveMovies(): List<Movie> {
        return movieApi.retrieveMovies()
            .map { Movie(title = it.title, description = it.overview, posterPath = it.posterPath) }
    }

}