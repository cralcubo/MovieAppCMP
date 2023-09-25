package com.croman.movieapp.model

data class Movie(
    val id: Int,
    val title: String,
    val description: String,
    val posterPath: String,
    val rating: Int = 0
)