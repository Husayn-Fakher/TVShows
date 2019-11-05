package fakher.husayn.tvshowapp.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created By Fakher_Husayn on 05-Nov-19
 **/
public class MovieList {
    @SerializedName("page")
    public Integer page;
    @SerializedName("total_results")
    public Integer totalResults;
    @SerializedName("total_pages")
    public Integer totalPages;
    @SerializedName("results")
    public List<Movie> results = null;
}
