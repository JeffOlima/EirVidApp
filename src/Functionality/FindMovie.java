package Functionality;

import Movie.Movie;
import Movie.MovieList;

import java.io.IOException;
import java.util.List;

public class FindMovie {
    private List<Movie> movies;

    public Movie findMovie(String movieName) {

        MovieList movieList = new MovieList();
        try {
            movies = movieList.createMovieList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int i;
        for (i = 0; i < movies.size(); i++) {
            if (movies.get(i).getOriginal_title().matches(movieName)) {
                return movies.get(i);

            }
        }
        System.out.println("Sorry, couldn't find the movie: " + movieName);
        return null;
    }
}
