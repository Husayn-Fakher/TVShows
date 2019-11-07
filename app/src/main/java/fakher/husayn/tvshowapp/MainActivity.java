package fakher.husayn.tvshowapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import fakher.husayn.tvshowapp.Adapters.PagedMoviesAdapter;
import fakher.husayn.tvshowapp.Networking.ConnectionBroadcastReceiver;
import fakher.husayn.tvshowapp.ViewModels.MoviesViewModel;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private RecyclerView movieList;
    private ConnectionBroadcastReceiver networkStateReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Monitoring data connectivity
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        networkStateReceiver = new ConnectionBroadcastReceiver();
        registerReceiver(networkStateReceiver, filter);

        movieList = findViewById(R.id.movieList);
        MoviesViewModel moviesViewModel = ViewModelProviders.of(this).get(MoviesViewModel.class);
        moviesViewModel.getPagedListLiveData().observe(this, movie -> {
            PagedMoviesAdapter movieAdapter = new PagedMoviesAdapter(MainActivity.this);
            movieAdapter.submitList(movie);
            movieList.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            movieList.setAdapter(movieAdapter);
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(networkStateReceiver);
    }


}
