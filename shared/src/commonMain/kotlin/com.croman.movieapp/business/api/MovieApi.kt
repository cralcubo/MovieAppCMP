package com.croman.movieapp.business.api

import com.croman.movieapp.model.api.ApiMovie

interface MovieApi {
    suspend fun retrieveMovies(): List<ApiMovie>
}