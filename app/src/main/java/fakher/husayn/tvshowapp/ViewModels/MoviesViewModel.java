package fakher.husayn.tvshowapp.ViewModels;

import android.app.Application;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import fakher.husayn.tvshowapp.Model.Movie;
import fakher.husayn.tvshowapp.Model.MovieDataSource;
import fakher.husayn.tvshowapp.Model.MovieDataSourceFactory;
/**
 * Created By Fakher_Husayn on 06-Nov-19
 **/
public class MoviesViewModel extends AndroidViewModel {

    MovieDataSourceFactory movieDataSourceFactory;
    MutableLiveData<MovieDataSource> dataSourceMutableLiveData;
    Executor executor;
    LiveData<PagedList<Movie>> pagedListLiveData;

    public MoviesViewModel(@NonNull Application application) {
        super(application);

        movieDataSourceFactory = new MovieDataSourceFactory();
        dataSourceMutableLiveData = movieDataSourceFactory.getMutableLiveData();

        PagedList.Config config = (new PagedList.Config.Builder())
                .setEnablePlaceholders(true)
                .setInitialLoadSizeHint(10)
                .setPageSize(20)
                .setPrefetchDistance(4)
                .build();
        executor = Executors.newFixedThreadPool(5);
        pagedListLiveData = (new LivePagedListBuilder<Integer,Movie>(movieDataSourceFactory,config))
                .setFetchExecutor(executor)
                .build();
    }

    public LiveData<PagedList<Movie>> getPagedListLiveData() {
        return pagedListLiveData;
    }

}
