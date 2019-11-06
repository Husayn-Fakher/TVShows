package fakher.husayn.tvshowapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import fakher.husayn.tvshowapp.Adapters.PagedMoviesAdapter;
import fakher.husayn.tvshowapp.Model.Movie;
import fakher.husayn.tvshowapp.ViewModels.MoviesViewModel;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    RecyclerView movieList;
    MoviesViewModel moviesViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieList = findViewById(R.id.movieList);
        moviesViewModel = ViewModelProviders.of(this).get(MoviesViewModel.class);
        moviesViewModel.getPagedListLiveData().observe(this, new Observer<PagedList<Movie>>() {
            @Override
            public void onChanged(@Nullable PagedList<Movie> movie) {
                PagedMoviesAdapter movieAdapter = new PagedMoviesAdapter(MainActivity.this);
                movieAdapter.submitList(movie);
                movieList.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                movieList.setAdapter(movieAdapter);
            }
        });
    }

}
