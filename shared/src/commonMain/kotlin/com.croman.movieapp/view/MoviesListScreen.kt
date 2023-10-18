package com.croman.movieapp.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    Card(
        modifier = Modifier
//            .clickable(onClick = onClick) TODO
            .height(200.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Row(horizontalArrangement = Arrangement.Center) {
            KamelImage(
                resource = asyncPainterResource("$IMDB_POSTER_BASE_URL/${movie.posterPath}"),
                contentDescription = movie.description,
                modifier = Modifier.width(150.dp),
                contentScale = ContentScale.Fit
            )

            Column(modifier = Modifier.padding(8.dp)) {
                Text(text = movie.title, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                Text(text = "Rating: ${movie.rating}")
                Text(text = movie.description)
            }
        }
    }
}