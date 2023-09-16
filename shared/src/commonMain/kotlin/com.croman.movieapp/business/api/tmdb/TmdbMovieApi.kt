package com.croman.movieapp.business.api.tmdb

import com.croman.movieapp.business.api.MovieApi
import com.croman.movieapp.model.api.ApiMovie
import com.croman.movieapp.model.api.Result
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.url

private const val BASE_URL = "https://api.themoviedb.org/3"
private const val GET_MOVIES_EP = "$BASE_URL/movie/popular"
private const val KEY = "645bf61561bf1fe3b3361c35e489b81f"
class TmdbMovieApi(private val httpClient: HttpClient) : MovieApi {
    override suspend fun retrieveMovies(): List<ApiMovie> {
        val result =  httpClient.get {
            url(GET_MOVIES_EP)
            parameter("api_key", KEY)
        }.body<Result>()

        return result.apiMovies
    }
}