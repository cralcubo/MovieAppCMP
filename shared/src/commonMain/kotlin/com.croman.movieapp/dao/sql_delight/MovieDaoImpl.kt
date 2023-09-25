package com.croman.movieapp.dao.sql_delight

import com.croman.MovieDatabase
import com.croman.MovieEntity
import com.croman.movieapp.dao.MovieDao

class MovieDaoImpl(database: MovieDatabase) : MovieDao {
    private val queries by lazy { database.movieQueries }
    override fun retrieveMovie(id: Int) =
        queries.retrieveMovie(id.toLong())
            .executeAsOneOrNull()

    override fun retrieveAllMovies() =
        queries.retrieveAllMovies()
            .executeAsList()

    override fun insertMovie(movie: MovieEntity) {
        queries.insertMovie(movie.id, movie.rating)
    }

}