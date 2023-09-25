package com.croman.movieapp.business

import com.croman.movieapp.business.api.MovieApi
import com.croman.movieapp.dao.MovieDao
import com.croman.movieapp.model.Movie

class MovieService(private val movieApi: MovieApi, private val movieDao: MovieDao) {

    suspend fun retrieveMovies(): List<Movie> {

        return movieApi.retrieveMovies()
            .map { Movie(
                id = it.id,
                title = it.title,
                description = it.overview,
                posterPath = it.posterPath,
                rating = movieDao.retrieveMovie(it.id)?.rating?.toInt() ?: 0
                ) }
    }

}