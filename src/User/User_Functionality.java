package User;

import Movie.Movie;

import java.util.List;

public interface User_Functionality {
    public Movie findMovie(List<Movie> movieList);
    public void rentMovie(List<Movie> moviesLibrary);
}
