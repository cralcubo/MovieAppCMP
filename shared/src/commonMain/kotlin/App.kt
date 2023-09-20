import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.croman.movieapp.di.appModule
import com.croman.movieapp.view.MovieViewModel
import com.croman.movieapp.view.MoviesListView
import org.koin.compose.KoinApplication
import org.koin.compose.koinInject

@Composable
fun App() {
    KoinApplication(application = {
        this.modules(appModule())
    }) {
        MaterialTheme {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen(viewModel: MovieViewModel = koinInject()) {
    val movieState by viewModel.movieState.collectAsState()
    MoviesListView(movies = movieState)
}