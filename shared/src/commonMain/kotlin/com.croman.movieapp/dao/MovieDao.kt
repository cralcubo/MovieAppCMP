package com.croman.movieapp.dao

import com.croman.MovieEntity


interface MovieDao {
    fun retrieveMovie(id: Int) : MovieEntity?

    fun retrieveAllMovies() : List<MovieEntity>

    fun insertMovie(movie: MovieEntity)
}