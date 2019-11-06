package fakher.husayn.tvshowapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import fakher.husayn.tvshowapp.Model.Movie;
import fakher.husayn.tvshowapp.R;

/**
 * Created By Fakher_Husayn on 06-Nov-19
 **/
public class PagedMoviesAdapter extends PagedListAdapter<Movie,PagedMoviesAdapter.MoviesViewHolder> {
    public static final String MOVIE_IMAGE_URL="https://image.tmdb.org/t/p/w500";
    Context context;


    public PagedMoviesAdapter(Context context) {
        super(Movie.CALLBACK);
        this.context = context;
    }
    @NonNull
    @Override
    public MoviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.movie_item, parent, false);
        return new MoviesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesViewHolder holder, int position) {

        holder.movieTitle.setText(getItem(position).originalName);
        holder.movieRating.setText(getItem(position).voteAverage+"/10");
        Picasso.get().load(MOVIE_IMAGE_URL + getItem(position).posterPath).into(holder.movieImage);
    }



    public class MoviesViewHolder extends RecyclerView.ViewHolder{

        TextView movieTitle;
        TextView movieRating;
        ImageView movieImage;

        public MoviesViewHolder(@NonNull View itemView) {
            super(itemView);

            movieTitle = itemView.findViewById(R.id.movie_title);
            movieRating = itemView.findViewById(R.id.rating);
            movieImage = itemView.findViewById(R.id.movie_image);

        }
    }
}
