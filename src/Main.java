import Movie.Movie;
import Movie.MovieList;
import User.User;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Start");
        MovieList movieList = new MovieList();
        List<Movie> movies = movieList.createMovieList();
        movies.get(0).getMovie();
        User user = new User();
        user.findMovie("Heat").getMovie();
    }
}