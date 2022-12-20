package Functionality;

import Movie.Movie;

import java.time.Instant;
import java.util.*;

public class Rent {

    public List<Movie> rentMovie(List<Movie> userRentedMovies, Movie movie){
        userRentedMovies.add(movie);
        movie.rented();
        return userRentedMovies;
    }
}