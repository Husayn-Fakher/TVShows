package fakher.husayn.tvshowapp.Networking;

import android.util.Log;
import java.util.List;
import androidx.lifecycle.MutableLiveData;
import fakher.husayn.tvshowapp.Model.Movie;
import fakher.husayn.tvshowapp.Model.MovieList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created By Fakher_Husayn on 06-Nov-19
 **/
public class MoviesRepository {

    private static MoviesRepository moviesRepository;
    public static String TAG = "MyTVAppDebug";


    public static MoviesRepository getInstance(){
        if (moviesRepository == null){
            moviesRepository = new MoviesRepository();
        }
        return moviesRepository;
    }

    private APIInterface apiInterface;;

    public MoviesRepository(){
        apiInterface =  APIClient.getClient().create(APIInterface.class);
    }


    public MutableLiveData<MovieList> getMovies( String key, String language,int page){
        MutableLiveData<MovieList> movies = new MutableLiveData<>();
        apiInterface.doGetListResources(key,language,page).enqueue(new Callback<MovieList>() {
            @Override
            public void onResponse(Call<MovieList> call,
                                   Response<MovieList> response) {
                if (response.isSuccessful()){

                    MovieList resource = response.body();
                    List<Movie> movies = resource.results;
                    // Making sure we are getting the data
                    Log.d(TAG,movies.get(0).name);
                }
            }

            @Override
            public void onFailure(Call<MovieList> call, Throwable t) {
                Log.d(TAG,t.getMessage());
                call.cancel();
            }
        });
        return movies;
    }

}




