package fakher.husayn.tvshowapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import fakher.husayn.tvshowapp.Model.Movie;
import fakher.husayn.tvshowapp.ViewModels.MoviesViewModel;
import android.os.Bundle;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    MoviesViewModel moviesViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moviesViewModel = ViewModelProviders.of(this).get(MoviesViewModel.class);
        moviesViewModel.init();
        moviesViewModel.getMoviesRepository().observe(this, moviesResponse -> {
            List<Movie> movies = moviesResponse.getMovies();

        });

    }
}
