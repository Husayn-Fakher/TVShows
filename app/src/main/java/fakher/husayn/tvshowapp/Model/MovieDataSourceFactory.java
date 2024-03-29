package fakher.husayn.tvshowapp.Model;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

/**
 * Created By Fakher_Husayn on 06-Nov-19
 **/
public class MovieDataSourceFactory extends DataSource.Factory {

    private final MutableLiveData<MovieDataSource> mutableLiveData;

    public MovieDataSourceFactory() {
        mutableLiveData = new MutableLiveData<>();
    }

    @Override
    public DataSource create() {
        MovieDataSource movieDataSource = new MovieDataSource();
        mutableLiveData.postValue(movieDataSource);
        return movieDataSource;
    }


    public MutableLiveData<MovieDataSource> getMutableLiveData() {
        return mutableLiveData;
    }

}
