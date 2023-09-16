package com.croman.movieapp.view

import com.croman.movieapp.business.MovieService
import com.croman.movieapp.model.Movie
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MovieViewModel(private val movieService: MovieService) : ViewModel() {
    private val mutableState = MutableStateFlow(emptyList<Movie>())
    val movieState: StateFlow<List<Movie>> by ::mutableState

    init {
        viewModelScope.launch {
            mutableState.value = movieService.retrieveMovies()
        }
    }

}