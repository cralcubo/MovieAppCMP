package com.croman.movieapp.di

import com.croman.movieapp.business.MovieService
import com.croman.movieapp.business.api.MovieApi
import com.croman.movieapp.business.api.tmdb.TmdbMovieApi
import com.croman.movieapp.view.MovieViewModel
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.definition.Definition
import org.koin.core.definition.KoinDefinition
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.qualifier.Qualifier
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

fun appModule() = module {
    single { httpClient }
    single<MovieApi> { TmdbMovieApi(get()) }
    singleOf(::MovieService)
    viewModelDefinition { MovieViewModel(get()) }
}
expect inline fun <reified T : ViewModel> Module.viewModelDefinition(
    qualifier: Qualifier? = null,
    noinline definition: Definition<T>
): KoinDefinition<T>