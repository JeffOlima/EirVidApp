/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functionality;

import Movie.Movie;

import java.util.List;

/**
 *
 * @author Bekezhan Abdykarimov ( 2020297 )
 */

public class Rent {

    public List<Movie> rentMovie(List<Movie> userRentedMovies, Movie movie){
        userRentedMovies.add(movie);
        movie.rented();
        return userRentedMovies;
    }
}