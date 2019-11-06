package fakher.husayn.tvshowapp.Model;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;
import fakher.husayn.tvshowapp.Networking.APIClient;
import fakher.husayn.tvshowapp.Networking.APIInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created By Fakher_Husayn on 06-Nov-19
 **/
public class MovieDataSource extends PageKeyedDataSource<Integer,Movie> {

    APIInterface apiInterface;
    public static String TAG = "MyTVAppDebug";
    public static String apiKey = "5d967c7c335764f39b1efbe9c5de9760";

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, Movie> callback) {

        apiInterface =  APIClient.getClient().create(APIInterface.class);
        apiInterface.doGetListResources(apiKey,"en",1).enqueue(new Callback<MovieList>() {
            @Override
            public void onResponse(Call<MovieList> call,
                                   Response<MovieList> response) {
                if (response.isSuccessful()){

                    MovieList movieList = response.body();
                    callback.onResult(movieList.getMovies(),null,2);
                }
            }

            @Override
            public void onFailure(Call<MovieList> call, Throwable t) {
                Log.d(TAG,t.getMessage());
                call.cancel();
            }
        });

    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Movie> callback) {

    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Movie> callback) {

        apiInterface =  APIClient.getClient().create(APIInterface.class);
        apiInterface.doGetListResources(apiKey,"en",params.key).enqueue(new Callback<MovieList>() {
            @Override
            public void onResponse(Call<MovieList> call,
                                   Response<MovieList> response) {
                if (response.isSuccessful()){

                    MovieList movieList = response.body();
                    callback.onResult(movieList.getMovies(),params.key+1);
                }
            }

            @Override
            public void onFailure(Call<MovieList> call, Throwable t) {
                Log.d(TAG,t.getMessage());
                call.cancel();
            }
        });
    }
}
