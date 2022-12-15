package Functionality;

import Movie.Movie;

import java.sql.Time;
import java.util.*;

public class Rent {
    private int UserId;
    private Movie movie;
    private Date currentDate;
    private Date returnDate;
    private Time currentTime;
    private String rentPeriod;

    public void removeRentedMovie(List <Movie> userRentedMovies, Movie movie) {
        userRentedMovies.remove(movie);
    }

    public List<Movie> rentMovie(List<Movie> userRentedMovies, Movie movie){
        userRentedMovies.add(movie);
        return userRentedMovies;
    }

}