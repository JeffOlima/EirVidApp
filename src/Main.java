import Movie.Movie;
import Movie.MovieList;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Start");
        MovieList movieList = new MovieList();
        List<Movie> movies = movieList.createMovieList();
        System.out.println(movies.get(0));
    }
}