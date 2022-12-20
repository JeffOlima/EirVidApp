package Functionality;

import Movie.Movie;
import Movie.MovieList;

import java.io.IOException;
import java.util.List;

public class FindMovie {

    private int movieIndex;


    public Movie findMovie(String movieName, List<Movie> movies) {

        for (Movie movie : movies) {
            if (movie.getOriginal_title().equals(movieName)) {
                return  movie;

            }
        }
        return null;
    }
    public int getMovieIndex() {
        return movieIndex;
    }

    public void setMovieIndex(int movieIndex) {
        this.movieIndex = movieIndex;
    }
    /*
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
        return null;
    }*/
}
