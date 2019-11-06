package fakher.husayn.tvshowapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import fakher.husayn.tvshowapp.Adapters.MoviesAdapter;
import fakher.husayn.tvshowapp.Model.Movie;
import fakher.husayn.tvshowapp.ViewModels.MoviesViewModel;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ArrayList<Movie> movieArrayList = new ArrayList<>();
    MoviesAdapter moviesAdapter;
    RecyclerView movieList;
    MoviesViewModel moviesViewModel;

    public static String TAG = "MyTVAppDebug";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieList = findViewById(R.id.movieList);

        moviesViewModel = ViewModelProviders.of(this).get(MoviesViewModel.class);
        moviesViewModel.init();
        moviesViewModel.getMoviesRepository().observe(this, moviesResponse -> {
            List<Movie> movies = moviesResponse.getMovies();
            movieArrayList.addAll(movies);
            moviesAdapter.notifyDataSetChanged();
        });
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        if (moviesAdapter == null) {
            moviesAdapter = new MoviesAdapter(MainActivity.this, movieArrayList);
            movieList.setLayoutManager(new LinearLayoutManager(this));
            movieList.setAdapter(moviesAdapter);
            movieList.setItemAnimator(new DefaultItemAnimator());
            movieList.setNestedScrollingEnabled(true);
        } else {
            moviesAdapter.notifyDataSetChanged();
        }
    }


}
