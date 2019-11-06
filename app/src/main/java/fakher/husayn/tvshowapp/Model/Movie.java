package fakher.husayn.tvshowapp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created By Fakher_Husayn on 05-Nov-19
 **/
public class Movie {

    @SerializedName("original_name")
    @Expose
    public String originalName;
    @SerializedName("genre_ids")
    @Expose
    public List<Integer> genreIds = null;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("popularity")
    @Expose
    public Double popularity;
    @SerializedName("origin_country")
    @Expose
    public List<String> originCountry = null;
    @SerializedName("vote_count")
    @Expose
    public Integer voteCount;
    @SerializedName("first_air_date")
    @Expose
    public String firstAirDate;
    @SerializedName("backdrop_path")
    @Expose
    public String backdropPath;
    @SerializedName("original_language")
    @Expose
    public String originalLanguage;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("vote_average")
    @Expose
    public Double voteAverage;
    @SerializedName("overview")
    @Expose
    public String overview;
    @SerializedName("poster_path")
    @Expose
    public String posterPath;
}
