import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.croman.movieapp.business.MovieService
import com.croman.movieapp.business.api.tmdb.TmdbMovieApi
import com.croman.movieapp.view.MovieViewModel
import com.croman.movieapp.view.MoviesListView
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

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

@Composable
fun App() {
    MaterialTheme {
        val viewModel = getViewModel(Unit, viewModelFactory { MovieViewModel(
            MovieService(
                TmdbMovieApi(httpClient)
            )
        ) })

        MainScreen(viewModel)
    }
}

@Composable
fun MainScreen(viewModel: MovieViewModel) {
    val movieState by viewModel.movieState.collectAsState()
    MoviesListView(movies = movieState)
}