package com.croman.movieapp.model.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Result(
    @SerialName("results")
    val apiMovies: List<ApiMovie>
)