package fakher.husayn.tvshowapp.Networking;

/**
 * Created By Fakher_Husayn on 05-Nov-19
 **/


import fakher.husayn.tvshowapp.Model.MovieList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface APIInterface {
    @GET("tv/popular")
    Call<MovieList> doGetListResources(@Query("api_key") String api_key, @Query("language") String language,
                                       @Query("page") int currentPage);


}
