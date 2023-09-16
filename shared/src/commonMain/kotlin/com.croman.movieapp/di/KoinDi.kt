package com.croman.movieapp.di

import com.croman.movieapp.business.MovieService
import com.croman.movieapp.business.api.MovieApi
import com.croman.movieapp.business.api.tmdb.TmdbMovieApi
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.context.startKoin
import org.koin.dsl.module

private val httpClient =
    HttpClient {
        expectSuccess = true // if request was not successful an exception is thrown
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
    }

fun initKoin() = startKoin {
    modules(
        module { single{ httpClient } },
        module { single<MovieApi> { TmdbMovieApi(get()) } },
        module { single { MovieService(get()) } }
    )
}

