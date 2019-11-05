package fakher.husayn.tvshowapp.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created By Fakher_Husayn on 05-Nov-19
 **/
public class Movie {

    @SerializedName("original_name")
    public String originalName;
    @SerializedName("genre_ids")
    public List<Integer> genreIds = null;
    @SerializedName("name")
    public String name;
    @SerializedName("popularity")
    public Double popularity;
    @SerializedName("origin_country")
    public List<String> originCountry = null;
    @SerializedName("vote_count")
    public Integer voteCount;
    @SerializedName("first_air_date")
    public String firstAirDate;
    @SerializedName("backdrop_path")
    public String backdropPath;
    @SerializedName("original_language")
    public String originalLanguage;
    @SerializedName("id")
    public Integer id;
    @SerializedName("vote_average")
    public Double voteAverage;
    @SerializedName("overview")
    public String overview;
    @SerializedName("poster_path")
    public String posterPath;
}
