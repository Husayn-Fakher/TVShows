package fakher.husayn.tvshowapp.ViewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import fakher.husayn.tvshowapp.Model.MovieList;
import fakher.husayn.tvshowapp.Networking.MoviesRepository;

/**
 * Created By Fakher_Husayn on 06-Nov-19
 **/
public class MoviesViewModel extends ViewModel {

    private MutableLiveData<MovieList> mutableLiveData;
    private MoviesRepository moviesRepository;
    public static String apiKey = "5d967c7c335764f39b1efbe9c5de9760";

    public void init(){
        if (mutableLiveData != null){
            return;
        }
        moviesRepository = MoviesRepository.getInstance();
        mutableLiveData = moviesRepository.getMovies(apiKey, "en",1);

    }

    public LiveData<MovieList> getMoviesRepository() {
        return mutableLiveData;
    }

}
