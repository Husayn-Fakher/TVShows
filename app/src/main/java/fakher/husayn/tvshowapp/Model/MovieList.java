package fakher.husayn.tvshowapp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created By Fakher_Husayn on 05-Nov-19
 **/
public class MovieList {
    @SerializedName("page")
    @Expose
    public Integer page;
    @SerializedName("total_results")
    @Expose
    public Integer totalResults;
    @SerializedName("total_pages")
    @Expose
    public Integer totalPages;
    @SerializedName("results")
    @Expose
    public List<Movie> results = null;

    public List<Movie> getMovies() {
        return results;
    }
}
