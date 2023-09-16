package com.croman.movieapp.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.croman.movieapp.model.Movie
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource

@Composable
fun MoviesListView(movies: List<Movie>) {
    LazyColumn {
        items(movies) {
            MovieCard(movie = it)
        }
    }
}

private const val IMDB_POSTER_BASE_URL = "https://image.tmdb.org/t/p/w500"
@Composable
fun MovieCard(movie: Movie) {
    Box {
        KamelImage(
            resource = asyncPainterResource("$IMDB_POSTER_BASE_URL/${movie.posterPath}"),
            contentDescription = movie.description
        )
        Text(text = movie.title)
    }

}