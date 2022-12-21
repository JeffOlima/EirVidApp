/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functionality;

import Movie.Movie;

import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Bekezhan Abdykarimov ( 2020297 )
 */
public class Remove {
    public void removeRentedMovie(List<Movie> userRentedMovies, Movie movie) {
        userRentedMovies.remove(movie);
        System.out.println("Movie " + movie.getTitle() + " was removed \n" +
                "at (current time): "
                     + Calendar.getInstance().getTime());
              //  + Instant.now());
    }
}