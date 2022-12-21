package User;

import Movie.Movie;

import java.util.List;
/**
 *
 * @author Bekezhan Abdykarimov ( 2020297 )
 */

public interface User_Functionality {
    public Movie findMovie(List<Movie> movieList);
    public void rentMovie(List<Movie> moviesLibrary);
}
