package fakher.husayn.tvshowapp;

import androidx.appcompat.app.AppCompatActivity;
import fakher.husayn.tvshowapp.Model.Movie;
import fakher.husayn.tvshowapp.Model.MovieList;
import fakher.husayn.tvshowapp.Networking.APIClient;
import fakher.husayn.tvshowapp.Networking.APIInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import android.os.Bundle;
import android.util.Log;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    APIInterface apiInterface;
    public static String apiKey = "5d967c7c335764f39b1efbe9c5de9760";
    public static String TAG = "MyTVAppDebug";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiInterface = APIClient.getClient().create(APIInterface.class);

        /**
         GET Movie List
         **/
        Call<MovieList> call = apiInterface.doGetListResources(apiKey,"en",1);
        call.enqueue(new Callback<MovieList>() {
            @Override
            public void onResponse(Call<MovieList> call, Response<MovieList> response) {

                MovieList resource = response.body();
                List<Movie> movies = resource.results;
                // Making sure we are getting the data
                Log.d(TAG,movies.get(0).name);
            }

            @Override
            public void onFailure(Call<MovieList> call, Throwable t) {

                Log.d(TAG,t.getMessage());
                call.cancel();
            }
        });
    }
}
