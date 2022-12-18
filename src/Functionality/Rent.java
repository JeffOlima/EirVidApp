package Functionality;

import Movie.Movie;
import Movie.BorrowedMovie;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class Rent {
    private int UserId;
    private Movie movie;
    private Date currentDate;
    private Date returnDate;
    private Time currentTime;
    private String rentPeriod;

 /*   public void removeRentedMovie(List<Movie> userRentedMovies, Movie movie) {
        userRentedMovies.remove(movie);
    }

    public List<Movie> rentMovie(List<BorrowedMovie> userRentedMovies, Movie movie, int rentPeriod){
        LocalDate rentDate = LocalDate.now(); // Create a date object;
        LocalDate returnDate = rentDate;
        LocalTime rentTime = LocalTime.now();
        LocalTime returnTime = LocalTime.;

        userRentedMovies.add(movie);
        return userRentedMovies;
    }

*/
    public void removeRentedMovie(List<Movie> userRentedMovies, Movie movie) {
        // printing the current time
        System.out.println(
                "Current time : "
                        + Calendar.getInstance().getTime());
        userRentedMovies.remove(movie);
        System.out.println("Movie " + movie.getTitle() + " was removed");
    }

    public List<Movie> rentMovie(List<Movie> userRentedMovies, Movie movie){
        userRentedMovies.add(movie);
        return userRentedMovies;
    }
}